package by.javatr.project.service;

import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;

import java.util.ArrayList;

public interface TransactionService {
    void addTransaction(Transaction transaction);

    ArrayList<Transaction> getTransactions();

    ArrayList<Transaction> getTransByUser(User user);

    void deleteTransaction(int id);
}
