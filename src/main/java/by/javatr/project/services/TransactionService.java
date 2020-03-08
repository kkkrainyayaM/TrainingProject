package by.javatr.project.services;

import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.serviceexception.ServiceException;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction) throws ServiceException;

    List<Transaction> getTransactions() throws ServiceException;

    List<Transaction> getTransByUser(User user) throws ServiceException;

    void deleteTransaction(int id) throws ServiceException;
}
