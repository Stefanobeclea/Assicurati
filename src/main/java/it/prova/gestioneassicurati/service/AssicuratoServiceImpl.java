package it.prova.gestioneassicurati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.repository.AssicuratoRepository;

@Service
public class AssicuratoServiceImpl implements AssicuratoService{

	@Autowired
	AssicuratoRepository repository;
	
	@Override
	public List<Assicurato> listAll() {
		return (List<Assicurato>) repository.findAll();
	}

	@Override
	public Assicurato get(Long idInput) {
		return repository.findById(idInput).orElse(null);
	}

	@Override
	public Assicurato save(Assicurato input) {
		return repository.save(input);
	}

	@Override
	public Assicurato update(Assicurato input) {
		return repository.save(input);
	}

	@Override
	public void delete(Assicurato input) {
		repository.delete(input);
		
	}

	@Override
	public Assicurato findByCodiceFiscale(String codice) {
		return repository.findByCodiceFiscale(codice);
	}
	
}
