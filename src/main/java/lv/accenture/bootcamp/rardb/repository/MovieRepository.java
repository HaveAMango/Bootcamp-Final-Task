package lv.accenture.bootcamp.rardb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import lv.accenture.bootcamp.rardb.model.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long>{
	

	List<Movie> findByImdbId(@Param(value="id")Integer id);

}
