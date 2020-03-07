package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Transaction;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewTransactions;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommandGetTransactions implements Command {
    @Override
    public String execute(String request) {
        ArrayList<Transaction> list = ServiceFactory.getInstance().getTransactionService().getTransactions();
        String response = list.stream().map( Object::toString ).collect( Collectors.joining("\n"));
        ViewTransactions viewTransactions = new ViewTransactions();
        viewTransactions.show(response);
        return response;
    }
}
