package fr.diginamic.banque.entites;

import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {

	private double taux;

	/**
	 * 
	 */
	public LivretA() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numero
	 * @param solde
	 */
	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}	
		
}
