package it.prova.gestioneassicurati.service;

import java.util.List;

import it.prova.gestioneassicurati.model.Assicurato;

public interface AssicuratoService {

	List<Assicurato> listAll();

	Assicurato get(Long idInput);

	Assicurato save(Assicurato input);
	
	Assicurato update(Assicurato input);

	void delete(Assicurato input);
	
	public Assicurato findByCodiceFiscale(String codice);
	
	public List<Assicurato> xmlToObject();
}
