package com.otp.validation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Firstname should not be null!!")
    @Size(min = 2,max = 30, message = "Firstname size min 2 and max 30 character are allowed!!")
    private String firstName;
    @NotBlank(message = "Lastname should not be null!!")
    @Size(min = 2,max = 30, message = "Lastname size min 2 and max 30 character are allowed!!")
    private String lastName;

    @Column(unique = true)
    @NotBlank(message = "Email should not be null")
    private String email;

    private String role;
    @NotBlank(message = "Password should not be null")
    private String password;

    private boolean enabled;

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
