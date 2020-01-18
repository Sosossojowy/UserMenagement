package com.boizband.users;

import java.util.Scanner;

public class UsersManager {
    private User[] users;

    public UsersManager() {
        this.users = new User[0];
    }

    public void add(User user) {
        extendUsers();
        this.users[this.users.length -1] = user;
    }

    public void delete(int userId) {
        //TODO to be implemented
        for (int idx = 0; idx < this.users.length; idx++) {
            if (this.users[idx].getId() == userId) {
                this.users[idx] = null;
                break;
            }
        }
        User[] newUsers = new User[this.users.length-1];
        byte x = 0;
        for (int idx = 0; idx < newUsers.length; idx++) {
            if (this.users[idx] == null) {
                x = 1;
            }
            newUsers[idx]=this.users[idx + x];
        }
        this.users = newUsers;
    }

    public void update(User userForUpdate) {
        for (int idx = 0; idx < this.users.length; idx++) {
            if (userForUpdate.getId() == this.users[idx].getId()) {
                User user = this.users[idx];
                user.setFirstName(userForUpdate.getFirstName());
                user.setLastName(userForUpdate.getLastName());
                user.setAge(userForUpdate.getAge());
                user.setPhoneNumber(userForUpdate.getPhoneNumber());
            }
        }
    }
    public User[] search(String pattern) {
        //TODO to be implemented
        return this.users;
    }

    private void extendUsers() {
        User[] newUsers = new User[this.users.length + 1];
        for (int idx = 0; idx < this.users.length; idx++) {
            newUsers[idx] = this.users[idx];
        }
        this.users = newUsers;
    }
}
