package by.javatr.project.utils;

import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

    private File file;
    private FileWriter fileWriter;

    public FileUtil(String fileName) throws IncorrectFileException {
        try {
            file = new File( fileName );
            fileWriter = new FileWriter( file, true );
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }

    public void addRecord(String record) throws DAOException, IncorrectFileException {
        if( record.equals( "" ) ) throw new DAOException( "Null record" );
        try {
            FileWriter fileWriter = new FileWriter( file, true );
            fileWriter.write( record + "\n" );
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + file.toString() );
        }
    }


    public void updateFile(ArrayList<String> records) throws DAOException {
        if( records == null ) throw new DAOException( "Null records" );
        clearFile();
        Stream.of( records ).forEach( str -> {
            try {
                fileWriter.write( str + System.lineSeparator() );
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } );
    }

    private void clearFile() {
        try {
            Files.delete( Paths.get( file.getPath() ) );
            Files.createFile( Paths.get( file.getPath() ) );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getAllRecords() {
        ArrayList<String> list = new ArrayList<>();
        try {
            list = Files.lines( Paths.get( file.getPath() ),
                    StandardCharsets.UTF_8 ).collect( Collectors.toCollection( ArrayList::new ) );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

}
