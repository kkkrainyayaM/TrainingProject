package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.exception.controllerexception.ControllerException;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewDelete;

public class DeleteUser implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        int id;
        GetUsers getUsers = new GetUsers();
        getUsers.execute( request );
        ViewDelete viewDelete = new ViewDelete();
        viewDelete.show();
        id = viewDelete.getId();
        try {
            ServiceFactory.getInstance().getClientService().deleteUser( id );
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't delete user with id=" + id, e );
        }
        return "Пользователь удален!";
    }
}
