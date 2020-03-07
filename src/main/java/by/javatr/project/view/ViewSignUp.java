package by.javatr.project.view;

import by.javatr.project.entity.User;
import by.javatr.project.entity.UserType;
import by.javatr.project.exception.daoexception.IncorrectFileException;

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

    public User getUser() throws IncorrectFileException {
        return new User( UserType.CLIENT, login, password, name );
    }
}
