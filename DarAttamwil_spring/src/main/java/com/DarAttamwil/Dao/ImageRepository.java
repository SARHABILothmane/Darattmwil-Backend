package com.DarAttamwil.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.DarAttamwil.Entity.ImageModel;



public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
	
	
	
//	
//	@Query("select a  from ImageModel a where a.actualite.id = :id")
//	public	List<ImageModel> findByIdActualite(@Param("id") int  id);
//	
//
//	@Query("select a  from ImageModel a where a.name = :name and a.actualite.id = :id")
//     public	Optional<ImageModel> findByActualite(@Param("name") String  name,@Param("id") int  id);
//	public	List<ImageModel> findByActualite(@Param("id") int  id);
	
//	
//	@Query("select a  from ImageModel a where a.actualite.id = :id")
//    public	Optional<ImageModel> findBytest(@Param("id") int  id);
}
