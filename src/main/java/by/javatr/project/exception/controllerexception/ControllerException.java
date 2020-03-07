package by.javatr.project.exception.controllerexception;

public class ControllerException extends Exception {
    public ControllerException(String errorMessage, Throwable err) {
        super( errorMessage, err );
    }
}
