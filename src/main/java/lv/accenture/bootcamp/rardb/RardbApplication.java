package lv.accenture.bootcamp.rardb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lv.accenture.bootcamp.rardb.apiService.OmdbAPIService;

@SpringBootApplication
public class RardbApplication {


	public static void main(String[] args) {
		SpringApplication.run(RardbApplication.class, args);
	}

}
