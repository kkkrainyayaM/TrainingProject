package by.javatr.project.service;

import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;
import by.javatr.project.exception.serviceexception.ServiceException;

import java.util.ArrayList;

public interface TransactionService {
    void addTransaction(Transaction transaction) throws ServiceException;

    ArrayList<Transaction> getTransactions();

    ArrayList<Transaction> getTransByUser(User user) throws ServiceException;

    void deleteTransaction(int id) throws ServiceException;
}
