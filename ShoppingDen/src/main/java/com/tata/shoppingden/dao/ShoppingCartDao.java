package com.tata.shoppingden.dao;

import com.tata.shoppingden.models.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartDao {
    public List<ShoppingCart> displayCart(long uid) throws SQLException;
}
