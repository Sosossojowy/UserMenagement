package com.boizband.users.service;

import com.boizband.users.User;
import com.boizband.users.UsersManager;
import com.boizband.users.errors.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ListUsersManager implements UsersManager {
    private List<User> users;
    private static int lastId = 0;

    public ListUsersManager() {
        init();
    }

    private void init() {
        this.users = new ArrayList<User>();
//        add(new User(generateId(), 32,"Paweł", "Piwkowski","608319712"));
//        add(new User(generateId(),18, "Paulina", "Cyrta","666999666"));
//        add(new User(generateId(),19, "Marta", "Rosołek","777888999"));
//        add(new User(generateId(),20, "Karol", "Buler","555888666"));
//        add(new User(generateId(),21, "Kamil", "Kosiński","333222111"));
        //uncomment for tests
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public User add(User user) {
        {
            if (user.getId() == null || user.getId().isEmpty()) {
                user.setId(generateId());
            }
        }
        this.users.add(user);
        return user;
    }

    @Override
    public void delete(String userId) {
        User userForDelete = null;
        for (User user : this.users) {
            if (user.getId().equals(userId)) {
                userForDelete = user;
                break;
            }
        }
        this.users.remove(userForDelete);

    }

    @Override
    public User update(User userForUpdate) {
        if (this.users.size() == 0) {
            throw new UserNotFoundException("User not found.");
        }
        for (User user : this.users) {
            if (userForUpdate.getId().equals(user.getId())) {
                user.setFirstName(userForUpdate.getFirstName());
                user.setLastName(userForUpdate.getLastName());
                user.setAge(userForUpdate.getAge());
                user.setPhoneNumber(userForUpdate.getPhoneNumber());
                return user;
            }
        }
        return userForUpdate;
    }

    @Override
    public List<User> search(final String pattern) {
        String patternUpper = pattern.toUpperCase();
        if (pattern.isEmpty()) {
            return this.users;
        }
        final List<User> searchResult = new ArrayList<User>();
        for (final User user : this.users) {
            if (user.getFirstName().toUpperCase().contains(patternUpper)) {
                searchResult.add(user);
            } else if (user.getLastName().toUpperCase().contains(patternUpper)) {
                searchResult.add(user);
            } else if (user.getPhoneNumber().toUpperCase().contains(patternUpper)) {
                searchResult.add(user);
            } else if (isNumber(pattern) && user.getAge() == Integer.parseInt(pattern)) {
                searchResult.add(user);
            }
        }
        return searchResult;
    }

    @Override
    public User searchById(final String userId) {
        for (final User user : this.users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        System.out.println("Nie znaleziono użytkownika");
        return null;
    }

    private boolean isNumber(String pattern) {
        try {
            Integer.parseInt(pattern);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}