package by.javatr.project.views;

import by.javatr.project.exceptions.viewexception.ViewException;

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
