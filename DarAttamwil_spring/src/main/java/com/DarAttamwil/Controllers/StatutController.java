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

import com.DarAttamwil.Entity.Status;
import com.DarAttamwil.Services.IserviceStatut;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class StatutController {
	@Autowired
    private IserviceStatut serviceStatut;
    //ajouter Statut
    @PostMapping("/statuts")
    public void addStatut(@RequestBody Status s) {
    	serviceStatut.addModifierStatut(s);
    }
    //selection tous les Statuts
    @GetMapping("/statuts")
   public List<Status> selectAllStatuts(){
    	return serviceStatut.selectAllStatuts();
    }
   //selectionner par id Statut
    @GetMapping("/statuts/{id}")
   public Status selectByIdStatut(@PathVariable("id") int id) {
    	Optional<Status> statut = serviceStatut.selectByIdStatut(id);
    	if(!statut.isPresent()) {
    		return null;
    	}
    	return statut.get();
    }
   //modifier statut
    @PutMapping("/statuts/{id}")
   public Status addModifierStatut(@RequestBody Status s , @PathVariable("id") int id) {
    	s.setId(id);
    	serviceStatut.addModifierStatut(s);
    	return s;
    }
   //suprimer Statut by id
    @DeleteMapping("/statuts/{id}")
   public void deletStatut(@PathVariable("id") int id) {
    	serviceStatut.deletStatut(id);
    }
}
