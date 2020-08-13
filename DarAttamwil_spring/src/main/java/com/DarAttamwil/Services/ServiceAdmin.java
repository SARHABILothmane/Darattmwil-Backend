package com.DarAttamwil.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.DarAttamwil.Dao.IadminDao;
import com.DarAttamwil.Entity.Administrateur;



@Service
public class ServiceAdmin implements IserviceAdmin{
@Autowired
    private IadminDao adminDao;
@Autowired 
    private PasswordEncoder passwordencoder;
//ajouter admin
public Administrateur addModifierAdmin(Administrateur a) {
	a.setPassword(passwordencoder.encode(a.getPassword()));
	adminDao.save(a);
	return a;
}
//selection tous les admin
public List<Administrateur> selectAllAdmin(){
	return adminDao.findAll();
}
//selectionner par id admin
public Optional<Administrateur> selectByIdAdmin(int id){
	return adminDao.findById(id);
}
//selectionner par email admin
public Administrateur findByEmail(String email) {
	return adminDao.findByEmail(email);
}
//suprimer admin by id
public void deletAdmin(int id) {
	adminDao.deleteById(id);
} 
//recherche d'un admin par nom ou prenom
public List<Administrateur> findAdmintByFnameOrLname(String nom , String prenom){
	ArrayList<Administrateur> list = new ArrayList<Administrateur>();
	Administrateur a = new Administrateur();
	a.setNom(nom);
	a.setPrenom(prenom);
    Example<Administrateur> allAdmin = Example.of(a, ExampleMatcher.matchingAny());
    Iterable<Administrateur> admins = adminDao.findAll(allAdmin);
    
    for (Administrateur e : admins) {
        System.out.println(e);
        list.add(e);
    }
    return list; 
}
}
