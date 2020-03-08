package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewMenuAdmin;

public class ShowAdminMenu implements Command {

    @Override
    public View execute(String request) {
        return new ViewMenuAdmin();
    }
}
