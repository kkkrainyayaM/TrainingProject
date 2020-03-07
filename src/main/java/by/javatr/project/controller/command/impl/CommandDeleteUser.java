package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewDelete;

public class CommandDeleteUser implements Command {
    @Override
    public String execute(String request) {
        int id;
        CommandGetUsers commandGetUsers = new CommandGetUsers();
        commandGetUsers.execute( request );
        ViewDelete viewDelete = new ViewDelete();
        viewDelete.show();
        id = viewDelete.getId();
        ServiceFactory.getInstance().getClientService().deleteUser( id );
        return "Пользователь удален!";
    }
}
