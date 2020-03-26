package lv.accenture.bootcamp.rardb.apiService;

public class SearchResult {

	private Integer id;

	private String Title;

	private String Year;

	private String imdbID;

	private String Type;

	private String Poster;

	private String imdbRating;
	


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
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setYear(String year) {
		Year = year;
	}

	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}

	public void setType(String type) {
		Type = type;
	}

	public void setPoster(String poster) {
		if (poster != "N/A") {
		Poster = poster;
		}
	}

	@Override
	public String toString() {
		return "SearchResult [id=" + id + ", Title=" + Title + ", Year=" + Year + ", imdbID=" + imdbID + ", Type="
				+ Type + ", Poster=" + Poster + "]";
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

}
