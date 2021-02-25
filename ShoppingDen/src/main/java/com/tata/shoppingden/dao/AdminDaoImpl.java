package com.tata.shoppingden.dao;

import com.tata.shoppingden.helper.PostgresConnHelper;
import com.tata.shoppingden.models.Category;
import com.tata.shoppingden.models.Customer;
import com.tata.shoppingden.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminDaoImpl implements AdminDao{
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement category_pre,product_pre;
    private Statement statement;
    private ResultSet resultSet;
    public AdminDaoImpl(){
        conn= PostgresConnHelper.getConnection();
        if(conn!=null)
            System.out.println("Connection ready...");
        else
            System.out.println("Connection has issue...");
        resourceBundle= ResourceBundle.getBundle("db");
    }
    @Override
    public void addCategory(Category category) throws SQLException {
        String addCategory=resourceBundle.getString("addcategory");
        category_pre=conn.prepareStatement(addCategory);

        category_pre.setLong(1,category.getCategoryId());
        category_pre.setString(2,category.getCategoryName());

        category_pre.execute();
        conn.commit();
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        String addProduct=resourceBundle.getString("addproduct");
        product_pre= conn.prepareStatement(addProduct);
        product_pre.setLong(1,product.getProductId());
        product_pre.setString(2, product.getProductName());
        product_pre.setFloat(3,product.getProductPrice());
        product_pre.setInt(4,product.getProductQuantity());
        product_pre.setDate(5,product.getProductDate());
        product_pre.setString(6,product.getProductDescription());
        product_pre.execute();
        conn.commit();
    }

    @Override
    public void deleteProduct(long productId) throws SQLException {
        conn=PostgresConnHelper.getConnection();
        PreparedStatement delete = conn.prepareStatement(resourceBundle.getString("deleteproduct"));
        delete.setLong(1, productId);
        System.out.println(delete);
        delete.executeUpdate();
        conn.commit();
    }



    @Override
    public List<Customer> viewAllCustomerDetails() throws SQLException {
        conn=PostgresConnHelper.getConnection();
        List<Customer> customerList=new ArrayList<Customer>();
        String query=resourceBundle.getString("selectcustomer");
        statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        while(resultSet.next())
        {
            Customer cust=new Customer();
            cust.setUserId(resultSet.getInt(1));
            cust.setName(resultSet.getString(2));
            cust.setEmailId(resultSet.getString(3));
            cust.setPassword(resultSet.getString(4));
            cust.setAddress(resultSet.getString(5));
            cust.setPhoneNumber(resultSet.getLong(6));
            cust.setSecurityQuestion(resultSet.getString(7));
            cust.setSecurityAnswer(resultSet.getString(8));
            customerList.add(cust);
        }
        return customerList;
    }

    @Override
    public List<Category> getCategories() throws SQLException {
        conn=PostgresConnHelper.getConnection();
        List<Category> catList=new ArrayList<>();
        String query=resourceBundle.getString("selectcategory");
        statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        while(resultSet.next())
        {
            Category cat=new Category();
            cat.setCategoryId(resultSet.getLong(1));
            cat.setCategoryName(resultSet.getString(2));
            catList.add(cat);
        }
        return catList;
    }
}
