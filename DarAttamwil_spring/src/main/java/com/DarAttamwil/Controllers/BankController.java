package com.DarAttamwil.Controllers;

import java.util.List;

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
import com.DarAttamwil.Services.IserviceBanks;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BankController {
@Autowired
private IserviceBanks servicesBanks;
//ajouter bank
@PostMapping(value = "/banks")
public void addBank(@RequestBody Banks b) {
	servicesBanks.addModifierBank(b);
}
//selection tous les Banks
@GetMapping("/banks")
public List<Banks> selectAllBanks(){
	return servicesBanks.selectAllBanks();
}
//selectionner par id Bank
@GetMapping("/banks/{id}")
public Banks selectByIdBank(@PathVariable("id") int id) {
	return servicesBanks.selectByIdBank(id).map(bank ->{
		return servicesBanks.selectByIdBank(id).get();
	}).orElseThrow(()-> new Error());
}
//modifier bank
@PutMapping("/banks/{id}")
public Banks modifierBank(@RequestBody Banks b , @PathVariable("id") int id){
	b.setId(id);
	servicesBanks.addModifierBank(b);
	return b;
}
//suprimer Bank by id
@DeleteMapping("/banks/{id}")
public void deletBank(@PathVariable("id") int id) {
	servicesBanks.deletBank(id);
}
//slectionner la liste des financement dans une banque
@GetMapping("/banks/financements/{bank_id}")
public List<Financements> selectAllFinancementsIbBank(@PathVariable("bank_id") int id){
	return servicesBanks.selectAllFinancementsIbBank(servicesBanks.selectByIdBank(id).get());
}
}
