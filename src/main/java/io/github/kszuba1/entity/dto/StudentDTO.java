package io.github.kszuba1.entity.dto;

import io.github.kszuba1.validation.Nickname;
import io.github.kszuba1.validation.Username;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class StudentDTO {

    @NotBlank(message = "nickname cannot be blank")
    @Size(min = 3, message = "nickname must be at least 3 characters long ")
    @Size(max = 20, message = "nickname must be up to 20 characters long ")
    @Nickname
    private String nickname;

    @NotBlank(message = "login cannot be blank")
    @Size(min = 4, message = "login must be at least 4 characters long ")
    @Size(max = 50, message = "login must be up to 50 characters long ")
    @Username
    private String username;

    @NotBlank(message = "password cannot be blank")
    @Size(min = 4, message = "password must be at least 4 characters long ")
    @Size(max = 50, message = "password must be up to 50 characters long ")
    private String password;

    @Size(max = 50, message = "e-mail must be up to 50 characters long ")
    private String email;

    public StudentDTO() {
    }

    public StudentDTO(String nickname, String username, String password, String email) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
