package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IbanksDao;
import com.DarAttamwil.Entity.Banks;
import com.DarAttamwil.Entity.Financements;

@Service
public class ServiceBanks implements IserviceBanks{
@Autowired
private IbanksDao banksDao;
//ajouter bank
public void addModifierBank(Banks b) {
banksDao.save(b);
}
//selection tous les Banks
public List<Banks> selectAllBanks(){
return banksDao.findAll();
}
//selectionner par id Bank
public Optional<Banks> selectByIdBank(int id){
return banksDao.findById(id);
}
//suprimer Bank by id
public void deletBank(int id) {
banksDao.deleteById(id);
}
//slectionner la liste des financement dans une banque
public List<Financements> selectAllFinancementsIbBank(Banks b){
	return b.getFinancement();
}
}
