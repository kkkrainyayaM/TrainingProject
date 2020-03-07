package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Transaction;
import by.javatr.project.exception.controllerexception.ControllerException;
import by.javatr.project.exception.daoexception.IncorrectFileException;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.service.TransactionService;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewAddTrans;

public class AddTransaction implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        TransactionService transactionService = ServiceFactory.getInstance().getTransactionService();
        ViewAddTrans viewAddTrans = new ViewAddTrans();
        viewAddTrans.show();
        Transaction transaction = null;
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
