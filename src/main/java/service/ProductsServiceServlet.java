package service;

import java.sql.*;

public class ProductsServiceServlet {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/newecommerce";
        String username = "root";
        String password = "#@Emeka7546";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            //products info created already
            int insert = statement.executeUpdate("INSERT INTO products VALUES(303, 'HISENSE SMART TV', '20000', '1')");
            System.out.println(insert + " records inserted");

            // READ available products
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) +
                        " " + resultSet.getString(4));
            }

            // update products
            int update = statement.executeUpdate("UPDATE products SET name='LG SMART TV' WHERE id= 303");

            System.out.println(update + " record updated");

            //DELETE products
            int delete = statement.executeUpdate("DELETE FROM products WHERE id=303");

            System.out.println(delete + " records deleted");



            connection.close();
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
