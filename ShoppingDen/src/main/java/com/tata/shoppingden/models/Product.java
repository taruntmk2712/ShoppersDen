package com.tata.shoppingden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product{
    private long productId;
    private String productName;
    private float productPrice;
    private int productQuantity;
    private Date productDate;
    private String productDescription;
}
