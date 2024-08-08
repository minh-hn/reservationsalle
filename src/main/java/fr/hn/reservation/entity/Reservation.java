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
@Table(name = "reservation")
public class Reservation {

	@OneToOne
	@JoinColumn(name = "salle_id")
	private Salle salle;
	@Column(name = "jour")
	private String jour;
	@Column(name = "creneau")
	private int creneau;

	@Id
	@Column(columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Generated(GenerationTime.INSERT)
	private Integer id;

	public Reservation() {

	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	/**
	 * @return the jour
	 */
	public String getJour() {
		return jour;
	}

	/**
	 * @param jour the jour to set
	 */
	public void setJour(String jour) {
		this.jour = jour;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}