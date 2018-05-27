package com.example.spring.mail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.spring.mail.bean.Mailinfo;

public interface IMongoRepository extends MongoRepository<Mailinfo, String> {

}
