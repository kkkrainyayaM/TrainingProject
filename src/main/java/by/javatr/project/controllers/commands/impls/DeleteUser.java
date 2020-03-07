package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.ViewDelete;

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
