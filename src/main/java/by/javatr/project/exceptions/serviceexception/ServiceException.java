package by.javatr.project.exceptions.serviceexception;

public class ServiceException extends Exception {
    public ServiceException(String errorMessage, Throwable err) {
        super( errorMessage, err );
    }
}
