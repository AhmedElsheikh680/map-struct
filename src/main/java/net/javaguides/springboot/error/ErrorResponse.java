package net.javaguides.springboot.error;

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
