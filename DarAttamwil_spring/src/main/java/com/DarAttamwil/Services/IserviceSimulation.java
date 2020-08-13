package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Simulations;

public interface IserviceSimulation {
//	public Simulations add(Simulations s) ;
//	public double calcul(float taux , int duree );
	//ajouter simulation 
	public void addModifierSimulation(Simulations s);
	//selectionner tous les simulations
	public List<Simulations> selectAllSimulation();
	//selection d une simulation par id
	public Optional<Simulations> selectSimulationById(int id);
	//suprimer une simulation 
	public void deletSimullaton(int id);
}
