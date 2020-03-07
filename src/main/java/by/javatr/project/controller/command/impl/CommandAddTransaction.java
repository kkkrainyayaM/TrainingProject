package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Transaction;
import by.javatr.project.service.TransactionService;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewAddTrans;

public class CommandAddTransaction implements Command {
    @Override
    public String execute(String request) {
        TransactionService transactionService = ServiceFactory.getInstance().getTransactionService();
        ViewAddTrans viewAddTrans = new ViewAddTrans();
        viewAddTrans.show();
        Transaction transaction = new Transaction( viewAddTrans.getCategory(), viewAddTrans.getSum() );
        transactionService.addTransaction( transaction );
        return "Транзакция добавлена";
    }
}
