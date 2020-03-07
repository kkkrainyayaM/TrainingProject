package by.javatr.project.controllers;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.controllers.commands.impls.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put( CommandName.SIGN_IN, new SignIn() );
        repository.put( CommandName.SIGN_UP, new SignUp() );
        repository.put( CommandName.ADD_TRANSACTION, new AddTransaction() );
        repository.put( CommandName.DELETE_TRANSACTION, new DeleteTransaction() );
        repository.put( CommandName.DELETE_USER, new DeleteUser() );
        repository.put( CommandName.GET_TRANSACTIONS, new GetTransactions());
        repository.put( CommandName.GET_USERS, new GetUsers() );
        repository.put( CommandName.TRANSACTIONS_BY_USER, new GetUserTrans() );
    }

    Command getCommand(String name) {
        return repository.get( CommandName.valueOf( name.toUpperCase() ) );
    }

}
