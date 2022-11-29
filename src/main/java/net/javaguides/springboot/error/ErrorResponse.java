package net.javaguides.springboot.error;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {

    private Boolean success;
    private String message;
    private LocalDateTime dateTime;
    private List<String> details;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
        this.success= Boolean.FALSE;
        this.dateTime = LocalDateTime.now();
    }
}
