package com.rest.springbootRest.Rest;

public class studentNotFoundException extends RuntimeException {
    public studentNotFoundException(String message) {
      super(message);
    }
    public studentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public studentNotFoundException(Throwable cause) {
        super(cause);
    }

}
