package lv.accenture.bootcamp.rardb.controller;

import java.util.List;

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
	ReviewRepository reviewRepository;

	@GetMapping("/movie/search")
	public String movieFindByTitle(@RequestParam String Title, Model model) {
		List<SearchResult> findMovie = search.getFilm(Title);
		// System.out.println("movie search cont" + findMovie.toString()); //remove sout
		// , or you could get null pointer exeption if movie doesn`t found
		model.addAttribute("findMovie", findMovie);
		return "movie-index";
	}

	@GetMapping("/movies/main")
	public String topTenList(Model model) {

		// Add only top 10 movies
		Iterable<Movie> movies = movieRepository.findAll();
		model.addAttribute("moviesTop", movies);

		return "main";
	}

	@GetMapping("/findMovie/addReview/{id}")
	public String addReview(@PathVariable String id, Model model) {

		System.out.println("the imdb id" + id);

		Review reviewAdd = new Review();
		reviewAdd.setImdbId(id);

		// Movie movieToReview = new Movie();
		// movieToReview.setImdbId(id);

		System.out.println("before get");
		// System.out.println(movieToReview.toString());

		model.addAttribute("review", reviewAdd);

		return "movie-add";

	}

	@PostMapping("/movie/movie-add/{id}")
	public String addReview(@PathVariable String id, @Valid Review reviewAdd, BindingResult bindingResult) {

		reviewAdd.setImdbId(id);

		reviewRepository.save(reviewAdd);

		Movie movieToReview = new Movie();
		movieToReview.setImdbId(id);

		List<Review> movieRatingList = reviewRepository.findByIbmId(id);
		
		Long averageRating = reviewRepository.calculateAverageRating(movieRatingList);
//		Integer ratingSum = 0;
//		Integer ratingCount = 0;
//		Integer averageRating;
//
//		
//		if (movieRatingList.size() > 0) {
//			for (int i = 0; i < movieRatingList.size(); i++) {
//				ratingSum = ratingSum + movieRatingList.get(i).getRating();
//				ratingCount = i + 1;
//			}
//			averageRating = ratingSum / ratingCount;
//		} else {
//			averageRating = 0;
//		}

		movieToReview.setAverageRating(averageRating);

		movieRepository.save(movieToReview);

		System.out.println("After post");
		System.out.println(movieToReview.toString());
		System.out.println(reviewAdd.toString());
		return "redirect:/movies/main";

	}

}
