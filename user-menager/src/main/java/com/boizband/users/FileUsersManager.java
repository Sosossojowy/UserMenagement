package com.boizband.users;

import java.util.ArrayList;
import java.util.List;

public class FileUsersManager implements UsersManager{

    private List<User> users;

    public FileUsersManager() {
        this.users = readFromFile();
    }

    private List<User> readFromFile() {
        final List<User> result = new ArrayList<User>();
        //TODO Wczytac userow z pliku.
        return result;
    }

    private void saveFile(){
        //TODO Zapisac userow do pliku.
    }

    @Override
    public void add(User user) {

        saveFile();

    }

    @Override
    public void delete(int userId) {

        saveFile();

    }

    @Override
    public void update(User userForUpdate) {

        saveFile();

    }

    @Override
    public List<User> search(String pattern) {
        return null;
    }

    @Override
    public User searchId(int userId) {
        return null;
    }
}
