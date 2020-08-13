package com.DarAttamwil.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.DarAttamwil.Entity.ImageModel;

public interface IserviceImages {
	//ajouter Image
	public ImageModel uplaodImage(ImageModel image);
	//selection tous les Image
	public List<ImageModel> selectAllImage();
	//selectionner par id Image
	public Optional<ImageModel> selectByIdImage(Long id);
	//suprimer Image by id
	public void deletImage(Long id);
	//select image by name 
	public Optional<ImageModel> findByName(String name);
//	//select image by id actualite
//	public	Optional<ImageModel> findByActualite(String name ,int id);
//	//
//	public	List<ImageModel> findByIdActualite(int  id);
//	//
//	 public	Optional<ImageModel> findBytest(int  id);
}
