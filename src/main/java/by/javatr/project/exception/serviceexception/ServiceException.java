package by.javatr.project.exception.serviceexception;

public class ServiceException extends Exception {
    public ServiceException(String errorMessage, Throwable err) {
        super( errorMessage, err );
    }
}
