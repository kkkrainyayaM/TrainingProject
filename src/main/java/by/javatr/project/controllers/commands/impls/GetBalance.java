package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewBalance;
import by.javatr.project.views.ViewMenuUser;

public class GetBalance implements Command {
    private static ViewBalance viewBalance = new ViewBalance();

    @Override
    public View execute(String request) throws ControllerException {
        try {
            User user = Session.getInstance().getUser();
            float balance = ServiceFactory.getInstance().getTransactionService().getBalance( user );
            viewBalance.show( balance );
            return new ViewMenuUser();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get transactions", e );
        }
    }
}
