package by.javatr.project.idgenerator;

public final class IDGenerator {

    private static int lastIDUser;
    private static int lastIDTransaction;
    private static IDGenerator instance;

    private IDGenerator() {
        //TODO idgenerator
    }

    public static synchronized IDGenerator getInstance() {
        if( instance == null ) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public int getIDUser() {
        return ++lastIDUser;
    }

    public int getIDTransaction() {
        return ++lastIDTransaction;
    }


}
