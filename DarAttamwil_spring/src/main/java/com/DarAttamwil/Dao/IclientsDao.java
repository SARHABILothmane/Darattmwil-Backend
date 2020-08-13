package com.DarAttamwil.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DarAttamwil.Entity.Clients;

public interface IclientsDao extends JpaRepository<Clients, Integer>{
	@Query("select a  from Clients a where a.type = :type")
  List<Clients> findAllClientByType(@Param("type") String  type);
	
	@Query("select a  from Clients a where a.nom = :nom or a.prenom = :prenom")
	  List<Clients> findAllClientByNomAndPrenom(@Param("nom") String  nom , @Param("prenom") String  prenom);
}
