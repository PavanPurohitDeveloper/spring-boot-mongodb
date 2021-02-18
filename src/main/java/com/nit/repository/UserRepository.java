package com.nit.repository;

import com.nit.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Spring Data MongoDB repository to access our data.

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
