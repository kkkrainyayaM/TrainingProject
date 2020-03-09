package by.javatr.project.dao.factory;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.dao.UserDAO;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;

public interface DAOFactory {

    /**
     * Get link type of interface TransactionDAO to impl
     *
     * @return TransactionDAO
     * @throws IncorrectFileException
     * @throws DAOException
     */
    TransactionDAO getTransactionDAO() throws IncorrectFileException, DAOException;

    /**
     * Get link type of interface UserDAO to impl
     *
     * @return UserDAo
     * @throws IncorrectFileException
     * @throws DAOException
     */
    UserDAO getUserDAO() throws IncorrectFileException, DAOException;

}
