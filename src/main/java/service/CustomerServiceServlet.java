package service;

import jakarta.servlet.http.HttpServlet;

import java.sql.*;

public class CustomerServiceServlet {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/newecommerce";
        String username = "root";
        String password = "#@Emeka7546";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            //customer info created already
            int insert = statement.executeUpdate("INSERT INTO customer VALUES(202, 'CHIBUEZE IKEDINOBI', 'ikedichibua@gmail.com', 'ikedi', 'Customer')");
            System.out.println(insert + " records inserted");

            // customer to READ
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) +
                        " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }

            // customer to UPDATE
            int update = statement.executeUpdate("UPDATE customer SET name='EZIOKWU NKWOCHA' WHERE id= 202");

            System.out.println(update + " record updated");

            //customer to DELETE
            int delete = statement.executeUpdate("DELETE FROM customer WHERE admin_id=202");

            System.out.println(delete + " records deleted");



            connection.close();
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
