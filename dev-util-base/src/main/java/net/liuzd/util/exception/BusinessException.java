package net.liuzd.util.exception;

public class BusinessException extends RuntimeException {
  
    private static final long serialVersionUID = 1L;

    public BusinessException() {

    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String errorMsg, Exception e) {
        super(errorMsg, e);
    }
}
