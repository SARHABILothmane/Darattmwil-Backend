package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IrolesDao;
import com.DarAttamwil.Entity.Roles;

@Service
public class ServiceRole implements IserviceRole{
	@Autowired
	private IrolesDao rolesDao;
	//ajouter Role
	public void addModifierRoles(Roles r) {
	rolesDao.save(r);
	}
	//selection tous les Roles
	public List<Roles> selectAllRole(){
	return rolesDao.findAll();
	}
	//selectionner par id Role
	public Optional<Roles> selectByIdRole(int id){
	return rolesDao.findById(id);
	}
	//suprimer Role by id
	public void deletRole(int id) {
	rolesDao.deleteById(id);
	}
}
