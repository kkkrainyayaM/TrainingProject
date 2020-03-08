package by.javatr.project.services.impl;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;
import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void addTransaction(Transaction transaction) throws ServiceException {
        try {
            DAOFactoryImpl.getInstance().getTransactionDAO().add( transaction );
        }
        catch (IncorrectFileException | DAOException e) {
            throw new ServiceException( "Couldn't add transaction with id=" + transaction.getId(), e  );
        }
    }

    @Override
    public List<Transaction> getTransactions() throws ServiceException {
        try {
            return DAOFactoryImpl.getInstance().getTransactionDAO().getTransactions();
        }
        catch (IncorrectFileException e) {
            throw new ServiceException( "Couldn't get transaction", e );
        }
    }

    @Override
    public List<Transaction> getTransByUser(User user) throws ServiceException {
        try {
            return DAOFactoryImpl.getInstance().getTransactionDAO().findByUser( user );
        }
        catch (DAOException | IncorrectFileException e) {
            throw new ServiceException( "Couldn't get transaction of user with id=" + user.getId(), e );
        }
    }

    @Override
    public void deleteTransaction(int id) throws ServiceException {
        try {
            DAOFactoryImpl.getInstance().getTransactionDAO().delete( id );
        }
        catch (DAOException | IncorrectFileException e) {
            throw new ServiceException( "Couldn't delete transaction with id=" + id, e );
        }
    }
}
