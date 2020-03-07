package by.javatr.project.helpers;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;

public final class IDGenerator {

    private static int lastIDUser;
    private static int lastIDTransaction;
    private static IDGenerator instance;

    private IDGenerator() {
        lastIDTransaction = DAOFactoryImpl.getInstance().getTransactionDAO().getLastId();
        lastIDUser = DAOFactoryImpl.getInstance().getUserDAO().getLastId();
    }

    public static synchronized IDGenerator getInstance() {
        if( instance == null ) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public int getIDUser() {
        return ++lastIDUser;
    }

    public int getIDTransaction() {
        return ++lastIDTransaction;
    }


}
