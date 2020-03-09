package by.javatr.project.services;

import by.javatr.project.entities.User;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.serviceexception.ServiceException;

import java.util.List;

public interface ClientService {

    /**
     * Authenticate user by credentials
     *
     * @param login    - login from input
     * @param password - password from input
     * @return true if user with this credentials exist
     * @throws DAOException
     * @throws ServiceException
     */
    boolean authenticate(String login, String password) throws DAOException, ServiceException;

    /**
     * Get user from list of users
     *
     * @param login    - login of User
     * @param password - password of User
     * @return user
     * @throws DAOException
     * @throws ServiceException
     */
    User getUser(String login, String password) throws DAOException, ServiceException;

    /**
     * Register user
     *
     * @param user - User
     * @throws ServiceException
     */
    void register(User user) throws ServiceException;

    /**
     * Get list of all users
     *
     * @return list if users
     * @throws ServiceException
     */
    List<User> getUsers() throws ServiceException;

    /**
     * Delete user by id
     *
     * @param id - User id
     * @throws ServiceException
     */
    void deleteUser(int id) throws ServiceException;

}
