package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IsuivieDao;
import com.DarAttamwil.Entity.Suivie;

@Service
public class ServiceSuivie implements IserviceSuivie{
	@Autowired
	private IsuivieDao suivieDao;
	//ajouter Suivie
	public void addModifierSuivie(Suivie s) {
		suivieDao.save(s);
	}
	//selection tous les Suivies
	public List<Suivie> selectAllSuivies(){
	return suivieDao.findAll();
	}
	//selectionner par id Suivie
	public Optional<Suivie> selectByIdSuivie(int id){
	return suivieDao.findById(id);
	}
	//suprimer Suivie by id
	public void deletSuivie(int id) {
		suivieDao.deleteById(id);
	}
	//select suivie by id client
	public List<Suivie> findByClient(int id) {
		return suivieDao.findByClient(id);
	}

}
