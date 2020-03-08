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

public class FileUtil {

    private FileUtil() {
    }

    public static void addRecord(String record, String fileName) throws DAOException, IncorrectFileException {
        try {
            if( record.equals( "" ) ) throw new DAOException( "Null record" );
            FileWriter fileWriter = new FileWriter( new File( fileName ), true );
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
            if( records == null ) throw new DAOException( "Null records" );
            clearFile( new File( fileName ) );
            FileWriter fileWriter = new FileWriter( new File( fileName ), true );
            /*Stream.of( records ).forEach( str -> {
                try {
                    fileWriter.write( str + "\n" );
                    fileWriter.flush();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            } );*/
            for(int i=0; i < records.size(); i++){
                addRecord( records.get( i ),fileName );
            }
            fileWriter.close();
        }
        catch (IOException e) {
            throw new IncorrectFileException( "Incorrect filepath : " + fileName );
        }
    }

    private static void clearFile(File file) throws IncorrectFileException {
        try {
            Files.delete( file.toPath() );
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
