package com.boizband.users;

import com.boizband.users.errors.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;


public class UsersManager {
    private List<User> users;
    private static int lastId = 0;


    public UsersManager() {
        init();

    }

    private void init() {
        this.users = new ArrayList<User>();
        add(new User(generateId(), 32,"Paweł", "Piwkowski","608319712"));
        add(new User(generateId(),18, "Paulina", "Cyrta","666999666"));
        add(new User(generateId(),19, "Marta", "Rosołek","777888999"));
        add(new User(generateId(),20, "Karol", "Buler","555888666"));
        add(new User(generateId(),21, "Kamil", "Kosiński","333222111"));
    }

    public int generateId() {
        return ++lastId;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public void delete(int userId) {
        User userForDelete = null;
        for (User user : this.users) {
            if (user.getId() == userId) {
                userForDelete = user;
                break;
            }
        }
        this.users.remove(userForDelete);
    }

    public void update(User userForUpdate) {
        if (this.users.size() == 0) {
            throw new UserNotFoundException("User not found.");
        }
        for (User user : this.users) {
            if (userForUpdate.getId() == user.getId()) {
                user.setFirstName(userForUpdate.getFirstName());
                user.setLastName(userForUpdate.getLastName());
                user.setAge(userForUpdate.getAge());
                user.setPhoneNumber(userForUpdate.getPhoneNumber());
                return;
            }
        }
    }

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

    private boolean isNumber(String pattern) {
        try {
            Integer.parseInt(pattern);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public List<User> searchId(final int pattern) {
        final List<User> searchResult = new ArrayList<User>();
        for (final User user : this.users) {
            if (user.getId() == pattern) {
                searchResult.add(user);
            }
        }
        if (searchResult.size() == 0) {
            System.out.println("Nie znaleziono użytkownika");
        }
        return searchResult;
    }
}
