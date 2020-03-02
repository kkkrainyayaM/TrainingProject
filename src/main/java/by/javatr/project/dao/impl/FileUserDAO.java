package by.javatr.project.dao.impl;

import by.javatr.project.dao.UserDAO;
import by.javatr.project.entity.User;
import by.javatr.project.entity.UserType;
import by.javatr.project.utils.FileUtil;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.sun.xml.internal.stream.writers.WriterUtility.SPACE;

public class FileUserDAO implements UserDAO {

    private static final int ID_INDEX = 0;
    private static final int TYPE_INDEX = 1;
    private static final int LOGIN_INDEX = 2;
    private static final int PASSWORD_INDEX = 3;
    private static final int NAME_INDEX = 4;
    private static final String FILE_NAME = "C:/Users/rizhi/Documents/" +
            "Training/FinancialAccountingApp/src/main/resources/user.txt";
    private FileUtil fileUtil = new FileUtil( FILE_NAME );
    private ArrayList<User> users;


    public FileUserDAO() {
        users = getAll();
    }

    @Override
    public boolean signIn(String login, String password) {
        return users.stream().anyMatch( x -> x.getLogin()
                .equals( login ) && x.getPassword()
                .equals( password ) );
    }

    @Override
    public void signUp(User user) {
        fileUtil.addRecord( user.getId() + " " + user.getType() + " " + user.getLogin()
                + " " + user.getPassword() + " " + user.getName() );
        users.add( user );

    }

    @Override
    public void delete(User user) {
        users.remove( users.stream().findFirst().filter( x -> user.getId() == x.getId() ).get() );
        fileUtil.updateFile( users.stream().map( this::buildString )
                .collect( Collectors.toCollection( ArrayList::new ) ) );
    }

    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String login, String password) {
        return users.stream().filter( x -> x.getLogin()
                .equals( login ) && x.getPassword()
                .equals( password ) ).findFirst().get();
    }

    private ArrayList<User> getAll() {
        return fileUtil.getAllRecords().stream()
                .map( this::buildUser )
                .collect( Collectors
                        .toCollection( ArrayList::new ) );

    }

    private User buildUser(String userRecord) {
        String[] userFields = userRecord.split( SPACE );
        return new User( Integer.valueOf( userFields[ID_INDEX] ),
                UserType.valueOf( userFields[TYPE_INDEX] ),
                userFields[LOGIN_INDEX],
                userFields[PASSWORD_INDEX],
                userFields[NAME_INDEX] );
    }

    private String buildString(User user) {
        return user.getId() + " " + user.getType() + " " + user.getLogin()
                + " " + user.getPassword() + " " + user.getName();
    }
}