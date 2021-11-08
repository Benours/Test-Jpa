package fr.diginamic.banque.entites;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "banque")
public class Banque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	
	@OneToMany(mappedBy = "banque")
	private Set<ClientBanque> clients;
	
	/**
	 * 
	 */
	public Banque() {
	}
	/**
	 * @param nom
	 */
	public Banque(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the id
	 */
	
	public int getId() {
		return id;
	}
	/**
	 * @return the clients
	 */
	public Set<ClientBanque> getClients() {
		return clients;
	}
	/**
	 * @param clients the clients to set
	 */
	public void setClients(Set<ClientBanque> clients) {
		this.clients = clients;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
