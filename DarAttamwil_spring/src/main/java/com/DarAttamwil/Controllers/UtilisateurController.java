package com.DarAttamwil.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DarAttamwil.Entity.Utilisateur;
import com.DarAttamwil.Services.IserviceUtilisateur;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class UtilisateurController {
@Autowired
private IserviceUtilisateur controllerUser;
@GetMapping(value = "/users")
public Utilisateur selectUser(@RequestParam("username")String email) {
return	controllerUser.findByEmail(email);
}
}
