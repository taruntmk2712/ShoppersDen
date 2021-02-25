package com.tata.shoppingden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {
    private long adminId;
    private String adminName;
    private String adminPassword;
}
