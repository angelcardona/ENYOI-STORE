package com.store.users.infrastructure.adapters.persistence;

import org.springframework.stereotype.Component;

import com.store.users.domain.models.User;
import com.store.users.domain.ports.out.UserPersistencePort;
import com.store.users.infrastructure.adapters.mapper.UserMapper;
import com.store.users.infrastructure.adapters.persistence.repository.UserSpringR2bcRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserMapper mapper;
    private final UserSpringR2bcRepository repository;

    @Override
    public Mono<User> save(User user) {
        return repository.save(mapper.toEntity(user)).map(mapper::toDomain);
    }

    @Override
    public Mono<User> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
       return repository.deleteById(id);
    }

    @Override
    public Flux<User> findAll() {
       return repository.findAll().map(mapper::toDomain);
    }

}
