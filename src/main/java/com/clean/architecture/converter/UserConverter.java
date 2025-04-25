package com.clean.architecture.converter;

import com.clean.architecture.repository.UserEntity;
import com.clean.architecture.usecase.user.add.AddUserUseCaseRequest;
import com.clean.architecture.usecase.user.delete.DeleteUserUseCaseRequest;
import com.clean.architecture.usecase.user.update.UpdateUserUseCaseRequest;
import org.h2.engine.User;

import java.util.UUID;

public class UserConverter {
    private UserConverter() {
    }

    public static UserEntity toEntity(AddUserUseCaseRequest user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString().replace("-", ""));
        userEntity.setUsername(user.username());
        userEntity.setEmail(user.email());
        userEntity.setAddress(user.address());
        userEntity.setPassword("Hashing Password");
        userEntity.setRole("USER");
        userEntity.setStatus("ACTIVE");
        userEntity.setCreatedAt("2022-01-01");
        userEntity.setUpdatedAt("2022-01-01");
        userEntity.setDeletedAt(null);
        userEntity.setDeletedBy(null);
        userEntity.setCreatedBy("SYSTEM");
        userEntity.setUpdatedBy("SYSTEM");
        userEntity.setPhone("0000000000");
        userEntity.setActive(false);
        return userEntity;
    }

    public static String tostring(DeleteUserUseCaseRequest user){
        return user.id();

    }

    public static UserEntity toUpdate(UpdateUserUseCaseRequest user){

        UserEntity updateEntity=new UserEntity();
        updateEntity.setId(user.id());
        updateEntity.setUsername(user.username());
        updateEntity.setEmail(user.email());
        updateEntity.setAddress(user.address());
        return updateEntity;

    }

    public static UserEntity toUpdatableEntity(UserEntity originalEntity, UpdateUserUseCaseRequest updatableData){
        originalEntity.setId(originalEntity.getId());
        originalEntity.setUsername(updatableData.username());
        originalEntity.setEmail(updatableData.email());
        originalEntity.setAddress(updatableData.address());
        return originalEntity;
    }


}
