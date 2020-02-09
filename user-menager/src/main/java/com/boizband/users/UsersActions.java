package com.boizband.users;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UsersActions {
    private UsersManager usersManager;
    private Scanner scanner;

    public UsersActions() {
        this.usersManager = new FileUsersManager();
        this.scanner = new Scanner(System.in);

    }

    public void addUser() throws IllegalArgumentException {
        System.out.println("Podaj dane użytkownika w formacie:\nIMIĘ;NAZWISKO;WIEK;NUMER_TELEFONU");
        final String userStr = scanner.nextLine();
        final String[] userData = userStr.split(";");
        if (userData.length != 4) {
            throw new IllegalArgumentException("niepoprawny format danych użytkownika");
        }

        final User newUser = new User();
        newUser.setId(0);
        newUser.setFirstName(userData[0]);
        newUser.setLastName(userData[1]);
        newUser.setAge(Integer.parseInt(userData[2]));
        newUser.setPhoneNumber(userData[3]);
        usersManager.add(newUser);
    }

    public void deleteUser() {
        System.out.println("podaj ID użytkownika do usunięcia");
        int idToDelete = scanner.nextInt();
        usersManager.delete(idToDelete);
        scanner.nextLine();
    }

    public void showAll() {
        printUserData(usersManager.search(""));
    }

    private void printUserData(List<User> users) {
        for (User user : users) {
            String userData = "Id: " + user.getId() + ", " +
                    "Imię: " + user.getFirstName() + ", " +
                    "Nazwisko: " + user.getLastName() + ", " +
                    "Wiek: " + user.getAge() + ", " +
                    "Numer telefonu: " + user.getPhoneNumber() + "; ";
            System.out.println(userData);

            //powyzej to co podpowiedzial intellij
//            StringBuilder userData = new StringBuilder();
//            userData.append("Id: ").append(user.getId()).append(", ");
//            userData.append("Imię: ").append(user.getFirstName()).append(", ");
//            userData.append("Nazwisko: ").append(user.getLastName()).append(", ");
//            userData.append("Wiek: ").append(user.getAge()).append(", ");
//            userData.append("Numer telefonu: ").append(user.getPhoneNumber()).append("; ");
//            System.out.println(userData.toString());
        }
    }

    public void searchUser() {
        System.out.println("Podaj dane użytkownika oddzielony ; bez spacji");
        String pattern = scanner.nextLine();
        printUserData(usersManager.search(pattern));
    }

    public void quit() {
        System.out.println("Do zobaczenia :)");
    }

    public void updateUser() {
        System.out.println("Podaj ID użytkownika, którego chcesz uaktualnic");
        int idToUpdate = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj dane użytkownika w formacie:\nIMIĘ;NAZWISKO;WIEK;NUMER TELEFONU");
        final String userStr = scanner.nextLine();
        final String[] userData = userStr.split(";");
        //System.out.println(idToUpdate + "" + Arrays.toString(userData));
        //wypisuje wprowadzone nowe dane
        if (userData.length != 4) {
            throw new IllegalArgumentException("niepoprawny format danych użytkownika");
        }

        final User userUpdate = new User();
        userUpdate.setId(idToUpdate);
        userUpdate.setFirstName(userData[0]);
        userUpdate.setLastName(userData[1]);
        userUpdate.setAge(Integer.parseInt(userData[2]));
        userUpdate.setPhoneNumber(userData[3]);
        usersManager.update(userUpdate);
    }

    public void searchById() {
        System.out.println("Podaj ID użytkownika");
        int userId = scanner.nextInt();
        scanner.nextLine();
        printUserData(Arrays.asList(usersManager.searchId(userId)));
    }
}
