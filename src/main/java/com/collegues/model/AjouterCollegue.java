/**
 * 
 */
package com.collegues.model;

/**
 * @author Axel B.
 *
 */
public class AjouterCollegue {

	private String matricule;

	private String pseudo;

	private String photo;

	public AjouterCollegue(String matricule, String pseudo, String photo) {
		super();
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.photo = photo;
	}

	public AjouterCollegue() {

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

	@Override
	public String toString() {
		return "AjouterCollegue [matricule=" + matricule + ", pseudo=" + pseudo + ", photo=" + photo + "]";
	}

}
