package fr.hn.reservation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
@Entity
@Table(name = "equipement")
public class Equipement{
	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Generated(GenerationTime.INSERT)
	private Integer id;
	private String nom;
	private String description;	
	@OneToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;
	public Equipement() {
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
