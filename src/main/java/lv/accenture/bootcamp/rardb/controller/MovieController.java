package lv.accenture.bootcamp.rardb.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import lv.accenture.bootcamp.rardb.apiService.OmdbAPIService;
import lv.accenture.bootcamp.rardb.apiService.SearchResult;
import lv.accenture.bootcamp.rardb.login.LoggedInService;
import lv.accenture.bootcamp.rardb.model.Movie;
import lv.accenture.bootcamp.rardb.model.Review;
import lv.accenture.bootcamp.rardb.repository.MovieRepository;
import lv.accenture.bootcamp.rardb.repository.ReviewRepository;

@Controller
public class MovieController {

	@Autowired
	OmdbAPIService search = new OmdbAPIService();

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private LoggedInService loggedInService;

	@Autowired
	ReviewRepository reviewRepository;

	@GetMapping("/movies/search")
	public String movieFindByTitle(@RequestParam String Title, Model model) {

		List<SearchResult> findMovie = search.getFilmList(Title);
		model.addAttribute("findMovie", findMovie);
		System.out.println(findMovie);
		
		model.addAttribute("loggedIn", loggedInService.loggedIn());
		return "movie-index";
	}
	


	@GetMapping("/movies/main")
	public String topTenList(Model model) {

		
		List<Movie> movieList = (List<Movie>) movieRepository.findTopTen();
		movieRepository.addRanking(movieList);		
		Iterable<Movie> movies = movieRepository.findTopTen();
	
		model.addAttribute("loggedIn", loggedInService.loggedIn());
		model.addAttribute("movies", movies);
		

		return "main";
	}

	@GetMapping("/findMovie/addReview/{id}")
	public String addReview(@PathVariable String id, Model model) {

		/// should add an option that user can vote only once, afterwards he/she can
		/// edit their choice


		Review reviewAdd = new Review();
		reviewAdd.setImdbId(id);



		model.addAttribute("review", reviewAdd);

		return "movie-add";

	}

	
	@PostMapping("/movies/movie-add/{id}")
	public String addReview(@PathVariable String id, @Valid Review reviewAdd, BindingResult bindingResult) {
//		Movie movie = new Movie(search.getFilmList(requestedFilm));
		
		reviewAdd.setImdbId(id);

		reviewRepository.save(reviewAdd);

		Movie movieToReview = search.getInfoFromOmdb(id);
//		movieToReview.setImdbId(id);

		List<Review> movieRatingList = reviewRepository.findByIbmId(id);


		Long averageRating = reviewRepository.calculateAverageRating(movieRatingList);

		movieToReview.setAverageRating(averageRating);

		movieRepository.save(movieToReview);


		return "redirect:/movies/main";

	}
	@GetMapping("/movies/reviews/{id}")
	public String movieReviews(@PathVariable String id, Model model) { 
		

		
		//Working on a review page

		//System.out.println(tittle);
		//List<Review> review1 = reviewRepository.findByIbmId(imdbId);
		//Iterable<Review> reviews = reviewRepository.findAll();
		Iterable<Review>reviews = reviewRepository.findByIbmId(id);
		
		System.out.println(reviews.toString());
		
		model.addAttribute("reviews", reviews);
		//model.addAttribute("imdbId", imdbId);
		
	return"reviews";
	}
	
		
	}

