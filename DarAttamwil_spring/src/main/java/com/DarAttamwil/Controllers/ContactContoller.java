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

import com.DarAttamwil.Entity.Contacts;
import com.DarAttamwil.Services.IserviceContact;

@CrossOrigin

@RestController
@RequestMapping("/api")
public class ContactContoller {
@Autowired private IserviceContact serviceContact;
//ajouter Contact
@PostMapping(value = "/contact/contacts")
public void addModifierContact(@RequestBody Contacts c) {
  serviceContact.addModifierContact(c);
}
//selection tous les Contacts
@GetMapping("/contacts")
public List<Contacts> selectAllContact(){
  return serviceContact.selectAllContacts();
}
//selectionner par id Contact
@GetMapping("/contacts/{id}")
public Contacts selectByIdContact(@PathVariable("id") int id) {
	Optional<Contacts> contact= serviceContact.selectByIdContact(id);
	if (!contact.isPresent()) {
		return null;
	}
	return contact.get();
}
//modifier villes
@PutMapping("/contacts/{id}")
public Contacts modifierContact(@RequestBody Contacts c ,@PathVariable("id") int id) {
	c.setId(id);
	serviceContact.addModifierContact(c);
	return c;
}
//suprimer Contact by id
@DeleteMapping("/contacts/{id}")
public void deletContact(@PathVariable("id") int id) {
	serviceContact.deletContact(id);
}
}
