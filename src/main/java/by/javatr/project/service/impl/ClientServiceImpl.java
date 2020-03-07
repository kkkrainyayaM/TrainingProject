package by.javatr.project.service.impl;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;
import by.javatr.project.entity.User;
import by.javatr.project.service.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    @Override
    public boolean authenticate(String login, String password) {
        return DAOFactoryImpl.getInstance().getUserDAO().signIn( login, password );
    }

    @Override
    public User getUser(String login, String password) {
        return DAOFactoryImpl.getInstance().getUserDAO().getUser( login, password );
    }

    @Override
    public void register(User user) {
        DAOFactoryImpl.getInstance().getUserDAO().signUp( user );
    }

    @Override
    public ArrayList<User> getUsers() {
        return DAOFactoryImpl.getInstance().getUserDAO().getUsers();
    }

    @Override
    public void deleteUser(int id) {
        DAOFactoryImpl.getInstance().getUserDAO().delete( id);
    }


}
