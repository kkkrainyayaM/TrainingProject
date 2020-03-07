package by.javatr.project.entities;

import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.helpers.IDGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction {
    private int id;
    private TransCategory category;
    private String date;
    private int userId;
    private float sum;

    public Transaction(TransCategory category, float sum) throws IncorrectFileException {
        this.category = category;
        this.date = new SimpleDateFormat( "yyyy.MM.dd" ).format( new Date() );
        this.id = IDGenerator.getInstance().getIDTransaction();
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
        return Objects.hash( getCategory(), getDate(), getId(), getUserId(), getSum() );
    }

    @Override
    public String toString() {
        return "Транзакция{" +
                ", ID=" + id +
                "категория=" + category +
                ", дата=" + date +
                ", ID пользователя=" + userId +
                ", сумма=" + sum + "б.р." +
                '}';
    }
}
