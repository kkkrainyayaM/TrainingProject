package by.javatr.project.service.factory;

import by.javatr.project.service.ClientService;
import by.javatr.project.service.TransactionService;
import by.javatr.project.service.impl.ClientServiceImpl;
import by.javatr.project.service.impl.TransactionServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final ClientService clientService = new ClientServiceImpl();
    private final TransactionService transactionService = new TransactionServiceImpl();

    private ServiceFactory(){}

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
