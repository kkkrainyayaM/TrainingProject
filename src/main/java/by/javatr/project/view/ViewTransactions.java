package by.javatr.project.view;

public class ViewTransactions {
    public void show(String transactions) {
        if( transactions == null ) {
            System.out.println( "Нет проведенных транзакций!" );
        }
        else {
            System.out.println( "Проведенные транзакции:" );
            System.out.println( transactions );
        }
    }

}
