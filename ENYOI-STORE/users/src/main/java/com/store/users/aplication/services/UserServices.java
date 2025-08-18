package com.store.users.aplication.services;

import org.springframework.stereotype.Service;

import com.store.users.domain.models.User;
import com.store.users.domain.ports.in.UserUsesCases;
import com.store.users.domain.ports.out.UserPersistencePort;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServices implements UserUsesCases {

    private final UserPersistencePort persistence;


    @Override
    public Mono<User> createUser(User user) {
        return  persistence.save(user);
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return persistence.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("User not found with id:" + id)));
    }

    @Override
    public Flux<User> getAllUsers() {
        return persistence.findAll();
    }

    @Override
    public Mono<User> updateUser(Long userId, User user) {
        Mono<User> existingUser= persistence.findById(userId);
        return existingUser.flatMap(userFound->{
            userFound.setName(user.getName());
            userFound.setEmail(user.getEmail());
            userFound.setAddress(user.getAddress());
            userFound.setPhone(user.getPhone());
            return persistence.save(userFound);
        }).switchIfEmpty(Mono.error(new RuntimeException("User not found with id:"+ userId)));
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return persistence.deleteById(id);
    }

}
