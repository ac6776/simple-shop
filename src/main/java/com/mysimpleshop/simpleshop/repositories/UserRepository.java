package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByUserName(String userName);
}
