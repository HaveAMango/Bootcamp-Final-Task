package lv.accenture.bootcamp.rardb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
public class Commentary implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long commentaryId;
	
	@Valid
	private String imdbId;

	private Integer rating;
	private Long reviewId;
	

	 @Column(columnDefinition="TEXT", length=3000)
	private String comment;

	private String userId;

	public Long getCommentaryId() {
		return commentaryId;
	}

	public void setCommentaryId(Long commentaryId) {
		this.commentaryId = commentaryId;
	}

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

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Commentary(){
		
	}

	public Commentary(Long commentaryId, @Valid String imdbId, Integer rating, Long reviewId, String comment,
			String userId) {
		super();
		this.commentaryId = commentaryId;
		this.imdbId = imdbId;
		this.rating = rating;
		this.reviewId = reviewId;
		this.comment = comment;
		this.userId = userId;
	}
	
	
}