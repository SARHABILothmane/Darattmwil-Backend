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

import com.DarAttamwil.Entity.Banks;
import com.DarAttamwil.Entity.Financements;
import com.DarAttamwil.Services.IserviceFinancement;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class FinancementController {
	@Autowired
	private IserviceFinancement serviceFinancement;
	//ajouter Financement
	@PostMapping(value = "/financements")
	public void addFinancement(@RequestBody Financements f) {
		serviceFinancement.addModifierFinancement(f);
	}
	//selection tous les Financements
	@GetMapping("/financements")
	public List<Financements> selectAllFinancement(){
		return serviceFinancement.selectAllFinancement();
	}
	//selectionner par id Financement
	@GetMapping("/financements/{id}")
	public Financements selectByIdFinancement(@PathVariable("id") int id) {
		Optional<Financements> financement = serviceFinancement.selectByIdFinancement(id);
		if(!financement.isPresent()) {
			return null;
		}
		return financement.get();
	}
	//modifier financements
	@PutMapping("/financements/{id}")
	public Financements addModifierFinancement(@RequestBody Financements f , @PathVariable("id") int id) {
		f.setId(id);
		serviceFinancement.addModifierFinancement(f);
		return f;
	}
	//suprimer Financement by id
	@DeleteMapping("/financements/{id}")
	public void deletFinancement(@PathVariable("id") int id) {
	serviceFinancement.deletFinancement(id);
	}

}
