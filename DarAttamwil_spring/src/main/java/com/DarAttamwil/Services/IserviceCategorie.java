package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Categories;
import com.DarAttamwil.Entity.Financements;

public interface IserviceCategorie {
	//ajouter Categorie
	public void addModifierCategorie(Categories c);
	//selection tous les Categories
	public List<Categories> selectAllCategorie();
	//selectionner par id Categorie
	public Optional<Categories> selectByIdCategorie(int id);
	//suprimer Categorie by id
	public void deletCategorie(int id);
	//slectionner la liste des financement dans une categorie
	public List<Financements> selectAllCategoriesIbBank(Categories c);
}
