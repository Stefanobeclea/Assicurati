package it.prova.gestioneassicurati;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;

@SpringBootApplication
public class GestioneassicuratiApplication implements CommandLineRunner{

	@Autowired
	AssicuratoService assicuratoService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestioneassicuratiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Assicurato> assicurati = assicuratoService.xmlToObject();
		
	}

}
