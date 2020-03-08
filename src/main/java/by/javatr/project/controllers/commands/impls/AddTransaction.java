package by.javatr.project.controllers.commands.impls;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.entities.Transaction;
import by.javatr.project.exceptions.controllerexception.ControllerException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.exceptions.serviceexception.ServiceException;
import by.javatr.project.services.TransactionService;
import by.javatr.project.services.factory.ServiceFactory;
import by.javatr.project.views.ViewAddTrans;

public class AddTransaction implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        TransactionService transactionService = ServiceFactory.getInstance().getTransactionService();
        ViewAddTrans viewAddTrans = new ViewAddTrans();
        viewAddTrans.show();
        Transaction transaction;
        try {
            transaction = new Transaction( viewAddTrans.getCategory(), viewAddTrans.getSum() );
            transactionService.addTransaction( transaction );
        }
        catch (ServiceException | IncorrectFileException e) {
            throw new ControllerException( "Couldn't add transaction", e );
        }
        return "Транзакция добавлена";
    }
}
