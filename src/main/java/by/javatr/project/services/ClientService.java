package by.javatr.project.services;

import by.javatr.project.entities.User;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.serviceexception.ServiceException;

import java.util.List;

public interface ClientService {

    boolean authenticate(String login, String password) throws DAOException, ServiceException;

    User getUser(String login, String password) throws DAOException, ServiceException;

    void register(User user) throws ServiceException;

    List<User> getUsers() throws ServiceException;

    void deleteUser(int id) throws ServiceException;

}
