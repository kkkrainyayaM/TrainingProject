package by.javatr.project.dao.factory.impl;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.dao.UserDAO;
import by.javatr.project.dao.factory.DAOFactory;
import by.javatr.project.dao.impl.FileTransactionDAO;
import by.javatr.project.dao.impl.FileUserDAO;
import by.javatr.project.exceptions.daoexception.DAOException;

public final class DAOFactoryImpl implements DAOFactory {

    private static DAOFactoryImpl instance;

    public static synchronized DAOFactoryImpl getInstance() {
        if( instance == null ) {
            instance = new DAOFactoryImpl();
        }
        return instance;

    }

    private DAOFactoryImpl() {
    }

    @Override
    public TransactionDAO getTransactionDAO() throws  DAOException {
        return new FileTransactionDAO();
    }

    @Override
    public UserDAO getUserDAO() throws DAOException {
        return new FileUserDAO();
    }
}
