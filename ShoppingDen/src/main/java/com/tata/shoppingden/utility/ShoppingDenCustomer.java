package com.tata.shoppingden.utility;

import com.tata.shoppingden.dao.CustomerDaoImpl;
import com.tata.shoppingden.dao.ProductDaoImpl;
import com.tata.shoppingden.dao.ShoppingCartDaoImpl;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class ShoppingDenCustomer {
    Scanner s = new Scanner(System.in);
    CustomerDaoImpl customer=new CustomerDaoImpl();
    public void customerClass() throws SQLException {
        System.out.println("Customer Page");
        System.out.println("1. View Products");
        System.out.println("2. View Cart");
        System.out.println("3. Add to Cart");
        System.out.println("4. Remove from Cart");
        System.out.println("5. Search by Product Name");
        int customerOperation=s.nextInt();
        switch (customerOperation){
            case 1:
                viewProductForCustomer();
                break;
            case 2:
                viewCustomerCart();
                break;
            case 3:
                customerAddingToCart();
                break;
            case 4:
                customerRemovingFromCart();
                break;
            case 5:
                getProductByName();
            default:
                System.out.println("Enter Valid Option");
        }

    }
    public void viewProductForCustomer() throws SQLException {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        productDaoImpl.viewProducts();
    }

    public void viewCustomerCart() throws SQLException {
        ShoppingCartDaoImpl shoppingCartDaoImpl = new ShoppingCartDaoImpl();
        System.out.println("Enter Customer Id");
        long cid=s.nextLong();
        shoppingCartDaoImpl.displayCart(cid);

    }
    public void customerAddingToCart() throws SQLException {
        CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
        System.out.println("Enter Product Id");
        long pid=s.nextLong();
        System.out.println("Enter Customer Id");
        long cid=s.nextLong();
        customerDaoImpl.addToCart(pid,cid);
    }

    public void customerRemovingFromCart() throws SQLException {
        CustomerDaoImpl customerDaoImpl=new CustomerDaoImpl();
        System.out.println("Enter Product Id");
        long pid=s.nextLong();
        System.out.println("Enter Customer Id");
        long cid=s.nextLong();
        customerDaoImpl.removeFromCart(pid,cid);
    }
    public void getProductByName() throws SQLException {
        ProductDaoImpl productDaoImpl = new ProductDaoImpl();
        System.out.println("Enter Product Name");
        String pname=s.nextLine();
        productDaoImpl.getProductByName(pname);
    }
}
