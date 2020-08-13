package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IsimulationDao;
import com.DarAttamwil.Entity.Simulations;

@Service
public class ServiceSimulations implements IserviceSimulation{
	@Autowired
    private IsimulationDao simulationDao;
	//ajouter simulation 
	public void addModifierSimulation(Simulations s) {
		simulationDao.save(s);
	}
	//selectionner tous les simulations
	public List<Simulations> selectAllSimulation(){
		return simulationDao.findAll();
	}
	//selection d une simulation par id
	public Optional<Simulations> selectSimulationById(int id){
		return simulationDao.findById(id);
	}
	//suprimer une simulation 
	public void deletSimullaton(int id) {
		simulationDao.deleteById(id);
	}
//	public Simulations add(Simulations s) {
////		Simulations si = new Simulations();
////		si.setTaux(s.getTaux());
////		si.setDuree(s.getDuree());
//		return s;
//	}
//	public double calcul(float taux , int duree ) {
////		Simulations s = new Simulations();
////		float a = 0;
////		int b =0;
////		float c ;
////		double rslt =	a * b  ;
////   
//////		    s.setMontant(900.00f);
//////			s.setDuree(5);
//////			s.setTaux(2.0f);
//		   return taux * duree;
//	}

	

}
