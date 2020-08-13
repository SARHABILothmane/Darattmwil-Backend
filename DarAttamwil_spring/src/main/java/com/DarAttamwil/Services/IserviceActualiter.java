package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Actualiter;

public interface IserviceActualiter {
//ajouter Actualiter
public Actualiter addModifierActualiter(Actualiter a);
//selection tous les Actualiter
public List<Actualiter> selectAllActualiters();
//selectionner par id Actualiter
public Optional<Actualiter> selectByIdActualiter(int id);
//suprimer Actualiter by id
public void deletActualiter(int id);
}

