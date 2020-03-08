package com.boizband.persistent.repository;

import com.boizband.persistent.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, String> {
    UserEntity findByIdIgnoreCase(String userId);


}
//TODO nazywanie metod w spring repository do poczytania