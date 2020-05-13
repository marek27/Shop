package com.example.shop.mapper;

import com.example.shop.domain.dto.UserDto;
import com.example.shop.domain.jpa.User;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto userToUserDto(User user) {
        return UserDto.builder()
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .id(user.getId())
                .build();
    }

    public User userDtoToUser ( UserDto userDto) {
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .id(userDto.getId())
                .build();
    }

    public List<UserDto> userListToUserListDto(List<User> users) {
        return users.stream()
                .map(this::userToUserDto)
                .collect(Collectors.toList());
    }
}