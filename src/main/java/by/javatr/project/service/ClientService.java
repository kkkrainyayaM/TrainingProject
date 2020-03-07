package by.javatr.project.service;

import by.javatr.project.entity.User;
import by.javatr.project.exception.daoexception.DAOException;
import by.javatr.project.exception.serviceexception.ServiceException;

import java.util.ArrayList;

public interface ClientService {

    boolean authenticate(String login, String password) throws DAOException, ServiceException;

    User getUser(String login, String password) throws DAOException, ServiceException;

    void register(User user) throws ServiceException;

    ArrayList<User> getUsers() throws ServiceException;

    void deleteUser(int id) throws ServiceException;

}
