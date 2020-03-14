package lv.accenture.bootcamp.apiService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;
import java.net.URLEncoder;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;



//import org.json.JSONObject;



@Component
public class OmdbAPIService {

	@Value("${api.request}")
	private String requestUrl = "http://www.omdbapi.com/?apikey=fe474bfb";

	public void getFilm(String requestedFilm) {
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

//			jsonResponse = jsonResponse.toUpperCase();
			System.out.println("im batman"+ jsonResponse);
			bufferedReader.close();
			
			Gson gson = new Gson();
			SearchResponse response = gson.fromJson(jsonResponse, SearchResponse.class);
			System.out.println(response);
			
			String imdbID = response.getSearch().get(0).getImdbID();
			System.out.println(imdbID);
			

        

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		OmdbAPIService test = new OmdbAPIService();
		
		test.getFilm("Batman");
	}

}
