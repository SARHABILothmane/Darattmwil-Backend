package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Contacts;

public interface IserviceContact {
//ajouter contact
public void addModifierContact(Contacts c);
//selection tous les contacts
public List<Contacts> selectAllContacts();
//selectionner par id contact
public Optional<Contacts> selectByIdContact(int id);
//suprimer contact by id
public void deletContact(int id);
}
