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

import com.DarAttamwil.Entity.Categories;
import com.DarAttamwil.Entity.Financements;
import com.DarAttamwil.Services.IserviceCategorie;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	private IserviceCategorie serviceCategorie;
	//ajouter Categorie
	@PostMapping(value = "/categories")
	public void addCategorie(@RequestBody Categories c) {
		serviceCategorie.addModifierCategorie(c);
	}
	//selection tous les Categories
	@GetMapping("/categories")
	public List<Categories> selectAllCategorie(){
		return serviceCategorie.selectAllCategorie();
	}
	//selectionner par id Categorie
	@GetMapping("/categories/{id}")
	public Categories selectByIdCategorie(@PathVariable("id") int id) {
		Optional<Categories> categorie= serviceCategorie.selectByIdCategorie(id);
		if(!categorie.isPresent()) {
			return null;
		}
		return categorie.get();
	}
	//modifier categorie
	@PutMapping("/categories/{id}")
	public Categories modifierCategorie(@RequestBody Categories c , @PathVariable("id") int id) {
		c.setId(id);
		serviceCategorie.addModifierCategorie(c);
		return c;
	}
	//suprimer Categorie by id
	@DeleteMapping("categories/{id}")
	public void deletCategorie(@PathVariable("id") int id) {
		serviceCategorie.deletCategorie(id);
	}
	//slectionner la liste des financement dans une categorie
	@GetMapping("/categories/financements/{categorie_id}")
	public List<Financements> selectAllCategoriesIbBank(@PathVariable("categorie_id") int id){
		return serviceCategorie.selectAllCategoriesIbBank(serviceCategorie.selectByIdCategorie(id).get());
	}
}
