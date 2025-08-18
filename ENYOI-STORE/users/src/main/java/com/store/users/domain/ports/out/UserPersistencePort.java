package com.store.users.domain.ports.out;

import com.store.users.domain.models.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserPersistencePort {

    Mono<User> save(User user);
    Mono<User> findById(Long id);
    Mono<Void> deleteById(Long id);
    Flux<User> findAll();
    


}
