package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IcontactDao;
import com.DarAttamwil.Entity.Contacts;

@Service
public class ServiceContact implements IserviceContact{
@Autowired private IcontactDao contactDao;
//ajouter contact
public void addModifierContact(Contacts c) {
	contactDao.save(c);
}
//selection tous les contacts
public List<Contacts> selectAllContacts(){
return contactDao.findAll();
}
//selectionner par id contact
public Optional<Contacts> selectByIdContact(int id){
return contactDao.findById(id);
}
//suprimer contact by id
public void deletContact(int id) {
contactDao.deleteById(id);
}
}
