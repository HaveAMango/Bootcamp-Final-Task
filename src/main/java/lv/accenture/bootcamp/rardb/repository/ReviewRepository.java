package lv.accenture.bootcamp.rardb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.rardb.model.Movie;
import lv.accenture.bootcamp.rardb.model.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

	
	@Query("Select c FROM Review c Where c.imdbId LIKE %:id%")
	List<Review> findById(@Param(value="id")String id);
	
	@Query("Select c FROM Review c Where c.imdbId LIKE %:id% AND c.userId LIKE %:userId%")
	Review findByUserId(@Param(value="id")String id, @Param(value="id")String userId);

	
	
//	List<Movie> findByImdbId(@Param(value="id")Integer id);
//
//	@Query("Select c (Select AVG(s.rating) FROM Review s Where s.idmb_id=c.idmb_id) average_rating FROM Movie c ")
//
//	Movie calculateAverage();
//	Review findById(@Param(value="id")String imdbId);

//@Query("Select c FROM Movie Where Order By ranking desc limit 10")
//Movie sortbyRating();

}