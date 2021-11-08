package fr.diginamic.banque.entites;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class Virement extends Operation {
	
	private String beneficiaire;

	/**
	 * 
	 */
	public Virement() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Virement(Timestamp date, double montant, String motif, String beneficiaire) {
		super(date, montant, motif);
		this.beneficiaire = beneficiaire;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	

}
