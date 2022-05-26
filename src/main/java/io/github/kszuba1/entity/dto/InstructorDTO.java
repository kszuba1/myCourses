package io.github.kszuba1.entity.dto;

import io.github.kszuba1.validation.Username;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class InstructorDTO {

    @NotBlank(message = "login cannot be blank")
    @Size(min = 4, message = "login must be at least 4 characters long ")
    @Size(max = 50, message = "login must be up to 50 characters long ")
    @Username
    private String username;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 4, message = "password must be at least 4 characters long ")
    @Size(max = 50, message = "password must be up to 50 characters long ")
    private String password;

    @NotBlank(message = "first name cannot be blank")
    @Size(max = 50, message = "first name must be up to 50 characters long ")
    private String firstName;

    @NotBlank(message = "last name cannot be blank")
    @Size(max = 50, message = "last name must be up to 50 characters long ")
    private String lastName;

    @Size(max = 50, message = "e-mail must be up to 50 characters long ")
    private String email;

    public InstructorDTO() {
    }

    public InstructorDTO(String username, String password, String firstName, String lastName, String email) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
