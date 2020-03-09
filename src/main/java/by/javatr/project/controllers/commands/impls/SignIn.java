package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.User;
import by.javatr.project.entities.UserType;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.ClientService;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.*;

public class SignIn implements Command {
    private static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private static ClientService clientService = serviceFactory.getClientService();
    private static ViewSignIn viewSignIn = new ViewSignIn();

    @Override
    public View execute(String request) throws ControllerException {
        View view;
        viewSignIn.show();
        String login = viewSignIn.getLogin();
        String password = viewSignIn.getPassword();

        try {
            if( clientService.authenticate( login, password ) ) {
                User user = clientService.getUser( login, password );
                Session.getInstance().setUser( user );
                if( Session.getInstance().getUser().getType() == UserType.ADMIN ) {
                    view = new ViewMenuAdmin();
                }
                else {
                    view = new ViewMenuUser();
                }
            }
            else {
                viewSignIn.showError();
                view = new ViewEntry();
            }
            return view;
        }
        catch (DAOException | ServiceException e) {
            throw new ControllerException( "Couldn't sign in user", e );
        }
    }
}
