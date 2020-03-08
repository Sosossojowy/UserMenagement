package com.boizband.users.service;

import com.boizband.persistent.entity.UserEntity;
import com.boizband.persistent.repository.UsersRepository;
import com.boizband.users.User;
import com.boizband.users.UsersManager;
import com.boizband.users.errors.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DatabaseUsersManager implements UsersManager {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User add(User user) {
        final UserEntity userEntity = UsersConverter.toPersistent(user);
        final User createdUser = UsersConverter.toModel(usersRepository.save(userEntity));
        return createdUser;
    }

    @Override
    public void delete(String userId) {

    }

    @Override
    public User update(User userForUpdate) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<User> search(String pattern) {
        Iterator<UserEntity> allUsers = usersRepository.findAll().iterator();
        List<User> result = new ArrayList<>();
        while (allUsers.hasNext()){
            result.add(UsersConverter.toModel(allUsers.next()));
        }
        return result;
    }

    @Override
    public User searchById(String userId) {
       final UserEntity userEntity = usersRepository.findByIdIgnoreCase(userId);
        return UsersConverter.toModel(userEntity);
    }
}
