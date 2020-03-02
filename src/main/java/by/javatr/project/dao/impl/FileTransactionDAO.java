package by.javatr.project.dao.impl;

import by.javatr.project.dao.TransactionDAO;
import by.javatr.project.entity.TransCategory;
import by.javatr.project.entity.Transaction;
import by.javatr.project.entity.User;
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

    public FileTransactionDAO() {
        transactions = getAll();
    }

    @Override
    public void add(Transaction transaction) {
        fileUtil.addRecord( transaction.getId() + " " + transaction.getCategory()
                + " " + transaction.getDate() + " " + transaction.getUserId()
                + " " + transaction.getSum() );
        transactions.add( transaction );
    }

    @Override
    public ArrayList<Transaction> findByUser(User user) {
        return transactions.stream().filter( x -> user.getId() == x.getUserId() )
                .collect( Collectors.toCollection( ArrayList::new ) );

    }

    @Override
    public void delete(Transaction transaction) {
        transactions.remove( transactions.stream().findFirst().filter( x -> transaction.getId() == x.getId() ).get() );
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
        String[] userFields = transRecord.split( SPACE );
        return new Transaction( Integer.valueOf( userFields[ID_INDEX] ),
                TransCategory.valueOf( userFields[CATEGORY_INDEX] ),
                userFields[DATE_INDEX],
                Integer.valueOf( userFields[USER_ID_INDEX] ),
                Float.valueOf( userFields[SUM_INDEX] ) );
    }

    private String buildString(Transaction transaction) {
        return transaction.getId() + " " + transaction.getCategory()
                + " " + transaction.getDate() + " " + transaction.getUserId()
                + " " + transaction.getSum();
    }
}
