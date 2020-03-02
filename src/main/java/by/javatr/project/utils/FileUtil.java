package by.javatr.project.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.stream.Stream;

public class FileUtil {

    private File file;
    private FileWriter fileWriter;

    FileUtil(URI uri) {
        try {
            file = new File( uri );
            fileWriter = new FileWriter( file, true );
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addRecord(String record) {
        try {
            FileWriter fileWriter = new FileWriter( file, true );
            fileWriter.write( record );
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void updateFile(String[] records) {
        clearFile();
        Stream.of( records ).forEach( str -> {
            try {
                fileWriter.write( str );
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } );
    }

    private void clearFile() {
        try {
            file.delete();
            file.createNewFile();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
