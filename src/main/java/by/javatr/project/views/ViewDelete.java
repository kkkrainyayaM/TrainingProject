package by.javatr.project.views;

import java.util.Scanner;

public class ViewDelete {
    private int id;

    public void show() {
        System.out.println( "ID элемента для удаления:" );
        Scanner scanner = new Scanner( System.in );
        id = scanner.nextInt();
    }

    public int getId() {
        return id;
    }

    public void showResult() {
        System.out.println( "Элемент удален!" );
    }

    public void showEmptyTrans(){
        System.out.println( "Список транзакций пуст!" );
    }
}
