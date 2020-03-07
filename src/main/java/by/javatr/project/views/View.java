package by.javatr.project.views;

import by.javatr.project.exceptions.viewexception.ViewException;

import java.util.Scanner;

public abstract class View {

    private static Scanner scanner = new Scanner( System.in );

    protected abstract String getCommand(int selectedOperation);

    protected abstract String getMenuItems();

    public void show() throws ViewException {
        System.out.println(getMenuItems());

    }
}
