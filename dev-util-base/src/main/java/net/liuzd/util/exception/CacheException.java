package net.liuzd.util.exception;


/**
 * 缓存异常
 */
public class CacheException extends BusinessException {
  
    private static final long serialVersionUID = 1L;

    public CacheException() {
        super();
    }

    public CacheException(String message) {
        super(message);
    }

    public CacheException(String message, Exception exception) {
        super(message, exception);
    }

    public CacheException(Throwable cause) {
        super(cause);
    }

}
