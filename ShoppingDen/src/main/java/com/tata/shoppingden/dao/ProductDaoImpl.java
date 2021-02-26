package com.tata.shoppingden.dao;

import com.tata.shoppingden.helper.PostgresConnHelper;
import com.tata.shoppingden.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProductDaoImpl implements ProductDao{
    private Connection conn;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    public ProductDaoImpl(){
        conn= PostgresConnHelper.getConnection();
        if(conn!=null)
            System.out.println("Connection ready...");
        else
            System.out.println("Connection has issue...");
        resourceBundle= ResourceBundle.getBundle("db");
    }
    @Override
    public Product getProductByName(String productName) throws SQLException {
        Product product=new Product();
        String query = resourceBundle.getString("getproductbyname");
        PreparedStatement getByName = conn.prepareStatement(query);
        getByName.setString(1,productName);
        resultSet=getByName.executeQuery(query);
        while(resultSet.next()){
            product.setProductId(resultSet.getLong(1));
            product.setProductName(resultSet.getString(2));
            product.setProductPrice(resultSet.getFloat(3));
            product.setProductDate(resultSet.getDate(4));
            product.setProductQuantity(resultSet.getInt(5));
            product.setProductDescription(resultSet.getString(6));
        }
        return product;
    }

    @Override
    public List<Product> viewProducts() throws SQLException {
        List<Product> customerList=new ArrayList<>();
        String query=resourceBundle.getString("selectallproduct");
        Statement statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        while(resultSet.next())
        {
            Product prod=new Product();
            prod.setProductId(resultSet.getLong(1));
            prod.setProductName(resultSet.getString(2));
            prod.setProductPrice(resultSet.getFloat(3));
            prod.setProductQuantity(resultSet.getInt(4));
            prod.setProductDate(resultSet.getDate(5));
            prod.setProductDescription(resultSet.getString(6));
            customerList.add(prod);
        }
        return customerList;
    }
}
