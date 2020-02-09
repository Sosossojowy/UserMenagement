package com.boizband.users;

import java.io.*;
import java.nio.charset.StandardCharsets;
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
        try (FileWriter file = new FileWriter(this.getClass().getResource("/users.txt").getPath());
             BufferedWriter writer = new BufferedWriter(file)) {
            for (final User user : this.users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
