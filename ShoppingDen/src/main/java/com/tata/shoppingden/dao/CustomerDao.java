package com.tata.shoppingden.dao;

import com.tata.shoppingden.models.Product;
import com.tata.shoppingden.models.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public void addToCart(long pid, long cid) throws SQLException;
    public void removeFromCart(long pid,long cid) throws SQLException;
}
