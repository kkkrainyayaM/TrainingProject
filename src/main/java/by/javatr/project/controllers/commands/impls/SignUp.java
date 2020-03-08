package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.ClientService;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewMenuUser;
import by.javatr.project.views.ViewSignUp;

public class SignUp implements Command {

    private static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ClientService clientService = serviceFactory.getClientService();
    private static ViewSignUp viewSignUp = new ViewSignUp();

    @Override
    public View execute(String request) throws ControllerException {
        viewSignUp.show();
        try {
            clientService.register( viewSignUp.getUser() );
            Session.getInstance().setUser( viewSignUp.getUser() );
            return new ViewMenuUser();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't sign up user", e );
        }
    }
}
