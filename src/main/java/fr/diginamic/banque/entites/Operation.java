package fr.diginamic.banque.entites;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Timestamp date;
	private double montant;
	private String motif;
	
	@ManyToOne
	@JoinColumn(name = "id_compte")
	private Compte compte;
	
	/**
	 * 
	 */
	public Operation() {
	}
	/**
	 * @param date
	 * @param montant
	 * @param motif
	 */
	public Operation(Timestamp date, double montant, String motif) {
		this.date = date;
		this.montant = montant;
		this.motif = motif;
	}
	
	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		if (this.compte != null) 
			this.compte.getOperations().remove(this);
		this.compte = compte;
		if (this.compte != null)
			this.compte.getOperations().add(this);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp date) {
		this.date = date;
	}
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	/**
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}
	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}



}
