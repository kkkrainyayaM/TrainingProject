package by.javatr.project.views;

import by.javatr.project.exceptions.viewexception.ViewException;

public abstract class View {

    protected abstract String getCommand(int selectedOperation);

    protected abstract String getMenuItems();

    public void show() throws ViewException {
        System.out.println( getMenuItems() );
    }
}
