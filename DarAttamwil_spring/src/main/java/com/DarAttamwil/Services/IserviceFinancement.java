package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Categories;
import com.DarAttamwil.Entity.Financements;

public interface IserviceFinancement {
	//ajouter Financement
	public void addModifierFinancement(Financements f);
	//selection tous les Financements
	public List<Financements> selectAllFinancement();
	//selectionner par id Financement
	public Optional<Financements> selectByIdFinancement(int id);
	//suprimer Financement by id
	public void deletFinancement(int id);

}
