package com.tata.shoppingden.dao;

import com.tata.shoppingden.helper.PostgresConnHelper;
import com.tata.shoppingden.models.Customer;
import com.tata.shoppingden.models.Product;
import com.tata.shoppingden.models.ShoppingCart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class CustomerDaoImpl implements CustomerDao{
    private Connection conn;
    private ResourceBundle resourceBundle;
    private PreparedStatement addtocart_pre;

    public CustomerDaoImpl(){
        conn= PostgresConnHelper.getConnection();
        if(conn!=null)
            System.out.println("Connection ready...");
        else
            System.out.println("Connection has issue...");
        resourceBundle= ResourceBundle.getBundle("db");
    }

    @Override
    public void addToCart(long pid, long uid) throws SQLException {
        String addProductToCart=resourceBundle.getString("addproducttocart");
        addtocart_pre=conn.prepareStatement(addProductToCart);

        addtocart_pre.setLong(1,uid);
        addtocart_pre.setLong(2,pid);
        addtocart_pre.setInt(3,new Random().nextInt(5));
        addtocart_pre.setLong(4,new Random().nextLong());

        addtocart_pre.execute();
        conn.commit();
    }

    @Override
    public void removeFromCart(long pid, long uid) throws SQLException {
        PreparedStatement delete = conn.prepareStatement(resourceBundle.getString("deleteproductfromcart"));
        delete.setLong(1, pid);
        delete.setLong(2,uid);
        System.out.println(delete);
        delete.executeUpdate();
        conn.commit();

    }




}
