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

	private Long averageRating;
	private Integer ranking;
	private String tittle;
	private String poster;
	private String review;

//@OneToMany(mappedBy = "imdbId", fetch = FetchType.LAZY)
	// private List<Review> reviews;

	@Column(name = "rating", columnDefinition = "int default 0")
	private int rating;

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public Long getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(Long averageRating) {
		this.averageRating = averageRating;
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


	public Movie(@Valid String imdbId, Long rating, Integer ranking, String tittle, String poster, String review) {
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