package by.javatr.project.dao.impl;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.entity.TransCategory;
import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;
import by.javatr.project.exception.daoexception.DAOException;
import by.javatr.project.exception.daoexception.IncorrectFileException;
import by.javatr.project.utils.FileUtil;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.sun.xml.internal.stream.writers.WriterUtility.SPACE;


public class FileTransactionDAO implements TransactionDAO {

    private static final int ID_INDEX = 0;
    private static final int CATEGORY_INDEX = 1;
    private static final int DATE_INDEX = 2;
    private static final int USER_ID_INDEX = 3;
    private static final int SUM_INDEX = 4;
    private static final String FILE_NAME = "C:/Users/rizhi/Documents/Training/FinancialAccountingApp/src/main/resources/transaction.txt";
    private FileUtil fileUtil = new FileUtil( FILE_NAME );
    private ArrayList<Transaction> transactions;

    public FileTransactionDAO() throws IncorrectFileException {
        transactions = getAll();
    }

    @Override
    public void add(Transaction transaction) throws IncorrectFileException, DAOException {
        if( transaction == null ) throw new DAOException( "Null transaction" );
        fileUtil.addRecord( transaction.getId() + " " + transaction.getCategory()
                + " " + transaction.getDate() + " " + transaction.getUserId()
                + " " + transaction.getSum() );
        transactions.add( transaction );
    }

    @Override
    public ArrayList<Transaction> findByUser(User user) throws DAOException {
        if( user == null ) throw new DAOException( "Null user" );
        return transactions.stream().filter( x -> user.getId() == x.getUserId() )
                .collect( Collectors.toCollection( ArrayList::new ) );

    }

    @Override
    public void delete(int id) throws DAOException {
        if( id < 1 ) throw new DAOException( "Incorrect id" );
        transactions.remove( transactions.stream().findFirst().filter( x -> x.getId() == id ).get() );
        fileUtil.updateFile( transactions.stream().map( this::buildString )
                .collect( Collectors.toCollection( ArrayList::new ) ) );

    }

    @Override
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    private ArrayList<Transaction> getAll() {
        return fileUtil.getAllRecords().stream()
                .map( this::buildTransaction )
                .collect( Collectors
                        .toCollection( ArrayList::new ) );
    }


    private Transaction buildTransaction(String transRecord) {
        String[] transFields = transRecord.split( SPACE );
        return new Transaction( Integer.valueOf( transFields[ID_INDEX] ),
                TransCategory.valueOf( transFields[CATEGORY_INDEX] ),
                transFields[DATE_INDEX],
                Integer.valueOf( transFields[USER_ID_INDEX] ),
                Float.valueOf( transFields[SUM_INDEX] ) );
    }

    private String buildString(Transaction transaction) {
        return transaction.getId() + " " + transaction.getCategory()
                + " " + transaction.getDate() + " " + transaction.getUserId()
                + " " + transaction.getSum();
    }

    public int getLastId() {
        if( transactions.size() == 0 ) return 0;
        else return transactions.get( transactions.size() - 1 ).getId();
    }
}
