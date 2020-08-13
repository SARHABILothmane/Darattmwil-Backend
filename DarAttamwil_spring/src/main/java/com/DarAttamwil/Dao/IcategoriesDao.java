package com.DarAttamwil.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.DarAttamwil.Entity.Categories;

public interface IcategoriesDao extends JpaRepository<Categories, Integer>{

}
