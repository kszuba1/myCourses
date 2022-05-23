package io.github.kszuba1.entity.dto;

public class StudentDTO {

    private String nickname;

    private String username;

    private String password;

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
