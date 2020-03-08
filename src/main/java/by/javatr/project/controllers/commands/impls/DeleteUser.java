package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewDelete;
import by.javatr.project.views.ViewMenuAdmin;

public class DeleteUser implements Command {
    @Override
    public View execute(String request) throws ControllerException {
        GetUsers getUsers = new GetUsers();
        getUsers.execute( request );
        ViewDelete viewDelete = new ViewDelete();
        viewDelete.show();
        int id = viewDelete.getId();
        try {

            ServiceFactory.getInstance().getClientService().deleteUser( id );
            return new ViewMenuAdmin();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't delete user with id=" + id, e );
        }

    }
}
