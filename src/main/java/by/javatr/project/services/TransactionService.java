package by.javatr.project.services;

import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.serviceexception.ServiceException;

import java.util.List;

public interface TransactionService {

    /**
     * Add transaction to list
     *
     * @param transaction - Transaction
     * @throws ServiceException
     */
    void addTransaction(Transaction transaction) throws ServiceException;

    /**
     * Get list of all transactions
     *
     * @return list of transactions
     * @throws ServiceException
     */
    List<Transaction> getTransactions() throws ServiceException;

    /**
     * @param user - User
     * @return list of transactions filtered by user id
     * @throws ServiceException
     */
    List<Transaction> getTransByUser(User user) throws ServiceException;

    /**
     * Delete transaction by id
     *
     * @param id - Transaction id
     * @throws ServiceException
     */
    void deleteTransaction(int id) throws ServiceException;

    /**
     * Get last transaction of user
     *
     * @param user - User
     * @return transaction
     * @throws ServiceException
     */
    Transaction getLastTransaction(User user) throws ServiceException;

    /**
     * Get actual balance of user's account
     *
     * @param user - User
     * @return balance
     * @throws ServiceException
     */
    float getBalance(User user) throws ServiceException;
}
