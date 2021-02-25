package com.tata.shoppingden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private long userId;
    private String name;
    private String emailId;
    private String password;
    private String address;
    private long phoneNumber;
    private String securityQuestion;
    private String securityAnswer;

}
