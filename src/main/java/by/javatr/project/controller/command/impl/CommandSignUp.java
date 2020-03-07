package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Session;
import by.javatr.project.service.ClientService;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewMenuUser;
import by.javatr.project.view.ViewSignUp;

public class CommandSignUp implements Command {
    @Override
    public String execute(String request) {
        String response;
        ViewSignUp view = new ViewSignUp();
        view.show();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        clientService.register( view.getUser() );
        Session.getInstance().setUser( view.getUser() );
        response = "Регистрация выполнена";
        ViewMenuUser viewMenuUser = new ViewMenuUser();
        viewMenuUser.show();
        return response;
    }
}
