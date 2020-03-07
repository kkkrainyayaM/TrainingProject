package by.javatr.project.view;

import by.javatr.project.exception.viewexception.ViewException;

public class Main {
    public static void main(String[] args) {
        ViewEntry viewEntry = new ViewEntry();
        try {
            viewEntry.show();
        }
        catch (ViewException e) {
            e.printStackTrace();
        }

    }
}
