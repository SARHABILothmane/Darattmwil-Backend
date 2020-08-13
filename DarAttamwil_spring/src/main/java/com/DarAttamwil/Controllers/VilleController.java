package com.DarAttamwil.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DarAttamwil.Entity.Clients;
import com.DarAttamwil.Entity.Villes;
import com.DarAttamwil.Services.IserviceVille;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class VilleController {
	@Autowired
   private IserviceVille  serviceVille ;
   
	//ajouter Ville
   @PostMapping(value = "/villes")
	public void addModifierVille(@RequestBody Villes v) {
	   serviceVille.addModifierVille(v);
   }
	//selection tous les Villes
   @GetMapping("/villes")
	public List<Villes> selectAllVilles(){
	   return serviceVille.selectAllVilles();
   }
	//selectionner par id Ville
	@GetMapping("/villes/{id}")
	public Villes selectByIdVille(@PathVariable("id") int id) {
		Optional<Villes> ville= serviceVille.selectByIdVille(id);
		if (!ville.isPresent()) {
			return null;
		}
		return ville.get();
	}
	//modifier villes
	@PutMapping("/villes/{id}")
	public Villes modifierVille(@RequestBody Villes v ,@PathVariable("id") int id) {
		v.setId(id);
		serviceVille.addModifierVille(v);
		return v;
	}
	//suprimer Ville by id
	@DeleteMapping("/villes/{id}")
	public void deletVille(@PathVariable("id") int id) {
		serviceVille.deletVille(id);
	}
	//selection liste des Clients dans une ville
	@GetMapping("/villes/clients/{ville_id}")
	public List<Clients> selectAllClientsInVille(@PathVariable("ville_id") int id){
		return serviceVille.selectAllClientsInVille(serviceVille.selectByIdVille(id).get());
	}
}
