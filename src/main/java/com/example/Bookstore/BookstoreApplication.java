package com.example.Bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockMultipartFile;

import com.example.Bookstore.domain.Beer;
import com.example.Bookstore.domain.BeerRepository;
import com.example.Bookstore.domain.Kauppa;
import com.example.Bookstore.domain.KauppaRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;
import com.example.Bookstore.web.BeerController;
@SpringBootApplication
@EnableJpaRepositories
public class BookstoreApplication {
	@Autowired
	
	private UserRepository Urepo;

	public static void main(String[] args) {
		
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookDemo(BeerRepository repository,KauppaRepository krepository,BeerController beerController) {
	return (args) -> {
		
		//
		Logger logger=Logger.getLogger("global");
		//Otetaan 3 kuvaa /Bookstore/ päätteestä, ja muutetaan se commandlinerunnerille
		//sopivaan muotoon. MockMultipartFile on MultipartFile:stä testaamiseen
		//tarkoitettu tiedostomuoto
		File tiedosto = new File("olutolut.jpg");
		//Luetaan kuva tiedostosta
		FileInputStream stream = new FileInputStream(tiedosto);
		//Tehdään kuvasta lisättävä.
		MockMultipartFile multipartFileToSend = new MockMultipartFile("tiedosto",tiedosto.getName(), MediaType.IMAGE_JPEG_VALUE,stream);
		
		File tiedosto1 = new File("karhu4bottle.jpeg");
		FileInputStream stream1 = new FileInputStream(tiedosto1);
		MockMultipartFile multipartFileToSend1 = new MockMultipartFile("tiedosto",tiedosto1.getName(), MediaType.IMAGE_JPEG_VALUE,stream1);
		
		File tiedosto2 = new File("pirkka3.jpeg");
		FileInputStream stream2 = new FileInputStream(tiedosto2);
		MockMultipartFile multipartFileToSend2 = new MockMultipartFile("tiedosto",tiedosto2.getName(), MediaType.IMAGE_JPEG_VALUE,stream2);
		
		
		//Lisätään kauppa repositorioon kauppoja joista valita.
		krepository.save(new Kauppa("Lidl"));
		krepository.save(new Kauppa("S-market"));
		krepository.save(new Kauppa("K-market"));
		krepository.save(new Kauppa("Prisma"));
		krepository.save(new Kauppa("K-citymarket"));
		krepository.save(new Kauppa("Tokmanni"));
		krepository.save(new Kauppa("K-supermarket"));
		
		//Lisätään Controllerin kautta testioluita databaseen sekä repositorioon.
		beerController.save(new Beer( "Olut Olut",0.99,"3/5","0.33L can",krepository.findByName("Lidl"),null),multipartFileToSend);
		beerController.save(new Beer("Karhu IV", 2.35,"4/5", "0.33L Glass bottle",krepository.findByName("Prisma"),null),multipartFileToSend1);
		beerController.save(new Beer("Pirkka 3 lager (sininen)",1.25,"3.5/5","0.33L can",krepository.findByName("K-market"),null), multipartFileToSend2);
		//repository.save(new Beer("Karhu IV", 2.35,"4/5", "0.33L Glass bottle",krepository.findByName("Prisma"),null));
		//repository.save(new Beer("Pirkka 3 lager (sininen)",1.25,"3.5/5","0.33L can",krepository.findByName("K-market"),null));
		
		
		//Luodaan kaksi käyttäjää testimielessä spring boot securityllä
		//Urepo.save(new User("user","$2a$10$Xgc5M1k2WNh4sw93qmgrM.Hc64iaifzro.ME8LjejMl.yyNOpGG6G","USER"));
		//Urepo.save(new User("admin","$2a$10$oXYiJuvfs8hrvWUAIgbRbOvi1m60crb4n7GWs6ZLeb2HNc.ES9ENC","ADMIN"));


		};


	};
	
	}


