package com.reto2Ciclo4.reto2Ciclo4;

import com.reto2Ciclo4.reto2Ciclo4.repositorio.crud.CleanProdCrudRepository;
import com.reto2Ciclo4.reto2Ciclo4.repositorio.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class Reto2Ciclo4Application implements CommandLineRunner {

	//@Autowired
	// private StockCrudRepository stockCrudRepository;
	@Autowired
	private UserCrudRepository userCrudRepository;
	@Autowired
	private CleanProdCrudRepository cleanProdCrudRepository;
	public static void main(String[] args) {
		SpringApplication.run(Reto2Ciclo4Application.class, args);


		}
	@Override
	public void run(String... args) throws Exception {
		cleanProdCrudRepository.deleteAll();
		userCrudRepository.deleteAll();
		System.out.println("Database ready to go...!");
	}

}

