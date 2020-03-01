package by.javatr.project.dao.impl;

import by.javatr.project.bean.User;
import by.javatr.project.dao.IDGenerator;
import by.javatr.project.dao.UserDAO;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUserDAO implements UserDAO {

     private static final String FILE_NAME = "../resource/user.txt";
     private FileWriter fileWriter = new FileWriter(FILE_NAME, true);
    private FileReader fileReader = new FileReader(FILE_NAME);

    public FileUserDAO() throws IOException {
    }

    @Override
    public void signIn(String login, String password) {

    }

    @Override
    public void signUp(User user) {
        try {
        fileWriter.write( user.getId()+" "+user.getType()+" " +user.getLogin()+" "+ user.getPassword()+" "+user.getName() );
        fileWriter.flush();
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    }

    @Override
    public void delete(int idUser) {

    }

    @Override
    public void updatePassword(String oldPassword, String newPassword) {

    }

    private void close() throws IOException {
        fileReader.close();
        fileWriter.close();
    }
}
