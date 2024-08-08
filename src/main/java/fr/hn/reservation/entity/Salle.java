package fr.hn.reservation.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "salle")
public class Salle {
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Generated(GenerationTime.INSERT)
	private Integer id;
	@Column(name = "nom")
	private String nom;

	private int etage;
	private int nombrePlace;
	@OneToMany(mappedBy = "salle")
	private List<Equipement> equipements;

	public Salle() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

}