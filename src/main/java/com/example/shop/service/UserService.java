package com.example.shop.service;

import com.example.shop.domain.jpa.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface UserService {

    User save(User user);
    User searchById(Long id);
    Page<User> getPage(Pageable pageable);
    void deleteById(Long id);

}
