package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewMenuUser;
import by.javatr.project.views.ViewTransactions;

import java.util.List;
import java.util.stream.Collectors;

public class GetUserTrans implements Command {
    @Override
    public View execute(String request) throws ControllerException {
        String response = null;
        User user = Session.getInstance().getUser();
        try {
            List<Transaction> list = ServiceFactory.getInstance().getTransactionService().getTransByUser( user );
            if( list != null ) {
                response = list.stream().map( Object::toString ).collect( Collectors.joining( "\n" ) );
            }
            ViewTransactions viewTransactions = new ViewTransactions();
            viewTransactions.show( response );
            return new ViewMenuUser();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get transactions of user", e );
        }
    }
}
