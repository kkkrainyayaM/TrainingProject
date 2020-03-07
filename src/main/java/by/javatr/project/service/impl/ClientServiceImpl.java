package by.javatr.project.service.impl;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;
import by.javatr.project.entity.User;
import by.javatr.project.exception.daoexception.DAOException;
import by.javatr.project.exception.daoexception.IncorrectFileException;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.service.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    @Override
    public boolean authenticate(String login, String password) throws ServiceException {
        boolean result;
        try {
            result = DAOFactoryImpl.getInstance().getUserDAO().signIn( login, password );
        }
        catch (DAOException e) {
            throw new ServiceException( "Null credentials", e );
        }
        return result;
    }

    @Override
    public User getUser(String login, String password) throws ServiceException {
        try {
            return DAOFactoryImpl.getInstance().getUserDAO().getUser( login, password );
        }
        catch (DAOException e) {
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
    public ArrayList<User> getUsers() {
        return DAOFactoryImpl.getInstance().getUserDAO().getUsers();
    }

    @Override
    public void deleteUser(int id) throws ServiceException {
        try {
            DAOFactoryImpl.getInstance().getUserDAO().delete( id );
        }
        catch (DAOException e) {
            throw new ServiceException( "Null id", e );
        }
    }


}
