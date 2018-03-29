package com.example.annuaire.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
//@Table(name="adresse")
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // JPA qui s'occupe
	private Integer id;
	@Column(length = 6)
	private Integer number;
	@Column(length = 25)
	private String street;
	@Column(length = 5)
	private Integer postcode;
	@Column(length = 25)
	private String town;
	
	@ManyToMany(mappedBy="adresses")//mapping avec le nom de la collection correspondante
	
	private List<Carnet> carnets;

	public Adresse() {
		carnets = new ArrayList<Carnet>();
	}

	public Adresse(Integer id, Integer number, String street, Integer postcode, String town, List<Carnet> carnets) {
		super();
		carnets = new ArrayList<Carnet>();
		this.id = id;
		this.number = number;
		this.street = street;
		this.postcode = postcode;
		this.town = town;
		this.carnets = carnets;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getPostcode() {
		return postcode;
	}

	public void setPostcode(Integer postcode) {
		this.postcode = postcode;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<Carnet> getCarnets() {
		return carnets;
	}

	public void setCarnets(List<Carnet> carnets) {
		this.carnets = carnets;
	}

}
