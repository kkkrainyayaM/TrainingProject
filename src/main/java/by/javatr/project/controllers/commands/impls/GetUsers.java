package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.User;
import by.javatr.project.entities.UserType;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.ViewUsers;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GetUsers implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        ViewUsers view = new ViewUsers();
        String response;
        ArrayList<User> list = null;
        try {
            list = ServiceFactory.getInstance().getClientService().getUsers();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get users", e );
        }
        response = list.stream().filter( x->x.getType()== UserType.CLIENT ).map( Object::toString ).collect( Collectors.joining( "\n" ) );
        view.show( response );
        return response;
    }
}
