package by.javatr.project.views;

import by.javatr.project.exceptions.viewexception.ViewException;

public class Main {

    public static View ACTIVE_VIEW = new ViewEntry();

    public static void main(String[] args) {
        try {
            while (ACTIVE_VIEW != null) {
                ACTIVE_VIEW.show();
            }
        }
        catch (ViewException e) {
            e.printStackTrace();
        }

    }
}
