package by.javatr.project.dao;


import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;
import by.javatr.project.exception.DAOExeption;

import java.util.ArrayList;

public interface TransactionDAO {
    /**
     * Add transaction record to file
     *
     * @param transaction - Transaction
     */
    void add(Transaction transaction) throws DAOExeption;

    /**
     * Get all transactions for user
     *
     * @param user - User
     * @return list of transactions
     */
    ArrayList<Transaction> findByUser(User user) throws DAOExeption;

    /**
     * Delete transaction from file
     *
     * @param id - Transaction id
     */
    void delete(int id) throws DAOExeption;

    /**
     * Get all transaction
     *
     * @return - list of all transactions
     */
    ArrayList<Transaction> getTransactions();

    int getLastId();
}
