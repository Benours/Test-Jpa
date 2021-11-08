package fr.diginamic.biblio.entites;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emprunt")
public class Emprunt implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "date_debut")
	private Timestamp dateDebut;
	@Column(name = "date_fin")
	private Timestamp dateFin;
	private int delai;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@ManyToMany
	@JoinTable(name = "compo",
		joinColumns = @JoinColumn(name = "id_emp", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "id_liv", referencedColumnName = "ID")
	)
	private Set<Livre> livres;
	/**
	 * 
	 */
	public Emprunt() {
	}
	/**
	 * @param dateDebut
	 * @param dateFin
	 * @param delai
	 * @param id_client
	 */
	public Emprunt(Timestamp dateDebut, Timestamp dateFin, int delai, Client id_client) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.delai = delai;
		this.client = id_client;
	}
	
	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}
	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
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
	 * @return the dateDebut
	 */
	public Timestamp getDateDebut() {
		return dateDebut;
	}
	/**
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Timestamp dateDebut) {
		this.dateDebut = dateDebut;
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
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}
	/**
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}
	/**
	 * @return the id_client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param id_client the id_client to set
	 */
	public void setClient(Client id_client) {
		this.client = id_client;
	}
	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ "]";
	}
	
	
}
