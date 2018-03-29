package com.example.annuaire.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
//@Table(name ="carnet")
public class Carnet {
	@Id
	@GeneratedValue // auto incrementation par hibernate
	private Long id;
	@Enumerated(EnumType.STRING) // En base de donnée ca va creer un varchar sin on met pas l'annoation avec la
									// convertir en int
	@Column(length = 8) // création d'un attribut varchar civilite de taille 8 on peut specifier le nom
						// de la colonne (name="civ")
	@NotNull // @NotNull(message="Il faut remplir les champs vides")
	private Civilite civilite;
	// @NotBlank
	@Pattern(regexp = "(?i)[a-z]{2,50}", message = "{com.formation.annuaire.constraint.nom.message}") // i ignorer la
	@Column(length = 50) // casse
	private String nom;
	// @NotBlank
	@Pattern(regexp = "(?i)[a-z\\- ]{2,100}", message = "{com.formation.annuaire.constraint.nom.message}")
	@Column(length = 100)
	private String prenom;
	// @Pattern(regexp = "^([0-9]{2})/([0-9]{2})/([0-9]{4})$", message =
	// "{com.formation.annuaire.constraint.tel.message}")
	@NotBlank
	@Column(columnDefinition = "date", name = "birthday")
	private String dateDeNaissance;
	@NotBlank
	// @Pattern(regexp = "^(\\+[0-9]|[0]{2})[0-9] {6,14}(?:x.+)?$", message =
	// "{com.formation.annuaire.constraint.tel.message}")
	private String tel;
	@NotBlank
	// @Pattern(regexp = "\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", message =
	// "{com.formation.annuaire.constraint.email.message}")
	@Column(length = 100)
	private String email;
	@NotBlank
	// @Pattern(regexp = "^(([0-8][0-9])|(9[0-5])|(2[ab]))[0-9]{3}$", message =
	// "{com.formation.annuaire.constraint.cp.message}")
	@Column(length = 5)
	private String cp;
	@NotBlank
	// @Pattern(regexp = "(?i)[a-z -] {1,45}", message =
	// "{com.formation.annuaire.constraint.nom.message}")
	@Column(length = 50)
	private String ville;
	
	@ManyToMany   	
	private List<Adresse> adresses;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="owner")
    private List<Compte> comptes;
    
	public Carnet() {
		adresses= new ArrayList<Adresse>();
	}
	public List<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	public Carnet(Long id, Civilite civilite, String nom, String prenom, String dateDeNaissance, String tel,
			String email, String cp, String ville) {
		super();
		adresses= new ArrayList<Adresse>();
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
   
	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public Long getId() {
		return id;
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
