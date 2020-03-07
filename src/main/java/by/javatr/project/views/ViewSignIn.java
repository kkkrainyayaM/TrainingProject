package by.javatr.project.views;

import java.util.Scanner;

public class ViewSignIn {
    private final Scanner scanner = new Scanner( System.in );
    private String login;
    private String password;

    public void show() {
        System.out.println("Логин:" );
        login = scanner.nextLine();
        System.out.println( "Пароль:"  );
        password = scanner.nextLine();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
