package lv.accenture.bootcamp.rardb.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

@Entity
public class Review implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long reviewId;
	
	@Valid
	private String imdbId;

	private Integer rating;
	private String tittle;
	private String userReview;
	private String userId;

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

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getUserReview() {
		return userReview;
	}

	public void setUserReview(String review) {
		this.userReview = review;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId=reviewId;
	}
	public Long getReviewId(Long reviewId) {
		return this.reviewId=reviewId;
	}

	public Review(Long reviewId, String imdbId, Integer rating, String tittle, String review, String userId) {
		super();
		this.imdbId = imdbId;
		this.rating = rating;
		this.tittle = tittle;
		this.userReview = review;
		this.userId = userId;
		this.reviewId=reviewId;
	}

	public Review() {

	}

	@Override
	public String toString() {
		return "Review [imdbId=" + imdbId + ", rating=" + rating + ", tittle=" + tittle + ", review=" + userReview + "]";
	}

}
