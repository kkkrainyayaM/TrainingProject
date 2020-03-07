package by.javatr.project.services.impl;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        boolean result;
        try {
            result = DAOFactoryImpl.getInstance().getUserDAO().signIn( login, password );
        }
        catch (DAOException | IncorrectFileException e) {
            throw new ServiceException( "Null credentials", e );
        }
        return result;
    }

    @Override
    public User getUser(String login, String password) throws ServiceException {
        try {
            return DAOFactoryImpl.getInstance().getUserDAO().getUser( login, password );
        }
        catch (DAOException | IncorrectFileException e) {
            throw new ServiceException( "Null credentials", e );
        }
    }

    @Override
    public void register(User user) throws ServiceException {
        try {
            DAOFactoryImpl.getInstance().getUserDAO().signUp( user );
        }
        catch (IncorrectFileException | DAOException e) {
            throw new ServiceException( "Null user", e );
        }
    }

    @Override
    public ArrayList<User> getUsers() throws ServiceException {
        try {
            return DAOFactoryImpl.getInstance().getUserDAO().getUsers();
        }
        catch (IncorrectFileException e) {
            throw new ServiceException( "Error in getting users", e );
        }
    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        try {
            DAOFactoryImpl.getInstance().getUserDAO().delete( id );
        }
        catch (DAOException | IncorrectFileException e) {
            throw new ServiceException( "Null id", e );
        }
    }


}
