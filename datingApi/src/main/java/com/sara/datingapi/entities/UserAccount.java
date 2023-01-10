package com.sara.datingapi.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Primary;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Username is mandatory")
    @Length(min = 5, max = 30, message = "Username should be minimum 5 chars and max 30 characters")
    private String userName;
    private String password;
    @NotNull
    @Min(value = 18, message = "Min age is 18")
    @Max(value = 450, message = "Max age is 450")
    private int age;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Provide a valid email")
    private String email;
    @NotBlank(message = "Phone is mandatory")
    @Length(min = 10, max = 10 , message = "Phone length should be 10 digits")
    private String phoneNumber;
    private String gender;
    private String city;
    private String country;
    @OneToOne(mappedBy = "userAccount")
    private Interest interest;

    public int getId() {
        return id;
    }
}
