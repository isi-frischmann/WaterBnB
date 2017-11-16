package com.zbay.waterbnb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zbay.waterbnb.models.Pool;
import com.zbay.waterbnb.models.Review;
import com.zbay.waterbnb.models.User;
import com.zbay.waterbnb.repositories.PoolRepository;
import com.zbay.waterbnb.repositories.ReviewRepository;
import com.zbay.waterbnb.repositories.UserRepository;

@Service
public class PoolService {
	private PoolRepository poolRepository;
	private UserRepository userRepository;
	private ReviewRepository reviewRepository;
	
    public PoolService(PoolRepository poolRepository, UserRepository userRepository, ReviewRepository reviewRepository)     {
        this.poolRepository = poolRepository;
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
    }
    
    public void newPool(Pool pool, User user) {
    	pool.setHost(user);
    	this.poolRepository.save(pool);
    }
    
    public void editPool(Pool editedPool, Long id) {
    	Pool oldPool = this.poolRepository.findOne(id);
    	oldPool.setSize(editedPool.getSize());
    	oldPool.setDescription(editedPool.getDescription());
    	oldPool.setNightlyCost(editedPool.getNightlyCost());
    	this.poolRepository.save(oldPool);
    }
    
    public void addReview(Review review) {
    	 this.reviewRepository.save(review);
    }
    
    public List<Pool> getAllPools() {
    	List<Pool> pools = this.poolRepository.findAll();
    	if(pools == null) {
    		pools = new ArrayList<Pool>();
    	}
    	return pools;
    }
    
    public Pool getById(Long id) {
    	return this.poolRepository.findOne(id);
    }
    
}
