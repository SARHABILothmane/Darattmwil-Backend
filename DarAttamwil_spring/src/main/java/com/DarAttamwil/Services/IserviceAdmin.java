package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Administrateur;

public interface IserviceAdmin {
//ajouter admin
public Administrateur addModifierAdmin(Administrateur a);
//selection tous les admin
public List<Administrateur> selectAllAdmin();
//selectionner par id admin
public Optional<Administrateur> selectByIdAdmin(int id);
//selectionner par email admin
public Administrateur findByEmail(String email);
//suprimer admin by id
public void deletAdmin(int id);
//recherche d'un admin par nom ou prenom
public List<Administrateur> findAdmintByFnameOrLname(String nom , String prenom);
}
