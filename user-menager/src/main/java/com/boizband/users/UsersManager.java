package com.boizband.users;

import java.util.ArrayList;
import java.util.List;


public class UsersManager {
    private List<User> users;

    public UsersManager() {
        this.users = new ArrayList<User>();
    }

    public void add(User user) {
        this.users.add(user);
    }

    public void delete(int userId) {
        //TODO to be implemented
        User userForDelete = null;
        for (int idx = 0; idx < this.users.size(); idx++) {
            if (this.users.get(idx).getId() == userId) {
                userForDelete = this.users.get(idx);
                break;
            }
        }
        this.users.remove(userForDelete);
    }

    public void update(User userForUpdate) {
        for (int idx = 0; idx < this.users.size(); idx++) {
            if (userForUpdate.getId() == this.users.get(idx).getId()) {
                User user = this.users.get(idx);
                user.setFirstName(userForUpdate.getFirstName());
                user.setLastName(userForUpdate.getLastName());
                user.setAge(userForUpdate.getAge());
                user.setPhoneNumber(userForUpdate.getPhoneNumber());
            }
        }
    }

    public List<User> search(final String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return this.users;
        }
        final List<User> searchResult = new ArrayList<User>();
        for (final User user : this.users) {
            if (user.getFirstName().contains(pattern)) {
                searchResult.add(user);
            } else if (user.getLastName().contains(pattern)) {
                searchResult.add(user);
            } else if (user.getPhoneNumber().contains(pattern)) {
                searchResult.add(user);
            } else if (isNumber(pattern)&& user.getAge()== Integer.parseInt(pattern)){
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
}
