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

    private FileUtil() {
    }

    public static void addRecord(String record, String fileName) throws DAOException, IncorrectFileException {
        try {
            if( record.equals( "" ) ) throw new DAOException( "Null record" );
            File file = new File( fileName );
            System.out.println( "открыт" );
            FileWriter fileWriter = new FileWriter( file, true );
            fileWriter.write( record + "\n" );
            fileWriter.flush();
            fileWriter.close();
            System.out.println( "закрыт" );
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }


    public static void updateFile(List<String> records, String fileName) throws DAOException, IncorrectFileException {
        try {
            File file = new File( fileName );
            System.out.println( "открыт" );
            FileWriter fileWriter = new FileWriter( file, true );
            if( records == null ) throw new DAOException( "Null records" );
            clearFile( file );
            Stream.of( records ).forEach( str -> {
                try {
                    fileWriter.write( str + System.lineSeparator() );
                    fileWriter.flush();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            } );
            fileWriter.close();
            System.out.println( "закрыт" );
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }

    private static void clearFile(File file) throws IncorrectFileException {
        try {
            if(file.delete())
            {
                System.out.println("File deleted successfully");
            }
            else
            {
                System.out.println("Failed to delete the file");
            }
            //Files.delete( file.toPath() );
            Files.createFile( file.toPath() );
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + file.getAbsolutePath() );
        }
    }

    public static List<String> getAllRecords(String fileName) throws DAOException, IOException {
        if( fileName == null ) {
            throw new DAOException( "Null filename" );
        }
        else {
            File file = new File( fileName );
            return Files.lines( Paths.get( file.getPath() ),
                    StandardCharsets.UTF_8 ).collect( Collectors.toList() );
        }

    }

}
