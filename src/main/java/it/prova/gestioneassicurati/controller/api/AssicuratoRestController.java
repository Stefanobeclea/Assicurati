package it.prova.gestioneassicurati.controller.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.service.AssicuratoService;

@RestController
@RequestMapping(value = "/api/assicurato", produces = { MediaType.APPLICATION_JSON_VALUE})
public class AssicuratoRestController {

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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Assicurato createNew(@Valid @RequestBody Assicurato assicuratoInput) {
		Assicurato assicuratoInserito = assicuratoService.save(assicuratoInput);
		return assicuratoInserito;
	}
	
	@PutMapping("/{id}")
	public Assicurato update(@Valid @RequestBody Assicurato assicuratoInput, @PathVariable(required = true) Long id) {

		assicuratoInput.setId(id);
		Assicurato assicuratoAggiornato = assicuratoService.update(assicuratoInput);
		return assicuratoAggiornato;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable(required = true) Long id) {
		Assicurato assicurato = assicuratoService.get(id);
		assicuratoService.delete(assicurato);
	}
}
