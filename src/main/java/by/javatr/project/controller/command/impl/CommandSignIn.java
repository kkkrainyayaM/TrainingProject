package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Session;
import by.javatr.project.entity.User;
import by.javatr.project.entity.UserType;
import by.javatr.project.service.ClientService;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewMenuAdmin;
import by.javatr.project.view.ViewMenuUser;
import by.javatr.project.view.ViewSignIn;

public class CommandSignIn implements Command {
    @Override
    public String execute(String request) {
        ViewSignIn view = new ViewSignIn();
        view.show();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        if( clientService.authenticate( view.getLogin(), view.getPassword() ) ) {
            response = "Вход выполнен";
            User user = clientService.getUser( view.getLogin(), view.getPassword() );
            Session.getInstance().setUser( user );
            if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
                ViewMenuAdmin viewMenuAdmin = new ViewMenuAdmin();
                viewMenuAdmin.show();
            }
            else {
                ViewMenuUser viewMenuUser = new ViewMenuUser();
                viewMenuUser.show();
            }
        }
        else response = "Ошибка ввода";
        return response;
    }
}
