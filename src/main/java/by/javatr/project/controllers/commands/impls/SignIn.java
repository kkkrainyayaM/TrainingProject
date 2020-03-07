package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.User;
import by.javatr.project.entities.UserType;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.exceptions.viewexception.ViewException;
import by.javatr.project.services.ClientService;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.ViewMenuAdmin;
import by.javatr.project.views.ViewMenuUser;
import by.javatr.project.views.ViewSignIn;

public class SignIn implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        ViewSignIn view = new ViewSignIn();
        view.show();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService clientService = serviceFactory.getClientService();
        try {
            if( clientService.authenticate( view.getLogin(), view.getPassword() ) ) {
                response = "Вход выполнен";
                User user = null;
                user = clientService.getUser( view.getLogin(), view.getPassword() );
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
        }
        catch (DAOException | ServiceException | ViewException e) {
            throw new ControllerException( "Couldn't sign in user", e );
        }
        return response;
    }
}
