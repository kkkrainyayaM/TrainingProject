package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Transaction;
import by.javatr.project.exception.controllerexception.ControllerException;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewTransactions;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommandGetTransactions implements Command {
    @Override
    public String execute(String request) throws ControllerException {
        ArrayList<Transaction> list = null;
        try {
            list = ServiceFactory.getInstance().getTransactionService().getTransactions();
        }
        catch (ServiceException e) {
            throw new ControllerException( "Couldn't get transactions", e );
        }
        String response = list.stream().map( Object::toString ).collect( Collectors.joining("\n"));
        ViewTransactions viewTransactions = new ViewTransactions();
        viewTransactions.show(response);
        return response;
    }
}
