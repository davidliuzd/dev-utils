package net.liuzd.util.exception;

/**
 * 业务异常，如果异常来自该异常或者集成自该异常，则放过，并且作为提示信息在后台展示。
 */
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
