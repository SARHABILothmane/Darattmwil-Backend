package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Roles;

public interface IserviceRole {
	//ajouter Role
	public void addModifierRoles(Roles r);
	//selection tous les Roles
	public List<Roles> selectAllRole();
	//selectionner par id Role
	public Optional<Roles> selectByIdRole(int id);
	//suprimer Role by id
	public void deletRole(int id);
}
