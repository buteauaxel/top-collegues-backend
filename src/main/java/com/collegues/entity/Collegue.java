/**
 * 
 */
package com.collegues.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Axel B.
 *
 */
@Entity
@Table(name = "COLLEGUE")
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PHOTO")
	private String photo;

	@Column(name = "NOM", nullable = false)
	private String nom;

	@Column(name = "NOTE")
	private Integer note;

	public Collegue() {

	}

	public Collegue(String photo, String nom) {
		this.photo = photo;
		this.nom = nom;
		this.note = 0;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the note
	 */
	public Integer getNote() {
		return note;
	}

	/**
	 * @param note
	 *            the note to set
	 */
	public void setNote(Integer note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Collegue [id=" + id + ", photo=" + photo + ", nom=" + nom + ", note=" + note + "]";
	}

}
