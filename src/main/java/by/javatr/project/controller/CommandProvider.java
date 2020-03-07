package by.javatr.project.controller;

import by.javatr.project.controller.command.Command;
import by.javatr.project.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put( CommandName.SIGN_IN, new CommandSignIn() );
        repository.put( CommandName.SIGN_UP, new CommandSignUp() );
        repository.put( CommandName.ADD_TRANSACTION, new CommandAddTransaction() );
        repository.put( CommandName.DELETE_TRANSACTION, new CommandDeleteTransaction() );
        repository.put( CommandName.DELETE_USER, new CommandDeleteUser() );
        repository.put( CommandName.GET_TRANSACTIONS, new CommandGetTransactions());
        repository.put( CommandName.GET_USERS, new CommandGetUsers() );
        repository.put( CommandName.TRANSACTIONS_BY_USER, new CommandGetUserTrans() );
    }

    Command getCommand(String name) {
        return repository.get( CommandName.valueOf( name.toUpperCase() ) );
    }

}
