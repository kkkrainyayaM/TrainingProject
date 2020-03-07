package by.javatr.project.dao;

import by.javatr.project.entity.User;
import by.javatr.project.exception.DAOExeption;
import by.javatr.project.exception.daoexeption.IncorrectCredentialsException;

import java.util.ArrayList;

public interface UserDAO {

    /**
     * Registration. Add user record to file
     *
     * @param user- User
     */
    void signUp(User user) throws DAOExeption;

    /**
     * Authentication. Find if user exists
     *
     * @param login    - attribute of User
     * @param password - attribute of User
     * @return true if user exists
     */
    boolean signIn(String login, String password) throws IncorrectCredentialsException, DAOExeption;

    /**
     * Delete user record from file
     *
     * @param id - User id
     */
    void delete(int id) throws DAOExeption;

    /**
     * Get all users
     *
     * @return list of users
     */
    ArrayList<User> getUsers();

    /**
     * Get User after authentication by login and password
     *
     * @param login    - attribute of User
     * @param password - attribute of User
     * @return User
     */
    User getUser(String login, String password) throws IncorrectCredentialsException, DAOExeption;

    int getLastId();
}
