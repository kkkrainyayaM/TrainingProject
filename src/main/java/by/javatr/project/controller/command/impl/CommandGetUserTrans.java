package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.Session;
import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;
import by.javatr.project.exception.serviceexception.ServiceException;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewTransactions;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommandGetUserTrans implements Command {
    @Override
    public String execute(String request) {
        String response = null;
        User user = Session.getInstance().getUser();
        ArrayList<Transaction> list = null;
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
