package com.lms.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private String email;
    private String password;
    private String repeatPassword;
    private String name;
    private String dob;

    public String getAddress() {
        return email;
    }

    public void setAddress(String address) {
        this.email = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
