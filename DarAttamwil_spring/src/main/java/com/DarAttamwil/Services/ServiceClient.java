package com.DarAttamwil.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IclientsDao;
import com.DarAttamwil.Entity.Clients;

@Service
public class ServiceClient implements IserviceClient{
	@Autowired
	private IclientsDao clientsDao;
	@Autowired 
    private PasswordEncoder passwordencoder;
	//ajouter Client
	public Clients addModifierClient(Clients c) {
		c.setPassword(passwordencoder.encode(c.getPassword()));
	return clientsDao.save(c);
	}
	//selection tous les Clients
	public List<Clients> selectAllClient(){
	return clientsDao.findAll();
	}
	//selectionner par id Client
	public Optional<Clients> selectByIdClient(int id){
	return clientsDao.findById(id);
	}
	//suprimer Client by id
	public void deletClient(int id) {
	clientsDao.deleteById(id);
	}
	//recherche d'un client par nom ou prenom
	public List<Clients>  findAllClientByNomAndPrenom(String nom , String prenom){ 
		return clientsDao.findAllClientByNomAndPrenom(nom, prenom);
	}
	//selection tous les client par type
	public  List<Clients> findAllClientByType(String  type){
		return clientsDao.findAllClientByType(type);
	}
}
