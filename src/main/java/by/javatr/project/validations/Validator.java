package by.javatr.project.validations;

public class Validator {
    public static boolean isItemNum(int value) {
        return value > 0;
    }

    public static boolean isNull(Object string) {
        return string == null;
    }

    public static boolean isId(int id) {
        return id > -1;
    }
}
