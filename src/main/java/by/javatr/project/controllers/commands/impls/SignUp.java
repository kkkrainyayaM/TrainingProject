package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.exceptions.viewexception.ViewException;
import by.javatr.project.services.ClientService;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.ViewMenuUser;
import by.javatr.project.views.ViewSignUp;

public class SignUp implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        String response;
        try {
            ViewSignUp view = new ViewSignUp();
            view.show();
            ServiceFactory serviceFactory = ServiceFactory.getInstance();
            ClientService clientService = serviceFactory.getClientService();
            clientService.register( view.getUser() );
            Session.getInstance().setUser( view.getUser() );
            response = "Регистрация выполнена";
            ViewMenuUser viewMenuUser = new ViewMenuUser();
            viewMenuUser.show();
        }
        catch (ServiceException | ViewException | IncorrectFileException e) {
            throw new ControllerException( "Couldn't sign up user", e );
        }
        return response;
    }
}
