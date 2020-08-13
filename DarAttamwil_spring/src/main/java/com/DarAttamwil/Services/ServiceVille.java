package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IvillesDao;
import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Entity.Villes;

@Service
public class ServiceVille implements IserviceVille{
	@Autowired
	private IvillesDao villesDao;
	//ajouter Ville
	public void addModifierVille(Villes v) {
	villesDao.save(v);
	}
	//selection tous les Villes
	public List<Villes> selectAllVilles(){
	return villesDao.findAll();
	}
	//selectionner par id Ville
	public Optional<Villes> selectByIdVille(int id){
	return villesDao.findById(id);
	}
	//suprimer Ville by id
	public void deletVille(int id) {
	villesDao.deleteById(id);
	}
	//selection liste des Clients dans une ville
	public List<Clients> selectAllClientsInVille(Villes v){
		return v.getClient();
	}
}
