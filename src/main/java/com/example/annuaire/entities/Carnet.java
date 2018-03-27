package com.example.annuaire.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
@Entity
public class Carnet {

	private int id;
	@NotNull // @NotNull(message="Il faut remplir les champs vides")
	private Civilite civilite;
	// @NotBlank
	@Pattern(regexp = "(?i)[a-z]{2,50}", message = "{com.formation.annuaire.constraint.nom.message}") // i ignorer la
																										// casse
	private String nom;
	// @NotBlank
	@Pattern(regexp = "(?i)[a-z\\- ]{2,100}", message = "{com.formation.annuaire.constraint.nom.message}")
	private String prenom;
	// @Pattern(regexp = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$", message =
	// "{com.formation.annuaire.constraint.tel.message}")
	@NotBlank
	private String dateDeNaissance;
	@Pattern(regexp = "^(\\+[0-9]|[0]{2})[0-9] {6,14}(?:x.+)?$", message = "{com.formation.annuaire.constraint.tel.message}")
	private String tel;
	@Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", message = "{com.formation.annuaire.constraint.email.message}")
	private String email;
	@Pattern(regexp = "^(([0-8][0-9])|(9[0-5])|(2[ab]))[0-9]{3}$", message = "{com.formation.annuaire.constraint.cp.message}")
	private String cp;
	@Pattern(regexp = "(?i)[a-z -] {1,45}", message = "{com.formation.annuaire.constraint.nom.message}")
	private String ville;

	public int getId() {
		return id;
	}

	public Carnet() {
	}

	public Carnet(int id, Civilite civilite, String nom, String prenom, String dateDeNaissance, String tel,
			String email, String cp, String ville) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.tel = tel;
		this.email = email;
		this.cp = cp;
		this.ville = ville;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
