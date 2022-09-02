package com.syntaxerror.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syntaxerror.crud.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Integer> {

}
