package com.myApp.myApp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.myApp.entities.concretes.Opinion;

public interface OpinionDao extends JpaRepository<Opinion,Integer>{

}
