package com.tata.shoppingden.utility;

import com.tata.shoppingden.dao.AdminDaoImpl;
import com.tata.shoppingden.models.Category;
import com.tata.shoppingden.models.Product;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class ShoppingDenAdmin {
    Scanner s= new Scanner(System.in);
    AdminDaoImpl admin=new AdminDaoImpl();
    public void adminClass() throws SQLException {
        System.out.println("Admin Page");
        System.out.println("1. Add Category");
        System.out.println("2. Add Product");
        System.out.println("3. Delete Product");
        System.out.println("4. View All Customer Details");
        System.out.println("5. View All Category Details");
        int adminOperations = s.nextInt();
        switch (adminOperations){
            case 1:
                adminAddingCategory();
                break;
            case 2:
                adminAddingProduct();
                break;
            case 3:
                System.out.println("Enter product Id");
                long deleteProductId=s.nextInt();
                admin.deleteProduct(deleteProductId);
            case 4:
                System.out.println(admin.viewAllCustomerDetails());
                break;
            case 5:
                System.out.println(admin.getCategories());
                break;
            default:
                System.out.println("Please Enter Valid Option");
        }
    }

    public void adminAddingCategory() throws SQLException {
        Category category = new Category();
        System.out.println("Enter Category Name:");
        String cname=s.next();
        category.setCategoryId(new Random().nextLong());
        category.setCategoryName(cname);
        admin.addCategory(category);
    }

    public void adminAddingProduct() throws SQLException{
        Product product = new Product();
        product.setProductId(new Random().nextLong());
        System.out.println("Enter Product Name:");
        String pName=s.next();
        product.setProductName(pName);
        product.setProductPrice(new Random().nextFloat());
        product.setProductQuantity(new Random().nextInt(50));
        long millis=System.currentTimeMillis();
        product.setProductDate(new Date(millis));
        System.out.println("Enter Product Description:");
        String pDescription=s.next();
        product.setProductDescription(pDescription);
        admin.addProduct(product);
    }
}
