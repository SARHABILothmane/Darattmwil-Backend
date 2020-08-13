package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IstatusDao;
import com.DarAttamwil.Entity.Status;

@Service
public class ServiceStatut implements IserviceStatut{
	@Autowired
	private IstatusDao statusDao;
//	ajouter Statut
	public void addModifierStatut(Status s) {
	statusDao.save(s);
	}
	//selection tous les Statuts
	public List<Status> selectAllStatuts(){
	return statusDao.findAll();
	}
	//selectionner par id Statut
	public Optional<Status> selectByIdStatut(int id){
	return statusDao.findById(id);
	}
	//suprimer Statut by id
	public void deletStatut(int id) {
	statusDao.deleteById(id);
	}
}
