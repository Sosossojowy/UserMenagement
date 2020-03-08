package com.boizband.controllers;

import com.boizband.api.UsersApi;
import com.boizband.users.service.FileUsersManager;
import com.boizband.users.User;
import com.boizband.users.UsersManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController implements UsersApi {
    @Autowired
    private UsersManager usersManager;

    @Override
    public ResponseEntity getAllUsers() {
        return ResponseEntity.ok(usersManager.search(""));
    }

    @Override
    public ResponseEntity getUser(final String userId) {
        final User user = usersManager.searchById(userId);
        if (user == null) {
            return new ResponseEntity("ID from path is not equals with the one in the body", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity addUser(User user) {
        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getAge() == 0 || user.getPhoneNumber().isEmpty()) {

            return new ResponseEntity<>("Bad data", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(usersManager.add(user));
    }

    @Override
    public ResponseEntity deleteUser(String userId) {
        usersManager.delete(userId);
        return new ResponseEntity<>("Brak użytkownika, lub zostało wprowadzone błedne ID", HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity updateUser(final String userId, User user) {
        if (!user.getId().equals(userId)) {
            return new ResponseEntity<>("Id from path is not equals with the one in the body", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(usersManager.update(user));
    }
}
