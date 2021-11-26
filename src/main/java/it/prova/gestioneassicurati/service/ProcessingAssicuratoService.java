package it.prova.gestioneassicurati.service;

import java.util.List;

import it.prova.gestioneassicurati.model.Assicurato;

public interface ProcessingAssicuratoService {
	public void createOrUpdateDB(List<Assicurato> assicuratiInput);
}
