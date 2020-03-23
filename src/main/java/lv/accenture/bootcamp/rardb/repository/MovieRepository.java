package lv.accenture.bootcamp.rardb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.rardb.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {



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
	
	


	
}
