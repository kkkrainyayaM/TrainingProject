package by.javatr.project.services;

import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.serviceexception.ServiceException;

import java.util.ArrayList;

public interface TransactionService {
    void addTransaction(Transaction transaction) throws ServiceException;

    ArrayList<Transaction> getTransactions() throws ServiceException;

    ArrayList<Transaction> getTransByUser(User user) throws ServiceException;

    void deleteTransaction(int id) throws ServiceException;
}
