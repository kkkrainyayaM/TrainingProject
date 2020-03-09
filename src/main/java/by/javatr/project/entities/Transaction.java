package by.javatr.project.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy.MM.dd" );
    private int id;
    private TransCategory category;
    private String date;
    private int userId;
    private float sum;

    public Transaction(TransCategory category, float sum) {
        this.category = category;
        this.date = dateFormat.format( new Date() );
        this.userId = Session.getInstance().getUser().getId();
        this.sum = sum;
    }

    public Transaction(int id, TransCategory category, String date, int userId, float sum) {
        this.id = id;
        this.category = category;
        this.date = date;
        this.userId = userId;
        this.sum = sum;
    }

    public TransCategory getCategory() {
        return category;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public void setCategory(TransCategory category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if( o.getClass() != Transaction.class ) return false;
        Transaction that = (Transaction) o;
        return getId() == that.getId() &&
                getUserId() == that.getUserId() &&
                getCategory() == that.getCategory() &&
                getSum() == that.getSum() &&
                getDate().equals( that.getDate() );
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + category.hashCode();
        result = prime * result + date.hashCode();
        result = prime * result + id;
        result = prime * result + userId;
        result = prime * result + (int) getSum();
        return result;
    }

    @Override
    public String toString() {
        return "Транзакция{" +
                ", ID=" + id +
                ", категория=" + category +
                ", дата=" + date +
                ", ID пользователя=" + userId +
                ", сумма=" + sum + "б.р." +
                '}';
    }
}
