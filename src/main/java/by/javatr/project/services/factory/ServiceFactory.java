package by.javatr.project.services.factory;

import by.javatr.project.services.ClientService;
import by.javatr.project.services.TransactionService;
import by.javatr.project.services.impl.ClientServiceImpl;
import by.javatr.project.services.impl.TransactionServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();
    private final TransactionService transactionService = new TransactionServiceImpl();

    public ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public ClientService getClientService(){
        return clientService;
    }

    public TransactionService getTransactionService(){
        return transactionService;
    }

}
