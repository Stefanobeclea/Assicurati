package it.prova.gestioneassicurati.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import it.prova.gestioneassicurati.model.Assicurato;
import it.prova.gestioneassicurati.xml.Assicurati;

@Service
public class ConvertXmlToAssicuratoServiceImpl implements ConvertXmlToAssicuratoService {
	public List<Assicurato> xmlToObject() {

		List<Assicurato> assicuratiDaPassare = new ArrayList<Assicurato>();

		try {
			// getting the xml file to read
			File file = new File("file/assicurati.xml");
			// creating the JAXB context
			JAXBContext jContext = JAXBContext.newInstance(Assicurati.class);
			// creating the unmarshall object
			Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
			// calling the unmarshall method
			Assicurati assicurati = (Assicurati) unmarshallerObj.unmarshal(file);

			
			for (Assicurati.Assicurato assicuratoItem : assicurati.getAssicurato()) {
				Assicurato assicuratoDaAggiungere = new Assicurato();
				assicuratoDaAggiungere.setNome(assicuratoItem.getNome());
				assicuratoDaAggiungere.setCognome(assicuratoItem.getCognome());
				assicuratoDaAggiungere.setCodiceFiscale(assicuratoItem.getCodiceFiscale());
				assicuratoDaAggiungere.setDataNascita(assicuratoItem.getDataNascita());
				assicuratoDaAggiungere.setNumeroSinistri(assicuratoItem.getNumeroSinistri());
				assicuratiDaPassare.add(assicuratoDaAggiungere);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return assicuratiDaPassare;
	}
}
