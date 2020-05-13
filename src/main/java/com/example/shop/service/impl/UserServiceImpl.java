package com.example.shop.service.impl;

import com.example.shop.domain.jpa.User;
import com.example.shop.repository.jpa.UserRepository;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.awt.print.Pageable;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User searchById(Long id) {
       return userRepository.findById(id)
               .orElseThrow( ()->
                       new EntityNotFoundException("User with id " + id + " is not exist"));

    }

    @Override
    public Page<User> getPage(Pageable pageable) {
        Page<User> all = userRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        return new PageImpl<>(all.getContent(), all.getPageable(), all.getTotalElements());
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
