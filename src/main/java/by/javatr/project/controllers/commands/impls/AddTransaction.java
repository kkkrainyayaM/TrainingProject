package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Transaction;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.TransactionService;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.View;
import by.javatr.project.views.ViewAddTrans;
import by.javatr.project.views.ViewMenuUser;

public class AddTransaction implements Command {

    private static ViewAddTrans viewAddTrans = new ViewAddTrans();

    @Override
    public View execute(String request) throws ControllerException {
        TransactionService transactionService = ServiceFactory.getInstance().getTransactionService();
        viewAddTrans.show();
        try {
            Transaction transaction = new Transaction( viewAddTrans.getCategory(), viewAddTrans.getSum() );
            transactionService.addTransaction( transaction );
            return new ViewMenuUser();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't add transaction", e );
        }

    }
}
