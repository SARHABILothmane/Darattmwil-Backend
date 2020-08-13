package com.DarAttamwil.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DarAttamwil.Entity.Contacts;

public interface IcontactDao extends JpaRepository<Contacts, Integer>{

}
