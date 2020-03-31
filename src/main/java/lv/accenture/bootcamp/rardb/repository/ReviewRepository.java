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

	@Query("Select c FROM Review c Where c.imdbId=:id")
	List<Review> findByIbmId(@Param(value = "id") String id);

	@Query("Select c FROM Review c Where c.imdbId LIKE %:id% AND c.userId LIKE %:userId%")
	Review findByUserId(@Param(value = "id") String id, @Param(value = "id") String userId);

	//TODO: 1) Repository class seems wrong place to have this code
	// 2) Average rating calculation can (respectively, should) be done on DB side
	// please look into SQL AVG() and GROUP BY features
	
	@Query("Select AVG(c.rating) FROM Review c Where c.imdbId=:id")
	Long calculateAverageRating(@Param(value = "id") String id);
	
	

}