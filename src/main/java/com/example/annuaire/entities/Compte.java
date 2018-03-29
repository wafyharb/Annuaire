package com.example.annuaire.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private Integer numero;
	@Column(length = 25)
	private String nom;

	@ManyToOne
	@JoinColumn(name="owner")
	private Carnet owner;

	public Carnet getOwner() {
		return owner;
	}

	public void setOwner(Carnet owner) {
		this.owner = owner;
	}

	public Compte(Long id, Integer numero, String nom) {
		super();
		this.id = id;
		this.numero = numero;
		this.nom = nom;
	}

	public Compte() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
