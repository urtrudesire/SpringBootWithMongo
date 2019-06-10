package com.hotels.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotels,String>, QuerydslPredicateExecutor<Hotels> {

    List<Hotels> findByrateLessThan(int max);
    Hotels findByid(String id);

}
