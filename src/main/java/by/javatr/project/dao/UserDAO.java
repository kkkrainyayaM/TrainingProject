package by.javatr.project.dao;

import by.javatr.project.entity.User;

import java.util.ArrayList;

public interface UserDAO {

    /**
     * Registration. Add user record to file
     *
     * @param user- User
     */
    void signUp(User user);

    /**
     * Authentication. Find if user exists
     *
     * @param login    - attribute of User
     * @param password - attribute of User
     * @return true if user exists
     */
    boolean signIn(String login, String password);

    /**
     * Delete user record from file
     *
     * @param id - User id
     */
    void delete(int id);

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
    User getUser(String login, String password);

    int getLastId();
}
