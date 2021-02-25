package com.tata.shoppingden.dao;

import com.tata.shoppingden.models.Category;
import com.tata.shoppingden.models.Customer;
import com.tata.shoppingden.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    public void addCategory(Category category) throws SQLException;
    public void addProduct(Product product) throws SQLException;
    public void deleteProduct(long productId) throws Exception;
    public List<Customer> viewAllCustomerDetails() throws SQLException;
    public List<Category> getCategories() throws SQLException;

}
