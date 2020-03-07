package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Session;
import by.javatr.project.exception.controllerexception.ControllerException;
import by.javatr.project.exception.daoexception.IncorrectFileException;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.exception.viewexception.ViewException;
import by.javatr.project.service.ClientService;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewMenuUser;
import by.javatr.project.view.ViewSignUp;

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
