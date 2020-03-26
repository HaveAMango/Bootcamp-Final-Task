package lv.accenture.bootcamp.rardb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.rardb.model.Movie;
import lv.accenture.bootcamp.rardb.model.Review;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {



	//TODO : imdbID is quite particular thing, so user will not enter it (like a title)
	// so LIKE is not suitable here (and @Query (and all the function) also, parent class already has findById)
	@Query("Select c FROM Movie c Where c.imdbId LIKE %:id%")

	Movie findById(@Param(value = "id") String imdbId);

//	public default void addRankings(List<Movie> movieList){
//		
//		
//		for(int i = 0; i< movieList.size; i++) {
//			movieList.get(i)
//		}
//		return null;
//		
//	}
	
	@Query(value="SELECT * FROM Movie ORDER BY average_rating DESC LIMIT 10", nativeQuery = true)
			
	Iterable<Movie> findTopTen();

	//TODO: Also not right place for this code
	default void addRanking(List<Movie> movieRatingList) {
		for ( int i=0; i<movieRatingList.size(); i++) {
			movieRatingList.get(i).setRanking(i+1);
		}
	};
	
	


	
}
