package by.javatr.project.dao;


import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;

import java.util.ArrayList;

public interface TransactionDAO {
    /**
     * Add transaction record to file
     *
     * @param transaction - Transaction
     */
    void add(Transaction transaction);

    /**
     * Get all transactions for user
     *
     * @param user - User
     * @return list of transactions
     */
    ArrayList<Transaction> findByUser(User user);

    /**
     * Delete transaction from file
     *
     * @param id - Transaction id
     */
    void delete(int id);

    /**
     * Get all transaction
     *
     * @return - list of all transactions
     */
    ArrayList<Transaction> getTransactions();

    int getLastId();
}
