package by.javatr.project.entities;

import java.util.ArrayList;

public final class Session {
    private User user;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private static Session instance;

    private Session() {
    }

    public static synchronized Session getInstance() {
        if( instance == null ) {
            instance = new Session();
        }
        return instance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addTransaction(Transaction transaction){
        transactions.add( transaction );
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
