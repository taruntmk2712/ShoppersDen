package com.tata.shoppingden.dao;

import com.tata.shoppingden.helper.PostgresConnHelper;
import com.tata.shoppingden.models.ShoppingCart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCartDaoImpl implements ShoppingCartDao{
    private Connection conn;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    private Statement statement;

    public ShoppingCartDaoImpl(){
        conn= PostgresConnHelper.getConnection();
        if(conn!=null)
            System.out.println("Connection ready...");
        else
            System.out.println("Connection has issue...");
        resourceBundle= ResourceBundle.getBundle("db");
    }

    @Override
    public List<ShoppingCart> displayCart(long userId) throws SQLException {
        List<ShoppingCart> shoppingCartList=new ArrayList<>();
        String query=resourceBundle.getString("viewcartsinglecustomer");
        PreparedStatement viewCart = conn.prepareStatement(query);
        viewCart.setLong(1, userId);
        statement=conn.createStatement();
        resultSet=statement.executeQuery(query);
        while(resultSet.next()){
            ShoppingCart shoppingCart=new ShoppingCart();
            shoppingCart.setCustomerId(resultSet.getLong(1));
            shoppingCart.setProductId(resultSet.getLong(2));
            shoppingCart.setQuantity(resultSet.getInt(3));
            shoppingCartList.add(shoppingCart);
        }
        return shoppingCartList;
    }
}
