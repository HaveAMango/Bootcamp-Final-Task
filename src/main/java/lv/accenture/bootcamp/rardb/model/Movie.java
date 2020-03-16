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
	private String imdbId;

	private Integer rating;

	private String review;

	public Movie() {

	}

	public Movie(String imdbId, Integer rating, String review) {
		super();
		this.imdbId = imdbId;

		this.rating = rating;

		this.review = review;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

}
