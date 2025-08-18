package com.store.users.infrastructure.adapters.persistence.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.store.users.infrastructure.adapters.persistence.entity.UserEntity;

public interface UserSpringR2bcRepository extends ReactiveCrudRepository<UserEntity, Long> {

}
