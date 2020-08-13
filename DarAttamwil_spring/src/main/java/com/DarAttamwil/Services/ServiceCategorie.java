package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IcategoriesDao;
import com.DarAttamwil.Entity.Banks;
import com.DarAttamwil.Entity.Categories;
import com.DarAttamwil.Entity.Financements;

@Service
public class ServiceCategorie implements IserviceCategorie{
	@Autowired
	private IcategoriesDao categoriesDao;
	//ajouter Categorie
	public void addModifierCategorie(Categories c) {
	categoriesDao.save(c);
	}
	//selection tous les Categories
	public List<Categories> selectAllCategorie(){
	return categoriesDao.findAll();
	}
	//selectionner par id Categorie
	public Optional<Categories> selectByIdCategorie(int id){
	return categoriesDao.findById(id);
	}
	//suprimer Categorie by id
	public void deletCategorie(int id) {
	categoriesDao.deleteById(id);
	}
	//slectionner la liste des financement dans une categorie
	public List<Financements> selectAllCategoriesIbBank(Categories c){
		return c.getFinancement();
	}
}
