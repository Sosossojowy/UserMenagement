package com.boizband;

import com.boizband.users.UsersActions;
import com.boizband.users.UsersManager;

import java.util.Scanner;

public class UserApplications {
    public static void main(String[] args) {
        UsersActions usersActions = new UsersActions();
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;
        while (userChoice != 7) {
            System.out.println("Co chcesz zrobic?\n1. Dodaj użytkownika\n2. Usuń użytkownika\n3. Wyświetl wsystkich użytkowników\n4. Wyszukaj użytkownika\n5. Wyszukaj użytkownika po ID\n6. Uaktualnij dane użytkownika\n7. Wyjdź");
            userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1:
                    usersActions.addUser();
                    break;
                case 2:
                    usersActions.deleteUser();
                    break;
                case 3:
                    usersActions.showAll();
                    break;
                case 4:
                    usersActions.searchUser();
                    break;
                case 5:
                    usersActions.searchById();
                    break;
                case 6:
                    usersActions.updateUser();
                    break;
                case 7:
                    usersActions.quit();
                    break;
                default: {
                    System.out.println("Błędny wybór");
                    break;
                }

            }


        }
    }
}
