package com.boizband.users;

import java.util.ArrayList;
import java.util.List;


public class UsersManager {
    private List<User> users;
    public UsersManager() {
        this.users = new ArrayList<User>();
    }

    public void add(User user) {
        extendUsers();
        this.users[this.users.length - 1] = user;
    }

    public void delete(int userId) {
        //TODO to be implemented
        User userForDelete = null;
        for (int idx = 0; idx < this.users.size(); idx++) {
            if (this.users.get(idx).getId() == userId) {
                userForDelete= this.users.get(idx);
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
    public List<User> search(String pattern) {
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
