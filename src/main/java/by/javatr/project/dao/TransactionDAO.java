package by.javatr.project.dao;


import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;

import java.util.List;

public interface TransactionDAO {
    /**
     * Add transaction record to file
     *
     * @param transaction - Transaction
     */
    void add(Transaction transaction) throws IncorrectFileException, DAOException;

    /**
     * Get all transactions for user
     *
     * @param user - User
     * @return list of transactions
     */
    List<Transaction> findByUser(User user) throws DAOException;

    /**
     * Delete transaction from file
     *
     * @param id - Transaction id
     */
    void delete(int id) throws DAOException, IncorrectFileException;

    /**
     * Get all transaction
     *
     * @return - list of all transactions
     */
    List<Transaction> getTransactions();

    int getLastId();
}
