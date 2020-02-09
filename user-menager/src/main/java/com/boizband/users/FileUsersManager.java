package com.boizband.users;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUsersManager implements UsersManager {

    private List<User> users;

    public FileUsersManager() {
        this.users = readFromFile();
    }

    private List<User> readFromFile() {
        final List<User> result = new ArrayList<User>();
        try (InputStream file = FileUsersManager.class.getResourceAsStream("/users.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(file, StandardCharsets.UTF_8))) {
            String nextLine = reader.readLine();
            while (nextLine !=null){
                final String[] userData = nextLine.split(";");
                result.add(new User(Integer.parseInt(userData[0]),Integer.parseInt(userData[1]),userData[2],userData[3],userData[4]));
                nextLine = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return result;
    }

    private void saveFile() {
        try (FileWriter file = new FileWriter(this.getClass().getResource("/users.txt").getPath(), false);
             BufferedWriter writer = new BufferedWriter(file)) {
            for (User user : this.users) {
                writer.write(user.toString());
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
        } catch (IOException e) {
            System.out.println("Nie można zapisać pliku!");
        }
    }

    @Override
    public void add(User user) {
        this.users.add(user);
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

        return this.users;
    }

    @Override
    public User searchId(int userId) {

        return null;
    }
}

