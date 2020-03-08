package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Session;
import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.ViewTransactions;

import java.util.List;
import java.util.stream.Collectors;

public class GetUserTrans implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        User user = Session.getInstance().getUser();
        List<Transaction> list = null;
        try {
            list = ServiceFactory.getInstance().getTransactionService().getTransByUser( user );
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }

        if( list != null ) {
            response = list.stream().map( Object::toString ).collect( Collectors.joining( "\n" ) );
        }
        ViewTransactions viewTransactions = new ViewTransactions();
        viewTransactions.show( response );
        return response;
    }
}
