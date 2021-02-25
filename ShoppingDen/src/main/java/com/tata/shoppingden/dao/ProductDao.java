package com.tata.shoppingden.dao;

import com.tata.shoppingden.models.Product;


import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public Product getProductByName(String pname) throws SQLException;
    public List<Product> viewProducts() throws SQLException;
}
