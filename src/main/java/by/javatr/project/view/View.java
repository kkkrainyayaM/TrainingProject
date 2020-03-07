package by.javatr.project.view;

import java.util.Scanner;

public abstract class View {

    private static Scanner scanner = new Scanner( System.in );

    protected abstract String getCommand(int selectedOperation);

    protected abstract String getMenuItems();

    public void show() {
        System.out.println(getMenuItems());

    }
}
