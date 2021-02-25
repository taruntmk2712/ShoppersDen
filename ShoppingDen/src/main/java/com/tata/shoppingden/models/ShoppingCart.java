package com.tata.shoppingden.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {
    private long customerId;
    private long productId;
    private int quantity;
    private long tempItemId;
}
