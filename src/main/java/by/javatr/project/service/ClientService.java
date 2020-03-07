package by.javatr.project.service;

import by.javatr.project.entity.User;

import java.util.ArrayList;

public interface ClientService {

    boolean authenticate(String login, String password);

    User getUser(String login, String password);

    void register(User user);

    ArrayList<User> getUsers();

    void deleteUser(int id);

}
