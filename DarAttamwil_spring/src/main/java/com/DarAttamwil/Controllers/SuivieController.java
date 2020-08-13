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

import com.DarAttamwil.Entity.Suivie;
import com.DarAttamwil.Services.IserviceSuivie;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class SuivieController {
	@Autowired
  private IserviceSuivie serviceSuivier;
  //ajouter suivie
  @PostMapping("/suivies")
  public void addSuivie(@RequestBody Suivie s) {
	  serviceSuivier.addModifierSuivie(s);
  }
  //selection tous les suivies
  @GetMapping("/suivies")
 public List<Suivie> selectAllSuivie(){
  	return serviceSuivier.selectAllSuivies();
  }
 //selectionner par id suivie
  @GetMapping("/suivies/{id}")
 public List<Suivie> findByClient(@PathVariable("id") int id) {
	 return serviceSuivier.findByClient(id);
//  	Optional<Suivie> suivie = serviceSuivier.selectByIdSuivie(id);
//  	if(!suivie.isPresent()) {
//  		return null;
//  	}
//  	return suivie.get();
  }
 //modifier Suivie
  @PutMapping("/suivies/{id}")
 public Suivie addModifierSuivie(@RequestBody Suivie s , @PathVariable("id") int id) {
  	s.setId(id);
  	serviceSuivier.addModifierSuivie(s);
  	return s;
  }
 //suprimer Suivie by id
  @DeleteMapping("/suivies/{id}")
 public void deletStatut(@PathVariable("id") int id) {
	  serviceSuivier.deletSuivie(id);
  }
}
