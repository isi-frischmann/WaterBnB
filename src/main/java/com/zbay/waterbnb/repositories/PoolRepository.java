package com.zbay.waterbnb.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zbay.waterbnb.models.Pool;

public interface PoolRepository extends CrudRepository<Pool, Long>{
	List<Pool> findAll();
}
