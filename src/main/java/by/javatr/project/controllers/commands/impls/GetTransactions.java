package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Transaction;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewMenuAdmin;
import by.javatr.project.views.ViewTransactions;

import java.util.List;
import java.util.stream.Collectors;

public class GetTransactions implements Command {

    private static List<Transaction> list;
    private static ViewTransactions viewTransactions = new ViewTransactions();
    @Override
    public View execute(String request) throws ControllerException {
        try {
            list = ServiceFactory.getInstance().getTransactionService().getTransactions();
            String response = list.stream().map( Object::toString ).collect( Collectors.joining( "\n" ) );
            viewTransactions.show( response );
            return new ViewMenuAdmin();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get transactions", e );
        }
    }

    public boolean hasTransactions() {
        return !list.isEmpty();
    }
}
