package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Suivie;

public interface IserviceSuivie {
	//ajouter Suivie
	public void addModifierSuivie(Suivie s);
	//selection tous les Suivies
	public List<Suivie> selectAllSuivies();
	//selectionner par id Suivie
	public Optional<Suivie> selectByIdSuivie(int id);
	//suprimer Suivie by id
	public void deletSuivie(int id);
	//select suivie by id client
	public List<Suivie> findByClient(int id);
}
