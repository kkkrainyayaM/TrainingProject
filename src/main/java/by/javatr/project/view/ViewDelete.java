package by.javatr.project.view;

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
}
