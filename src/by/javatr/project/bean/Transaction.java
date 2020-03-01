package by.javatr.project.bean;

import by.javatr.project.idgenerator.IDGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction {
    private TransCategory category;
    private String date;
    private int id;
    private int idUser;

    public Transaction(TransCategory category) {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy.MM.dd" );
        this.category = category;
        this.date = dateFormat.format( new Date() );
        this.id = IDGenerator.getInstance().getIDTransaction();
        this.idUser = Session.getInstance().getUser().getId();
    }

    public TransCategory getCategory() {
        return category;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if( this == o ) return true;
        if( o.getClass() != Transaction.class ) return false;
        Transaction that = (Transaction) o;
        return getId() == that.getId() &&
                getIdUser() == that.getIdUser() &&
                getCategory() == that.getCategory() &&
                getDate().equals( that.getDate() );
    }

    @Override
    public int hashCode() {
        return Objects.hash( getCategory(), getDate(), getId(), getIdUser() );
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "category=" + category +
                ", date=" + date +
                ", id=" + id +
                ", idUser=" + idUser +
                '}';
    }
}
