package it.prova.gestioneassicurati.controller.api;

import java.io.File; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;
import it.prova.gestioneassicurati.service.ConvertXmlToAssicuratoService;
import it.prova.gestioneassicurati.service.ProcessingAssicuratoService;
import reactor.netty.http.server.HttpServerResponse;

@RestController
@RequestMapping(value = "/api/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE})
public class AssicuratoRestController {

	@Autowired
	ConvertXmlToAssicuratoService convertXmlToAssicuratoService;
	
	@Autowired
	ProcessingAssicuratoService processingAssicuratoService;
	
	@Autowired
	AssicuratoService assicuratoService;
	
	@GetMapping
	public List<Assicurato> getAll() {
		return assicuratoService.listAll();
	}
	
	@GetMapping("/{id}")
	public Assicurato findById(@PathVariable(value = "id", required = true) long id) {
		Assicurato assicurato = assicuratoService.get(id);

		return assicurato;
	}
	
	@GetMapping("/processing")
	public ResponseEntity<?> processing(HttpStatus stat, HttpServerResponse rest) {
		 File file = new File("C:\\Corso\file/assicurati.xml");
		List<Assicurato> assicuratiDaControllare = convertXmlToAssicuratoService.xmlToObject();
		for (Assicurato assicuratoItem : assicuratiDaControllare) {
			if (assicuratoItem.getNumeroSinistri() < 0) {
				file.renameTo(new File("C:\\Corso\\file/scarto/assicurati.xml"));
				 return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
			}	
		}
		System.out.println("sono passato lo stesso");
		processingAssicuratoService.createOrUpdateDB(assicuratiDaControllare);
		file.renameTo(new File("C:\\Corso\\file/processed/assicurati.xml"));
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
}
