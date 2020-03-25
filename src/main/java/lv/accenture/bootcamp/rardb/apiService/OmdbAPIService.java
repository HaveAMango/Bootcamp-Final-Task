package lv.accenture.bootcamp.rardb.apiService;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class OmdbAPIService {

	private String requestUrl = "http://www.omdbapi.com/?apikey=fe474bfb";
	private String searchByTitle = "&t=";
	private String searchGeneral = "&s=";
	private String searchById = "&i=";
	private List<SearchResult> searchList = null;
	
	public String checkTitle(String Title) {
		if (Title.contains(" ")) {
			Title = Title.replaceAll(" ", "&");
		}
		return Title;
	}
	public String getApiResponse(String requestedFilm, String searchType) {	
		try {

			URL url = new URL(requestUrl + searchType + requestedFilm);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setReadTimeout(3000);
			urlConnection.connect();

			InputStream inputStream = urlConnection.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				sb.append(line + "\n");
			}

			String jsonResponse = sb.toString();
			bufferedReader.close();

			return jsonResponse;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<SearchResult> getFilmList(String requestedFilm) {
		searchList = new ArrayList<SearchResult>();
		requestedFilm = checkTitle(requestedFilm);
		Gson gson = new Gson();
		if (requestedFilm.length() <=2) {
			SearchResult searchResult = getFilmByTitle(requestedFilm,gson);
			searchList.add(searchResult);
			return searchList;
		} else {
		String jsonResponse = getApiResponse(requestedFilm, searchGeneral);
		SearchResponse response = gson.fromJson(jsonResponse, SearchResponse.class);
		if (response.getResponse()) {
			searchList = response.getSearch();
		}
		return searchList;
		}

	}
	
	
	public SearchResult getFilmByTitle(String requestedFilm, Gson gson) {
			String jsonResponse = getApiResponse(requestedFilm, searchByTitle);
			SearchResult searchResult = gson.fromJson(jsonResponse, SearchResult.class);
			return searchResult;

	}

}
