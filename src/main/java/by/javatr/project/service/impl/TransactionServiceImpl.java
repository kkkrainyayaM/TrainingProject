package by.javatr.project.service.impl;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;
import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;
import by.javatr.project.service.TransactionService;

import java.util.ArrayList;

public class TransactionServiceImpl implements TransactionService {
    @Override
    public void addTransaction(Transaction transaction) {
        DAOFactoryImpl.getInstance().getTransactionDAO().add( transaction );
    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return DAOFactoryImpl.getInstance().getTransactionDAO().getTransactions();
    }

    @Override
    public ArrayList<Transaction> getTransByUser(User user) {
        return DAOFactoryImpl.getInstance().getTransactionDAO().findByUser( user );
    }

    @Override
    public void deleteTransaction(int id) {
        DAOFactoryImpl.getInstance().getTransactionDAO().delete( id );
    }
}
