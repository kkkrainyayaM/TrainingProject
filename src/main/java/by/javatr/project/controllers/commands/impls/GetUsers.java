package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.User;
import by.javatr.project.entities.UserType;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewMenuAdmin;
import by.javatr.project.views.ViewUsers;

import java.util.List;
import java.util.stream.Collectors;

public class GetUsers implements Command {
    @Override
    public View execute(String request) throws ControllerException {
        ViewUsers view = new ViewUsers();
        try {
            List<User> list = ServiceFactory.getInstance().getClientService().getUsers();
            String response = list.stream().filter( x -> x.getType() == UserType.CLIENT )
                    .map( Object::toString ).collect( Collectors.joining( "\n" ) );
            view.show( response );
            return new ViewMenuAdmin();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get users", e );
        }
    }
}
