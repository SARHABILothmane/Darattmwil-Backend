package com.DarAttamwil.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DarAttamwil.Entity.Administrateur;

public interface IadminDao extends JpaRepository<Administrateur, Integer>{
	public Administrateur findByEmail(String email);
}
