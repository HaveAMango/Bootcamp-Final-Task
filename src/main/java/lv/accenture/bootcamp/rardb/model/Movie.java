//package lv.accenture.bootcamp.rardb.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.PositiveOrZero;
//import javax.validation.constraints.Size;
//
//@Entity
//public class Movie implements Serializable {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	private Integer rank;
//
//	private String tittle;
//
//	private Integer rating;
//	private String photo;
//	private String review;
//
//	public Movie() {
//
//	}
//
//	public Movie(Long id, Integer rank, String tittle, Integer rating, String photo, String review) {
//		super();
//		this.id = id;
//		this.rank = rank;
//		this.tittle = tittle;
//		this.rating = rating;
//		this.photo = photo;
//		this.review = review;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Integer getRank() {
//		return rank;
//	}
//
//	public void setRank(Integer rank) {
//		this.rank = rank;
//	}
//
//	public String getTittle() {
//		return tittle;
//	}
//
//	public void setTittle(String tittle) {
//		this.tittle = tittle;
//	}
//
//	public Integer getRating() {
//		return rating;
//	}
//
//	public void setRating(Integer rating) {
//		this.rating = rating;
//	}
//
//	public String getPhoto() {
//		return photo;
//	}
//
//	public void setPhoto(String photo) {
//		this.photo = photo;
//	}
//
//	public String getReview() {
//		return review;
//	}
//
//	public void setReview(String review) {
//		this.review = review;
//	}
//
//}
