package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IfinacementDao;
import com.DarAttamwil.Entity.Financements;

@Service
public class ServiceFinancement implements IserviceFinancement{
	@Autowired
	private IfinacementDao finacementDao;
	//ajouter Financement
	public void addModifierFinancement(Financements f) {
	finacementDao.save(f);
	}
	//selection tous les Financements
	public List<Financements> selectAllFinancement(){
	return finacementDao.findAll();
	}
	//selectionner par id Financement
	public Optional<Financements> selectByIdFinancement(int id){
	return finacementDao.findById(id);
	}
	//suprimer Financement by id
	public void deletFinancement(int id) {
	finacementDao.deleteById(id);
	}
}
