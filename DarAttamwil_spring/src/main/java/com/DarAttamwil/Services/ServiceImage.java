package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.DarAttamwil.Dao.ImageRepository;
import com.DarAttamwil.Entity.ImageModel;
@Service
public class ServiceImage implements IserviceImages{
	@Autowired private ImageRepository imageDao;
	//ajouter Image
	public ImageModel uplaodImage(ImageModel image) {
		return imageDao.save(image);
	}
	//selection tous les Image
	public List<ImageModel> selectAllImage(){
	return imageDao.findAll();
	}
	//selectionner par id Image
	public Optional<ImageModel> selectByIdImage(Long id){
	return imageDao.findById(id);
	}
	//suprimer Image by id
	public void deletImage(Long id) {
	imageDao.deleteById(id);
	}
	//select image by name 
	public Optional<ImageModel> findByName(String name){
		return imageDao.findByName(name);
	}
//	//select image by id actualite
//	public	Optional<ImageModel> findByActualite(String name ,int id){
//		return imageDao.findByActualite(name, id);
//	}
//	//
//	public	List<ImageModel> findByIdActualite(@Param("id") int  id){
//		return imageDao.findByIdActualite(id);
//	}
//	//
//	public	Optional<ImageModel> findBytest(int  id){
//		return imageDao.findBytest(id);
//	}
}
