package lv.accenture.bootcamp.rardb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lv.accenture.bootcamp.apiService.OmdbAPIService;

@SpringBootApplication
public class RardbApplication {
	
    @Autowired
    private OmdbAPIService omdbAPIService;

	public static void main(String[] args) {
		SpringApplication.run(RardbApplication.class, args);
	}

}
