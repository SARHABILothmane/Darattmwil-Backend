package com.DarAttamwil.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Entity.Suivie;

public interface IsuivieDao extends JpaRepository<Suivie, Integer>{
//	public Suivie findByClient(Clients client);
	@Query("select a  from Suivie a where a.client.id = :id")
public	List<Suivie> findByClient(@Param("id") int  id);
}
