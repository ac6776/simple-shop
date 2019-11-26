package com.mysimpleshop.simpleshop.services;


import com.mysimpleshop.simpleshop.entities.SystemUser;
import com.mysimpleshop.simpleshop.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String username);
    boolean save(SystemUser systemUser);
}
