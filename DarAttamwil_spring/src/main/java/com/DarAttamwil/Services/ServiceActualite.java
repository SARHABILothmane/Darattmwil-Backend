package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DarAttamwil.Dao.IactualiterDao;
import com.DarAttamwil.Entity.Actualiter;

@Service
public class ServiceActualite implements IserviceActualiter{
@Autowired
private IactualiterDao actualiterDao;
//ajouter Actualiter
public Actualiter addModifierActualiter(Actualiter a) {
	return actualiterDao.save(a);
}
//selection tous les Actualiter
public List<Actualiter> selectAllActualiters(){
return actualiterDao.findAll();
}
//selectionner par id Actualiter
public Optional<Actualiter> selectByIdActualiter(int id){
return actualiterDao.findById(id);
}
//suprimer Actualiter by id
public void deletActualiter(int id) {
	actualiterDao.deleteById(id);
}
}
