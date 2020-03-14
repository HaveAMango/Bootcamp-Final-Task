package lv.accenture.bootcamp.apiService;

public class SearchResult {

	private String Title;
	
	private String Year;
	
	private String imdbID;
	
	private String Type;
	
	private String Poster;

	public String getTitle() {
		return Title;
	}

	public String getYear() {
		return Year;
	}

	public String getImdbID() {
		return imdbID;
	}

	public String getType() {
		return Type;
	}

	public String getPoster() {
		return Poster;
	}

	@Override
	public String toString() {
		return "SearchResult [Title=" + Title + ", Year=" + Year + ", imdbID=" + imdbID + ", Type=" + Type + ", Poster="
				+ Poster + "]";
	}
	

	
}
