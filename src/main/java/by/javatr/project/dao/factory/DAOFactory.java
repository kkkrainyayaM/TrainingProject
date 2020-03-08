package by.javatr.project.dao.factory;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.dao.UserDAO;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;

public interface DAOFactory {

    TransactionDAO getTransactionDAO() throws IncorrectFileException, DAOException;

    UserDAO getUserDAO() throws IncorrectFileException, DAOException;

}
