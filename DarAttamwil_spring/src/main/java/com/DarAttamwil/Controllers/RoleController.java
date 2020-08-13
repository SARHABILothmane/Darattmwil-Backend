package com.DarAttamwil.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.DarAttamwil.Entity.Roles;
import com.DarAttamwil.Services.IserviceRole;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RoleController {
@Autowired
private IserviceRole controllerRole;

@GetMapping("/all/roles")
public List<Roles> selectTousRole(){
	return controllerRole.selectAllRole();
}

//selection d'un role par ID
@GetMapping(value = "/roles/{id}")
public Roles sel(@PathVariable("id") int id) {
	return controllerRole.selectByIdRole(id).map(role -> {
		return controllerRole.selectByIdRole(id).get();
	}).orElseThrow(()-> new Error());
}
//ajoutation d'un role 
@PostMapping(value="/roles")
public Roles enregistreRole(@RequestBody Roles r) {
	controllerRole.addModifierRoles(r);
	return r;
}
//supprission role 
@DeleteMapping( value = "/roles/{id}")
public void suprimeRole(@PathVariable("id") int id) {
	controllerRole.deletRole(id);
}
//modifier role 
@PutMapping("/roles/{id}")
public Roles modifierRole(@RequestBody Roles r , @PathVariable("id") int id) {
	r.setId(id);
	controllerRole.addModifierRoles(r);
	return r;
//	Roles role = controllerRole.selectByIdRole(id).get();
//	controllerRole.addModifierRoles(role);;
//	return r;
}
}
