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
import lv.accenture.bootcamp.rardb.model.Commentary;
import lv.accenture.bootcamp.rardb.model.Movie;
import lv.accenture.bootcamp.rardb.model.Review;
import lv.accenture.bootcamp.rardb.repository.CommentaryRepository;
import lv.accenture.bootcamp.rardb.repository.MovieRepository;
import lv.accenture.bootcamp.rardb.repository.ReviewRepository;

@Controller
public class MovieController {

	// DONE - TODO: If already autowired, why then initialized? :)
	@Autowired
	private OmdbAPIService search;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private LoggedInService loggedInService;

	@Autowired
	ReviewRepository reviewRepository;
	
	@Autowired
	CommentaryRepository commentaryRepository;

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
		// ANS: no, movie is not saved to BD until review is written; TODO : If somebody
				// is already written a review (and hence saved movie from extrenal API to DB)
				// we can check that fact and don't use extrenal API call (if Movie is already
				// saved in our DB)
				Movie movieToReview = search.getInfoFromOmdb(id);
//				movieToReview.setImdbId(id);
		reviewAdd.setImdbId(id);
		reviewAdd.setUserId(loggedInService.getCurrentUser().getUserName());
		reviewAdd.setTittle(movieToReview.getTitle());
		
		reviewRepository.save(reviewAdd);


		// ANS: but user is writing review to movie and sets raiting for it. - TODO:
		// Serious possible misunderstanding here : users rate NOT movies, but REVIEWS,
		// written by another users. Needs to be re-implemented

		// Evija: I guess we dont need this function
		// List<Review> movieRatingList = reviewRepository.findByIbmId(id);

		Long averageRating = reviewRepository.calculateAverageRating(id);
		movieToReview.setAverageRating(averageRating);

		movieRepository.save(movieToReview);

		return "redirect:/movies/main";

	}

	@GetMapping("/movies/reviews/{id}")
	public String movieReviews(@PathVariable String id, Model model) {

		Iterable<Review> reviews = reviewRepository.findByIbmId(id);

		System.out.println(reviews.toString());
		Movie movie = movieRepository.findById(id);

		model.addAttribute("reviews", reviews);
		model.addAttribute("movies", movie);

		return "reviews";
	}

	@GetMapping("/movies/comments/{id}")
	public String reviewCommentsAdd(@PathVariable Long id, Model model) {
		
		Commentary commentary = new Commentary();
		commentary.setReviewId(id);

		model.addAttribute("commentary", commentary);
		return "add-commentary"; 
	
	}
	
	
	@PostMapping("/movies/comments/{id}")
	public String reviewCommentsDisplay(@PathVariable Long id, @Valid Commentary commentary, BindingResult bindingResult) {
		
		Review review = reviewRepository.findById(id).get();
		commentary.setReviewId(id);
		commentary.setImdbId(review.getImdbId());
		
		
		commentaryRepository.save(commentary);
		
		Long reviewAverage = commentaryRepository.calculateRating(id);
		
		review.setReviewRating(reviewAverage);
		reviewRepository.save(review);
		
		
	return "commentPage";
	}
	}
