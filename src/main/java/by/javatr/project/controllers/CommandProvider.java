package by.javatr.project.controllers;

import by.javatr.project.controllers.commands.Command;
import by.javatr.project.controllers.commands.impls.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<Commands, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put( Commands.SIGN_IN, new SignIn() );
        repository.put( Commands.SIGN_UP, new SignUp() );
        repository.put( Commands.ADD_TRANSACTION, new AddTransaction() );
        repository.put( Commands.DELETE_TRANSACTION, new DeleteTransaction() );
        repository.put( Commands.DELETE_USER, new DeleteUser() );
        repository.put( Commands.GET_TRANSACTIONS, new GetTransactions());
        repository.put( Commands.GET_USERS, new GetUsers() );
        repository.put( Commands.TRANSACTIONS_BY_USER, new GetUserTrans() );
    }

    Command getCommand(String name) {
        return repository.get( Commands.valueOf( name.toUpperCase() ) );
    }

}
