package com.clean.architecture.repository;

import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;

@R2dbcRepository(
        dialect = Dialect.POSTGRES
)
public interface UserRepository extends ReactorCrudRepository<UserEntity, String> {
}
