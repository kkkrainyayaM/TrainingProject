package by.javatr.project.views;

import static by.javatr.project.validations.Validator.isNull;

public class ViewTransactions {
    public void show(String transactions) {
        if( isNull(transactions) ) {
            System.out.println( "Нет проведенных транзакций!" );
        }
        else {
            System.out.println( "Транзакции:" );
            System.out.println( transactions );
        }
    }

}
