package com.example.labofinal.services;

import com.example.labofinal.models.entity.User;
import org.springframework.stereotype.Service;


public interface UserService extends CrudService<User, Long>{

    User login(User entity);
}
