package com.example.laundryapp.mapper;

import com.example.laundryapp.dto.UserDto;
import com.example.laundryapp.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {

        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto) {

        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
