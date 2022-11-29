package net.javaguides.springboot.error;

public class DuplicateRecordException extends RuntimeException{

    public DuplicateRecordException() {
    }

    public DuplicateRecordException(String message) {
        super(message);
    }
}
