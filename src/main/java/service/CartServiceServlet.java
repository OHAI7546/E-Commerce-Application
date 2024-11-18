package service;

import java.sql.*;

public class CartServiceServlet {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/newecommerce";
        String username = "root";
        String password = "#@Emeka7546";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            //CREATE CART
            int insert = statement.executeUpdate("INSERT INTO cart VALUES(505, 'customer', 20000, 1, 'HISENSE SMART TV', 10)");
            System.out.println(insert + " records inserted");

           // READ items in the cart
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cart");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getInt(3) +
                        " " + resultSet.getInt(4) +
                        " " + resultSet.getString(5) +
                        " " + resultSet.getInt(6));
            }

            // UPDATE cart
            int update = statement.executeUpdate("UPDATE cart SET id='506', productname='PANASONIC SOUND BAR' WHERE id= 505");

            System.out.println(update + " record updated");

            //DELETE items in cart
            int delete = statement.executeUpdate("DELETE FROM cart WHERE id=506");

            System.out.println(delete + " records deleted");



            connection.close();
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
