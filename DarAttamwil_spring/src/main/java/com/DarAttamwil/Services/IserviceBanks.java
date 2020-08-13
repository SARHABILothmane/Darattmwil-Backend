package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import com.DarAttamwil.Entity.Banks;
import com.DarAttamwil.Entity.Financements;

public interface IserviceBanks {
//ajouter bank
public void addModifierBank(Banks b);
//selection tous les Banks
public List<Banks> selectAllBanks();
//selectionner par id Bank
public Optional<Banks> selectByIdBank(int id);
//suprimer Bank by id
public void deletBank(int id);
//slectionner la liste des financement dans une banque
public List<Financements> selectAllFinancementsIbBank(Banks b);
}
