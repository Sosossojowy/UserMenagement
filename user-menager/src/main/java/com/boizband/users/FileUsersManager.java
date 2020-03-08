package com.boizband.users;

import com.boizband.users.errors.UserNotFoundException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FileUsersManager implements UsersManager {

    private List<User> users;

    public FileUsersManager() {
        this.users = readFromFile();
    }

    private List<User> readFromFile() {

        final List<User> result = new ArrayList<>();
        try (InputStream file = FileUsersManager.class.getResourceAsStream("/users.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8))) {

            String dataUserInString;
            while ((dataUserInString = reader.readLine()) != null) {
                final String[] userData = dataUserInString.split(";");
                final User newUser = new User();
                newUser.setId(UUID.fromString(userData[0]).toString());
                newUser.setAge(Integer.parseInt(userData[1]));
                newUser.setFirstName(userData[2]);
                newUser.setLastName(userData[3]);
                newUser.setPhoneNumber(userData[4]);
                result.add(newUser);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private void saveFile() {

        try (FileWriter file = new FileWriter(this.getClass().getResource("/users.txt").getPath());
             BufferedWriter writer = new BufferedWriter(file)) {
            for (User user : this.users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private String generateId() {

        return UUID.randomUUID().toString();
    }


    @Override
    public User add(User user) {
        if (user.getId() == null || user.getId().isEmpty()) {
            user.setId(generateId());
        }
        this.users.add(user);
        saveFile();
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
        if (userForDelete != null) {
            this.users.remove(userForDelete);
        }
        saveFile();
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
                saveFile();
                return user;
            }
        }
        throw new UserNotFoundException("User not found.");


    }

    @Override
    public List<User> search(String pattern) {
        String patternUpper = pattern.toUpperCase();
        if (pattern.isEmpty()) {
            return this.users;
        }
        final List<User> searchResult = new ArrayList<>();
        for (final User user : this.users) {
            if (user.getFirstName().toUpperCase().contains(patternUpper)) {
                searchResult.add(user);
            } else if (user.getLastName().toUpperCase().contains(patternUpper)) {
                searchResult.add(user);
            } else if (user.getPhoneNumber().contains(pattern)) {
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

    @Override
    public User searchById(String userId) {


        for (final User user : this.users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        System.out.println("User not found.");
        return null;

    }
}