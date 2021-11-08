package fr.diginamic.banque.entites;

import java.sql.Timestamp;

import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {

	private Timestamp dateFin;
	private double taux;
	/**
	 * 
	 */
	public AssuranceVie() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param numero
	 * @param solde
	 */
	public AssuranceVie(String numero, double solde, Timestamp dateFin, double taux) {
		super(numero, solde);
		this.dateFin = dateFin;
		this.taux = taux;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the dateFin
	 */
	public Timestamp getDateFin() {
		return dateFin;
	}
	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Timestamp dateFin) {
		this.dateFin = dateFin;
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
