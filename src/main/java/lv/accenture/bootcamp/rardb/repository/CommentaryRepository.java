package lv.accenture.bootcamp.rardb.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.rardb.model.Commentary;
import lv.accenture.bootcamp.rardb.model.Movie;
import lv.accenture.bootcamp.rardb.model.Review;

@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Long> {

	@Query("Select AVG(c.rating) FROM Commentary c Where c.reviewId=:id")
	Long calculateRating(@Param(value = "id") Long id);

	
}
