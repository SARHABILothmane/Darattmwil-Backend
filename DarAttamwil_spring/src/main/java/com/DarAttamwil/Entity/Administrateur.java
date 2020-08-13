package com.DarAttamwil.Entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur{

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int id, String nom, String prenom, Roles role, String email, String password, String name,
			String type, byte[] picByte, Date createdAt, Date updatedAt) {
		super(id, nom, prenom, role, email, password, name, type, picByte, createdAt, updatedAt);
		// TODO Auto-generated constructor stub
	}

}
