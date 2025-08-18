package com.store.users.infrastructure.adapters.mapper;

import org.springframework.stereotype.Component;

import com.store.users.domain.models.User;
import com.store.users.infrastructure.adapters.persistence.entity.UserEntity;
import com.store.users.infrastructure.adapters.web.dto.UserRequestDto;
import com.store.users.infrastructure.adapters.web.dto.UserResponseDto;

@Component
public class UserMapper {

    // Persistence Entity to model

    public User toDomain(UserEntity userEntity){
        return new User(
            userEntity.getId(),
            userEntity.getName(),
            userEntity.getEmail(),
            userEntity.getAddress(),
            userEntity.getPhone()
        );
    }

    public UserEntity toEntity(User user){
        return new UserEntity(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getAddress(),
            user.getPhone()
        );
    }

    // Model to Dto

    public User toDomain(UserRequestDto userRequestDto){
        return  new User(
            null,
            userRequestDto.getName(),
            userRequestDto.getEmail(),
            userRequestDto.getAddress(),
            userRequestDto.getPhone()

        );
    }
    public UserResponseDto toResponseDto(User user){
        return new UserResponseDto(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getAddress(),
            user.getPhone()
            );
    }

}
