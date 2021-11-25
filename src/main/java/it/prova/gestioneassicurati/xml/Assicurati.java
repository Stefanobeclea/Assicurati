//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.8-b130911.1802 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2021.11.25 alle 02:11:51 PM CET 
//


package it.prova.gestioneassicurati.xml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assicurato" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="numeroSinistri" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "assicurato"
})
@XmlRootElement(name = "assicurati")
public class Assicurati {

    @XmlElement(required = true)
    protected List<Assicurati.Assicurato> assicurato;

    /**
     * Gets the value of the assicurato property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assicurato property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssicurato().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assicurati.Assicurato }
     * 
     * 
     */
    public List<Assicurati.Assicurato> getAssicurato() {
        if (assicurato == null) {
            assicurato = new ArrayList<Assicurati.Assicurato>();
        }
        return this.assicurato;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cognome" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="dataNascita" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="codiceFiscale" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="numeroSinistri" type="{http://www.w3.org/2001/XMLSchema}integer"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "nome",
        "cognome",
        "dataNascita",
        "codiceFiscale",
        "numeroSinistri"
    })
    public static class Assicurato {

        @XmlElement(required = true)
        protected String nome;
        @XmlElement(required = true)
        protected String cognome;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar dataNascita;
        @XmlElement(required = true)
        protected String codiceFiscale;
        @XmlElement(required = true)
        protected BigInteger numeroSinistri;

        /**
         * Recupera il valore della proprietà nome.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNome() {
            return nome;
        }

        /**
         * Imposta il valore della proprietà nome.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNome(String value) {
            this.nome = value;
        }

        /**
         * Recupera il valore della proprietà cognome.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCognome() {
            return cognome;
        }

        /**
         * Imposta il valore della proprietà cognome.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCognome(String value) {
            this.cognome = value;
        }

        /**
         * Recupera il valore della proprietà dataNascita.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getDataNascita() {
            return dataNascita;
        }

        /**
         * Imposta il valore della proprietà dataNascita.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setDataNascita(XMLGregorianCalendar value) {
            this.dataNascita = value;
        }

        /**
         * Recupera il valore della proprietà codiceFiscale.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCodiceFiscale() {
            return codiceFiscale;
        }

        /**
         * Imposta il valore della proprietà codiceFiscale.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCodiceFiscale(String value) {
            this.codiceFiscale = value;
        }

        /**
         * Recupera il valore della proprietà numeroSinistri.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getNumeroSinistri() {
            return numeroSinistri;
        }

        /**
         * Imposta il valore della proprietà numeroSinistri.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setNumeroSinistri(BigInteger value) {
            this.numeroSinistri = value;
        }

    }

}
