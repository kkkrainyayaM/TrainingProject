package by.javatr.project.exceptions.controllerexception;

public class ControllerException extends Exception {
    public ControllerException(String errorMessage, Throwable err) {
        super( errorMessage, err );
    }
}
