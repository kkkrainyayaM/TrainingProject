package by.javatr.project.controller.command.impl;

import by.javatr.project.controller.command.Command;
import by.javatr.project.entity.User;
import by.javatr.project.entity.UserType;
import by.javatr.project.service.factory.ServiceFactory;
import by.javatr.project.view.ViewUsers;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommandGetUsers implements Command {
    @Override
    public String execute(String request) {
        ViewUsers view = new ViewUsers();
        String response;
        ArrayList<User> list = ServiceFactory.getInstance().getClientService().getUsers();
        response = list.stream().filter( x->x.getType()== UserType.CLIENT ).map( Object::toString ).collect( Collectors.joining( "\n" ) );
        view.show( response );
        return response;
    }
}
