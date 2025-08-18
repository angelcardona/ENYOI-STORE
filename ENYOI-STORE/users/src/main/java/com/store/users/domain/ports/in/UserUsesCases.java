package com.store.users.domain.ports.in;

import com.store.users.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserUsesCases {

    Mono<User> createUser(User user);
    Mono<User> getUserById(Long id);
    Flux<User> getAllUsers();
    Mono<User> updateUser(Long userId,User user);
    Mono<Void> deleteUser(Long id);

}
