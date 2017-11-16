package com.zbay.waterbnb.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zbay.waterbnb.models.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {

}
