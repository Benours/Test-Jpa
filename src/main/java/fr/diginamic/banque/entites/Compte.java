package fr.diginamic.banque.entites;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String numero;
	private double solde;
	
	@ManyToMany(mappedBy = "comptes")
	private Set<ClientBanque> clients;
	
	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	private Set<Operation> operations;
	
	/**
	 * 
	 */
	public Compte() {
	}
	/**
	 * @param numero
	 * @param solde
	 */
	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
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
	 * @return the operations
	 */
	public Set<Operation> getOperations() {
		return operations;
	}
	/**
	 * @param operations the operations to set
	 */
	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public void addOperation(Operation operation) {
		operation.setCompte(this);
	}
	public void removeOperation(Operation operation) {
		operation.setCompte(null);
	}
	
}
