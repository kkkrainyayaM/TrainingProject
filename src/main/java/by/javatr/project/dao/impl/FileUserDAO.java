package by.javatr.project.dao.impl;

import by.javatr.project.dao.UserDAO;
import by.javatr.project.entities.User;
import by.javatr.project.entities.UserType;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.utils.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.sun.xml.internal.stream.writers.WriterUtility.SPACE;

public class FileUserDAO implements UserDAO {

    private static final int ID_INDEX = 0;
    private static final int TYPE_INDEX = 1;
    private static final int LOGIN_INDEX = 2;
    private static final int PASSWORD_INDEX = 3;
    private static final int NAME_INDEX = 4;
    private static final String FILE_NAME = "C:/Users/rizhi/Documents/" +
            "Training/FinancialAccountingApp/src/main/resources/users.txt";
    private List<User> users;


    public FileUserDAO() throws DAOException {
        users = getAll();
    }

    @Override
    public boolean signIn(String login, String password) throws DAOException {
        if( login.equals( "" ) || password.equals( "" ) ) throw new DAOException( "Null credentials" );
        return users.stream().anyMatch( x -> x.getLogin()
                .equals( login ) && x.getPassword()
                .equals( password ) );
    }

    @Override
    public void signUp(User user) throws IncorrectFileException, DAOException {
        if( user == null ) throw new DAOException( "Null user" );
        FileUtil.addRecord( getNewId() + " " + user.getType() + " " + user.getLogin()
                + " " + user.getPassword() + " " + user.getName(), FILE_NAME );
        users.add( user );

    }

    @Override
    public void delete(int id) throws DAOException, IncorrectFileException {
        if( id < 1 ) throw new DAOException( "incorrect id" );
        users.remove( users.stream().filter( x -> x.getId() == id ).findFirst().get() );
        FileUtil.updateFile( users.stream().map( this::buildString )
                .collect( Collectors.toList() ), FILE_NAME );
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUser(String login, String password) throws DAOException {
        if( login.equals( "" ) || password.equals( "" ) ) throw new DAOException( "Null credentials" );
        return users.stream().filter( x -> x.getLogin()
                .equals( login ) && x.getPassword()
                .equals( password ) ).findFirst().get();
    }

    private List<User> getAll() throws DAOException {
        try {
            return FileUtil.getAllRecords( FILE_NAME ).stream()
                    .map( this::buildUser )
                    .collect( Collectors
                            .toList() );
        }
        catch (DAOException | IOException e) {
            throw new DAOException( "Couldn't get all users" );
        }

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


    private int getNewId() {
        return users.get( users.size() - 1 ).getId()+1;
    }
}
