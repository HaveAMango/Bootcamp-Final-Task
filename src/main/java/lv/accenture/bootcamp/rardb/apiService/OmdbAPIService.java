package lv.accenture.bootcamp.rardb.apiService;

import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;

import java.util.List;

import org.springframework.stereotype.Service;


import com.google.gson.Gson;




//import org.json.JSONObject;


@Service
public class OmdbAPIService {


	private String requestUrl = "http://www.omdbapi.com/?apikey=fe474bfb";

	public List<SearchResult> getFilm(String requestedFilm) {
		try {
			URL url = new URL(requestUrl + "&s=" + requestedFilm);
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
			
			Gson gson = new Gson();
			SearchResponse response = gson.fromJson(jsonResponse, SearchResponse.class);
			List<SearchResult> searchList = response.getSearch();
			return searchList;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
