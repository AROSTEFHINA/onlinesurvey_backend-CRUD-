package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ApiModel;
@Repository
public interface ApiRepo extends JpaRepository<ApiModel,Long>{

}