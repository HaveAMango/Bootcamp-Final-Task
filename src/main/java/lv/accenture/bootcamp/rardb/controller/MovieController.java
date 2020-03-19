package lv.accenture.bootcamp.rardb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.accenture.bootcamp.rardb.apiService.OmdbAPIService;
import lv.accenture.bootcamp.rardb.apiService.SearchResult;



@Controller
public class MovieController {
	
	@Autowired
	OmdbAPIService search = new OmdbAPIService();
	
	
//	@GetMapping("/movie") 
//	public String movieIndex(Model model) {
//		Iterable<SearchResult>findMovie = search.showResults();
//		model.addAttribute("findMovie", findMovie);
//		return "movie-index";
//	}
	
	@GetMapping("/movie/search")
	public String movieFindByTitle(@RequestParam String Title, Model model) {
		Title = search.checkTitle(Title);
		
		List<SearchResult> findMovie = search.getFilm(Title);
		model.addAttribute("findMovie", findMovie);
		System.out.println(findMovie);
		return "movie-index";
	}
	

	
	
	
}
