package by.javatr.project.dao.factory;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.dao.UserDAO;
import by.javatr.project.exception.daoexception.IncorrectFileException;

public interface DAOFactory {

    TransactionDAO getTransactionDAO() throws IncorrectFileException;

    UserDAO getUserDAO() throws IncorrectFileException;

}
