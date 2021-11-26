package it.prova.gestioneassicurati.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;

@Service
public class ProcessingAssicuratoServiceImpl implements ProcessingAssicuratoService{
	
	@Autowired
	AssicuratoService assicuratoService;
	
	@Transactional
	public void createOrUpdateDB(List<Assicurato> assicuratiInput){
		for (Assicurato assicuratoItem : assicuratiInput) {
			 Assicurato assicuratoDalDB = assicuratoService.findByCodiceFiscale(assicuratoItem.getCodiceFiscale());
			if(assicuratoDalDB != null) {
				assicuratoDalDB.setNumeroSinistri(assicuratoDalDB.getNumeroSinistri()+assicuratoItem.getNumeroSinistri());
				assicuratoService.update(assicuratoDalDB);
			}
			else {
				assicuratoService.save(assicuratoItem);
			}
		}
	}
}
