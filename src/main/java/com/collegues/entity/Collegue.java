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

	@Column(name = "MATRICULE")
	private String matricule;

	@Column(name = "PHOTO")
	private String photo;

	@Column(name = "PSEUDO")
	private String pseudo;
	@Column(name = "NOM")
	private String nom;

	@Column(name = "PRENOM")
	private String prenom;

	@Column(name = "ADRESSE")
	private String adresse;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NOTE")
	private Integer note;

	public Collegue() {

	}

	public Collegue(String photo, String pseudo) {
		this.photo = photo;
		this.pseudo = pseudo;
		this.note = 0;
	}

	public Collegue(String photo, String matricule, String pseudo, String nom, String prenom, String email,
			String adresse) {
		this.photo = photo;
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
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
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
		if (note > 1000) {
			this.note = 1000;
		} else if (note <= -1000) {
			this.note = -1000;
		} else {

			this.note = note;
		}
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Collegue [id=" + id + ", matricule=" + matricule + ", photo=" + photo + ", pseudo=" + pseudo + ", nom="
				+ nom + ", prenom=" + prenom + ", adresse=" + adresse + ", email=" + email + ", note=" + note + "]";
	}

}
