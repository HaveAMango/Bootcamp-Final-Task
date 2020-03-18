package lv.accenture.bootcamp.rardb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Movie implements Serializable {

	@Id
	@NotNull
	private String imdbId;
	
	private Integer rating;
//	@Column(columnDefinition = "integer default 0")
	//private Long ratingSum;
	//@Column(columnDefinition = "integer default 0")
	//private Integer ratingCount;
	//private Integer rank;
	private String review;
	private String Title;
	private String Poster;

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

//	public Long getRatingSum() {
//		return ratingSum;
//	}
//
//	public void setRatingSum(Long ratingSum) {
//		this.ratingSum = ratingSum;
//	}
//
//	public Integer getRatingCount() {
//		return ratingCount;
//	}
//
//	public void setRatingCount(Integer ratingCount) {
//		this.ratingCount = ratingCount;
//	}
//
//	public Integer getRank() {
//		return rank;
//	}
//
//	public void setRank(Integer rank) {
//		this.rank = rank;
//	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

//	public Movie(String imdbId, Integer rating, Long ratingSum, Integer ratingCount, Integer rank, String review,
//			String title, String poster) {
//		super();
//		this.imdbId = imdbId;
//		this.rating = rating;
//		this.ratingSum = ratingSum;
//		this.ratingCount = ratingCount;
//		this.rank = rank;
//		this.review = review;
//		Title = title;
//		Poster = poster;
//	}
	public Movie(String imdbId, Integer rating, Integer rank, String review,
	String title, String poster) {
super();
this.imdbId = imdbId;
this.rating = rating;

this.review = review;
Title = title;
Poster = poster;
}

	public Movie() {

	}

}
