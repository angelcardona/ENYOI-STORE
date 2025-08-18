package com.store.users.infrastructure.adapters.web.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.users.domain.ports.in.UserUsesCases;
import com.store.users.infrastructure.adapters.mapper.UserMapper;
import com.store.users.infrastructure.adapters.web.dto.UserRequestDto;
import com.store.users.infrastructure.adapters.web.dto.UserResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUsesCases usesCases;
    private final UserMapper mapper;

    @PostMapping
    public Mono<UserResponseDto> createUser(@Valid@RequestBody UserRequestDto userRequestDto){
        return  usesCases.createUser(mapper.toDomain(userRequestDto)).map(mapper::toResponseDto);
    }
    @GetMapping("/{userId}")
    public Mono<UserResponseDto> getUserById(@PathVariable Long id){
        return  usesCases.getUserById(id).map(mapper::toResponseDto);
    }
    @GetMapping
    public Flux<UserResponseDto> getAllUsers(){
        return usesCases.getAllUsers().map(mapper::toResponseDto);
    }
    @PostMapping("/{userId}")
    public Mono<UserResponseDto> updateUser(@PathVariable Long userId, @Valid @RequestBody UserRequestDto requestDto){
        return usesCases.updateUser(userId, mapper.toDomain(requestDto)).map(mapper::toResponseDto);
    }
    @DeleteMapping("/{userId}")
    public Mono<Void> deleteUser(Long userId){
        return usesCases.deleteUser(userId);
    }



}
