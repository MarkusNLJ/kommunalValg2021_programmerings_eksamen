package com.example.demo.repository;

import com.example.demo.models.Parti;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartiRepository extends CrudRepository<Parti, Integer> {


}
