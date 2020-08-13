package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Clients;

public interface IserviceClient {
	//ajouter Client
	public Clients addModifierClient(Clients c);
	//selection tous les Clients
	public List<Clients> selectAllClient();
	//selectionner par id Client
	public Optional<Clients> selectByIdClient(int id);
	//suprimer Client by id
	public void deletClient(int id);
	//recherche d'un client par nom ou prenom
	public List<Clients>  findAllClientByNomAndPrenom(String nom , String prenom);
	
	//selection tous les client par type
	public  List<Clients> findAllClientByType(String  type);
}
