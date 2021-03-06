package by.javatr.project.views;

import by.javatr.project.entities.User;
import by.javatr.project.entities.UserType;

import java.util.Scanner;

public class ViewSignUp {
    private final Scanner scanner = new Scanner( System.in );
    private String login;
    private String password;
    private String name;

    public void show() {
        System.out.println( "Логин:" );
        login = scanner.nextLine();
        System.out.println( "Пароль:" );
        password = scanner.nextLine();
        System.out.println( "Имя:" );
        name = scanner.nextLine();
    }

    public User getUser(){
        return new User( UserType.CLIENT, login, password, name );
    }
}
