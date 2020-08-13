package com.DarAttamwil.Dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.DarAttamwil.Entity.Utilisateur;


public interface IutilisateurDao extends JpaRepository<Utilisateur, Integer>{
public Utilisateur findByEmail(String email);
}
