package com.DarAttamwil.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IutilisateurDao;
import com.DarAttamwil.Entity.Utilisateur;




@Service
public class ServiceUtlisateur implements IserviceUtilisateur{
@Autowired
private IutilisateurDao serviceUtilisateur;
public Utilisateur findByEmail(String email) {
	return serviceUtilisateur.findByEmail(email);
}

}
