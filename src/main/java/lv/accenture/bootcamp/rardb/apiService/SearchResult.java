package lv.accenture.bootcamp.rardb.apiService;






public class SearchResult {


	private Integer id;
	
	private String Title;
	
	private String Year;
	
	
	private String imdbID;
	
	private String Type;
	
	private String Poster;
	
	private double imdbRating;

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
	
	///////////////////////////
	/*
	 * public Integer getId () { return id; } public void setId (Integer id) {
	 * this.id=id; }
	 * 
	 * 
	 * // public double getimdbRating() { // return imdbRating; // } // // public
	 * void setimdbRating(double imdbRating) { // this.imdbRating = imdbRating; // }
	 */
	@Override
	public String toString() {
		return "SearchResult [id=" + id + ", Title=" + Title + ", Year=" + Year + ", imdbID=" + imdbID + ", Type="
				+ Type + ", Poster=" + Poster +  "]";
	}


	

	
}
