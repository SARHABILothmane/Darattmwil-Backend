package com.DarAttamwil.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DarAttamwil.Entity.Simulations;
import com.DarAttamwil.Services.IserviceSimulation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SimulationController {
@Autowired
private IserviceSimulation serviceSimulation ;
	//ajouter simulation 
     @PostMapping(value = "/simulations")
	public void addSimulation(@RequestBody Simulations s) {
		serviceSimulation.addModifierSimulation(s);
	}
 	//selectionner tous les simulations
     @GetMapping("/simulations")
 	public List<Simulations> selectAllSimulation(){
    	 return serviceSimulation.selectAllSimulation();
     }
 	//selection d une simulation par id
     @GetMapping("/simulations/{id}")
 	public Simulations selectSimulationById(@PathVariable int id){
    	 Optional<Simulations> simulation = serviceSimulation.selectSimulationById(id);
    	 if(!simulation.isPresent()) {
    		 return null;
    	 }
    	 return simulation.get();
     }
     //modifier simulation 
     @PatchMapping("/simulations/{id}")
     public Simulations modifierSimulation(@RequestBody Simulations s, @PathVariable int id) {
    	 s.setId(id);
    	 serviceSimulation.addModifierSimulation(s);
    	 return s;
     }
 	//suprimer une simulation 
     @DeleteMapping("/simulations/{id}")
 	public void deletSimullaton(@PathVariable int id) {
    	 serviceSimulation.deletSimullaton(id);
     }
////calcul
@GetMapping("/simulations/calcul/{id}")
public double calcul(@RequestParam("duree") int duree ,@PathVariable("id") int id) {
	Simulations s = serviceSimulation.selectSimulationById(id).get();
	float t = s.getApport();
	return t * duree;
}
//@PostMapping(value = "/simulations")
//public Simulations adds(@RequestParam("duree") int duree , @RequestParam("montant") float montant) {
//	Simulations s = new Simulations();
//	s.setDuree(duree);
//	s.setMontant(montant);
//	return s;
//}
}
