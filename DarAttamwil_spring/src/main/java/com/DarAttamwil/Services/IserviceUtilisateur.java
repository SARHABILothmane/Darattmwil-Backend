package com.DarAttamwil.Services;

import java.util.Optional;

import com.DarAttamwil.Entity.Utilisateur;



public interface IserviceUtilisateur {
	public Utilisateur findByEmail(String email);
}
