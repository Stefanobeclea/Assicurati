package it.prova.gestioneassicurati.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.repository.AssicuratoRepository;
import it.prova.gestioneassicurati.xml.Assicurati;

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
	
	public List<Assicurato> xmlToObject() {
		
		List<Assicurato> assicuratiDaPassare = new ArrayList<Assicurato>();
		
		try{
		    //getting the xml file to read
		    File file = new File("src/main/java/it/prova/gestioneassicurati/file/assicurati.xml");
		    //creating the JAXB context
		    JAXBContext jContext = JAXBContext.newInstance(Assicurati.class);
		    //creating the unmarshall object
		    Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
		    //calling the unmarshall method
		    Assicurati assicurati=(Assicurati) unmarshallerObj.unmarshal(file);
		    
		    Assicurato assicuratoDaAggiungere = new Assicurato();
		    for (Assicurati.Assicurato assicuratoItem : assicurati.getAssicurato()) {
		    	
		    	assicuratoDaAggiungere.setNome(assicuratoItem.getNome());
		    	assicuratoDaAggiungere.setCognome(assicuratoItem.getCognome());
		    	assicuratoDaAggiungere.setCodiceFiscale(assicuratoItem.getCodiceFiscale());
		    	assicuratoDaAggiungere.setDataNascita(assicuratoItem.getDataNascita());
		    	assicuratoDaAggiungere.setNumeroSinistri(assicuratoItem.getNumeroSinistri());
		    	assicuratiDaPassare.add(assicuratoDaAggiungere);
				
		    	System.out.println(assicuratoItem.getNome());
			}
		}catch(Exception e){
		    e.printStackTrace();
		}
		return assicuratiDaPassare;
	}
	
	@Transactional
	public void createOrUpdateDB(List<Assicurato> assicuratiInput){
		for (Assicurato assicuratoItem : assicuratiInput) {
			 Assicurato assicuratoDalDB = repository.findByCodiceFiscale(assicuratoItem.getCodiceFiscale());
			if(assicuratoDalDB != null) {
				assicuratoDalDB.setNumeroSinistri(assicuratoDalDB.getNumeroSinistri()+assicuratoItem.getNumeroSinistri());
				repository.save(assicuratoDalDB);
			}
			else {
				repository.save(assicuratoItem);
			}
		}
	}
	
	
}
