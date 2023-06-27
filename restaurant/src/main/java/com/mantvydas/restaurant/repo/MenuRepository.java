package com.mantvydas.restaurant.repo;

import com.mantvydas.restaurant.model.Menu;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
}
