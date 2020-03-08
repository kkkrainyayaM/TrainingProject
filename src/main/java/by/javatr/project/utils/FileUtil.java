package by.javatr.project.utils;

import by.javatr.project.exceptions.daoexception.DAOException;
import by.javatr.project.exceptions.daoexception.IncorrectFileException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

    private static File file;
    private static FileWriter fileWriter;

    private FileUtil() {
    }

    public static void addRecord(String record, String fileName) throws DAOException, IncorrectFileException {
        try {
            file = new File( fileName );
            fileWriter = new FileWriter( file, true );
            if( record.equals( "" ) ) throw new DAOException( "Null record" );

            FileWriter fileWriter = new FileWriter( file, true );
            fileWriter.write( record + "\n" );
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }


    public static void updateFile(List<String> records, String fileName) throws DAOException, IncorrectFileException {
        try {
            file = new File( fileName );
            fileWriter = new FileWriter( file, true );
            if( records == null ) throw new DAOException( "Null records" );
            clearFile( fileName );
            Stream.of( records ).forEach( str -> {
                try {
                    fileWriter.write( str + System.lineSeparator() );
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            } );
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }

    private static void clearFile(String fileName) throws IncorrectFileException {
        try {
            file = new File( fileName );
            Files.delete( Paths.get( file.getPath() ) );
            Files.createFile( Paths.get( file.getPath() ) );
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }

    public static List<String> getAllRecords(String fileName) throws DAOException, IOException {
        if( fileName == null ) {
            throw new DAOException( "Null filename" );
        }
        else {
            return Files.lines( Paths.get( file.getPath() ),
                    StandardCharsets.UTF_8 ).collect( Collectors.toList() );
        }

    }

}
