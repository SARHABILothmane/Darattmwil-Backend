package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Entity.Villes;

public interface IserviceVille {
	//ajouter Ville
	public void addModifierVille(Villes v);
	//selection tous les Villes
	public List<Villes> selectAllVilles();
	//selectionner par id Ville
	public Optional<Villes> selectByIdVille(int id);
	//suprimer Ville by id
	public void deletVille(int id);
	//selection liste des Clients dans une ville
	public List<Clients> selectAllClientsInVille(Villes v);
}
