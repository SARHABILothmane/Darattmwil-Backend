package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Status;

public interface IserviceStatut {
//ajouter Statut
public void addModifierStatut(Status s);
//selection tous les Statuts
public List<Status> selectAllStatuts();
//selectionner par id Statut
public Optional<Status> selectByIdStatut(int id);
//suprimer Statut by id
public void deletStatut(int id);
}
