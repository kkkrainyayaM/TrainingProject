package by.javatr.project.dao.impl;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.entities.TransCategory;
import by.javatr.project.entities.Transaction;
import by.javatr.project.entities.User;
import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;
import by.javatr.project.utils.FileUtil;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static by.javatr.project.validations.Validator.isId;
import static by.javatr.project.validations.Validator.isNull;
import static com.sun.xml.internal.stream.writers.WriterUtility.SPACE;


public class FileTransactionDAO implements TransactionDAO {

    private static final int ID_INDEX = 0;
    private static final int CATEGORY_INDEX = 1;
    private static final int DATE_INDEX = 2;
    private static final int USER_ID_INDEX = 3;
    private static final int SUM_INDEX = 4;
    private static final String FILE_NAME = "C:/Users/rizhi/Documents/Training" +
            "/FinancialAccountingApp/src/main/resources/transactions.txt";
    private static List<Transaction> transactions;

    public FileTransactionDAO() throws DAOException {
        transactions = getAll();
    }

    @Override
    public void add(Transaction transaction) throws IncorrectFileException, DAOException {
        if( isNull( transaction ) ) throw new DAOException( "Null transaction" );
        FileUtil.addRecord( getNewId() + " " + transaction.getCategory()
                + " " + transaction.getDate() + " " + transaction.getUserId()
                + " " + transaction.getSum(), FILE_NAME );
        transactions.add( transaction );
    }

    @Override
    public List<Transaction> findByUser(User user) throws DAOException {
        if( isNull( user ) ) throw new DAOException( "Null user" );
        return transactions.stream().filter( x -> user.getId() == x.getUserId() )
                .collect( Collectors.toList() );

    }

    @Override
    public void delete(int id) throws DAOException, IncorrectFileException {
        if( !isId( id ) ) throw new DAOException( "Incorrect id" );
        transactions.remove( transactions.stream().filter( x -> x.getId() == id ).findFirst().get() );
        FileUtil.updateFile( transactions.stream().map( this::buildString )
                .collect( Collectors.toList() ), FILE_NAME );
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }

    private List<Transaction> getAll() throws DAOException {
        try {
            return FileUtil.getAllRecords( FILE_NAME ).stream()
                    .map( this::buildTransaction )
                    .collect( Collectors
                            .toList() );
        }
        catch (DAOException | IOException e) {
            throw new DAOException( "Couldn't get all transactions" );
        }
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
        StringBuilder stringBuilder = new StringBuilder()
                .append( transaction.getId() ).append( SPACE )
                .append( transaction.getCategory() ).append( SPACE )
                .append( transaction.getDate() ).append( SPACE )
                .append( transaction.getUserId() ).append( SPACE )
                .append( transaction.getSum() );
        return stringBuilder.toString();
    }

    private int getNewId() {
        if( transactions.size() == 0 ) return 1;
        else return transactions.get( transactions.size() - 1 ).getId() + 1;
    }
}
