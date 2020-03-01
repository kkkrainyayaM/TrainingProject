package by.javatr.project.dao;

public final class IDGenerator {

    private static int lastIDUser;
    private static int lastIDTransaction;
    private static IDGenerator instance;

    private IDGenerator(){
    }

    public static synchronized IDGenerator getInstance(){
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public int getIDUser(){
        return ++lastIDUser;
    }

    public int getIDTransaction(){
        return ++lastIDTransaction;
    }


}
