package lv.accenture.bootcamp.rardb.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.accenture.bootcamp.rardb.apiService.OmdbAPIService;
import lv.accenture.bootcamp.rardb.apiService.SearchResult;
import lv.accenture.bootcamp.rardb.model.Movie;
import lv.accenture.bootcamp.rardb.repository.MovieRepository;


@Controller
public class MovieController {

	@Autowired
	OmdbAPIService search = new OmdbAPIService();

	@Autowired
	private MovieRepository movieRepository;

	


	@GetMapping("/movie/search")
	public String movieFindByTitle(@RequestParam String Title, Model model) {
		List<SearchResult> findMovie = search.getFilm(Title);
		// System.out.println("movie search cont" + findMovie.toString()); //remove sout
		// , or you could get null pointer exeption if movie doesn`t found
		model.addAttribute("findMovie", findMovie);
		return "movie-index";
	}

	@GetMapping("/findMovie/addReview/{id}")
	public String addReview(@PathVariable String id, Model model) {
	
		System.out.println("the imdb id" + id);

		Movie movieToReview = new Movie();
		movieToReview.setImdbId(id);
//		movieToReview.setPoster(Poster);
//		movieToReview.setTitle(Title);
		System.out.println("We are here");
		//movieToReview.setRatingSum(movieToReview.getRatingSum()+rating);

		model.addAttribute("movie", movieToReview);

		return "movie-add";

	}
	
	@GetMapping("/movies/main")
	public String topTenList( Model model) {
		
		//Add only top 10 movies
		Iterable<Movie> movies = movieRepository.findAll();
		model.addAttribute("moviesTop", movies);
		return "main";
	}

	@PostMapping("/movie/movie-add/{id}")
	public String addReview(@PathVariable String id, @Valid Movie movieToReview, BindingResult bindingResult) {
		System.out.println("the imdb id" + id);

			
			movieToReview.setImdbId(id);
			movieRepository.save(movieToReview);
			
			System.out.println(movieToReview.getReview() + " " + movieToReview.getRating() + movieToReview.getImdbId());
			System.out.println(movieRepository.toString());
			
			return "redirect:/movies/main";
		

	}

	
}
