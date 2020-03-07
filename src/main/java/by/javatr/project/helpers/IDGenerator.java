package by.javatr.project.helpers;

import by.javatr.project.dao.factory.impl.DAOFactoryImpl;
import by.javatr.project.exception.daoexception.IncorrectFileException;

public final class IDGenerator {

    private static int lastIDUser;
    private static int lastIDTransaction;
    private static IDGenerator instance;

    private IDGenerator() throws IncorrectFileException {
        lastIDTransaction = DAOFactoryImpl.getInstance().getTransactionDAO().getLastId();
        lastIDUser = DAOFactoryImpl.getInstance().getUserDAO().getLastId();
    }

    public static synchronized IDGenerator getInstance() throws IncorrectFileException {
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
