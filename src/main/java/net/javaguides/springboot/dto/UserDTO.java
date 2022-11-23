package net.javaguides.springboot.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class UserDTO {
    private long id;

    private String fullName;

    private String email;
}
