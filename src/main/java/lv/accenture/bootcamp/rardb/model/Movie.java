package lv.accenture.bootcamp.rardb.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
public class Movie implements Serializable {

	@Id
	@Valid
	private String imdbId;

	private Integer averageRating;
	private Integer ranking;
	private String tittle;
	private String poster;
	private String review;

//	@OneToMany(mappedBy = "imdbId", fetch = FetchType.LAZY)
	// private List<Review> reviews;

	@Column(name = "rating", columnDefinition = "int default 0")
	private int rating;

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Integer getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Integer rating) {
		this.averageRating = rating;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
//
//	public List<Review> getReviews() {
//		return reviews;
//	}
//
//	public void setReviews(List<Review> reviews) {
//		this.reviews = reviews;
//	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Movie(@Valid String imdbId, Integer rating, Integer ranking, String tittle, String poster, String review) {
		super();
		this.imdbId = imdbId;
		this.averageRating = rating;
		this.ranking = ranking;
		this.tittle = tittle;
		this.poster = poster;
		this.review = review;
	}

	public Movie() {

	}

	@Override
	public String toString() {
		return "Movie [imdbId=" + imdbId + ", rating=" + averageRating + ", ranking=" + ranking + ", tittle=" + tittle
				+ ", poster=" + poster + "]";
	}

}