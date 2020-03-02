package by.javatr.project.dao.factory;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.dao.UserDAO;

public interface DAOFactory {

    TransactionDAO getTransactionDAO();

    UserDAO getUserDAO();

}
