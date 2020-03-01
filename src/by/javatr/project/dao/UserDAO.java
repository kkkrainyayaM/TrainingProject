package by.javatr.project.dao;

import by.javatr.project.bean.User;

public interface UserDAO {

    boolean signUp(User user );
    boolean signIn(String login, String password);

    void delete(int idUser);

    void updatePassword(String oldPassword, String newPassword);
}
