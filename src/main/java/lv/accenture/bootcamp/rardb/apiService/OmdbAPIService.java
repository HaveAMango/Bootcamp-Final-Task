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

import lv.accenture.bootcamp.rardb.model.Movie;

@Service
public class OmdbAPIService {

	//DONE - TODO : consider constant-style for this variables  (private final static REQUEST_URL = ... )
	private final static String REQUEST_URL = "http://www.omdbapi.com/?apikey=fe474bfb";
	private final static String SEARCH_BY_TITLE = "&t=";
	private final static String SEARCH_GENERAL = "&s=";
	private final static String SEARCH_BY_ID = "&i=";

	//DONE - TODO : 1) extremely not thread-safe 2) easy to be converted to local variable
	//private List<SearchResult> searchList = null;
	
	public String checkTitle(String Title) {
		if (Title.contains(" ")) {
			//DONE - TODO: to get well-formed URL in case when title contains whitespace, use .replaceAll(" ", "%20")
			// check on contains is redundant - replaceAll already checks it
			Title = Title.replaceAll(" ", "%20");
		}
		return Title;
	}
	public String getApiResponse(String requestedFilm, String searchType) {	
		try {

			URL url = new URL(REQUEST_URL + searchType + requestedFilm);
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
		List<SearchResult> searchList = new ArrayList<SearchResult>();
		requestedFilm = checkTitle(requestedFilm);
		Gson gson = new Gson();
		if (requestedFilm.length() <=2) {
			SearchResult searchResult = getFilmByTitle(requestedFilm,gson);
			searchList.add(searchResult);
			return searchList;
		} else {
		String jsonResponse = getApiResponse(requestedFilm, SEARCH_GENERAL);
		SearchResponse response = gson.fromJson(jsonResponse, SearchResponse.class);
		if (response.getResponse()) {
			searchList = response.getSearch();
		}
		return searchList;
		}

	}
	
	
	public SearchResult getFilmByTitle(String requestedFilm, Gson gson) {
			String jsonResponse = getApiResponse(requestedFilm, SEARCH_BY_TITLE);
			SearchResult searchResult = gson.fromJson(jsonResponse, SearchResult.class);
			return searchResult;

	}

	public Movie getInfoFromOmdb(String imdbID) {
		Gson gson = new Gson();
		String jsonResponse = getApiResponse(imdbID, SEARCH_BY_ID);
		SearchResult searchResult = gson.fromJson(jsonResponse, SearchResult.class);
		Movie movie = new Movie();
		movie.setImdbId(imdbID);
		if (!searchResult.getPoster().equals("N/A")) {
			movie.setPoster(searchResult.getPoster());
		}
		movie.setTitle(searchResult.getTitle());
		movie.setImdbRating(searchResult.getImdbRating());
		return movie;

}
	
}
