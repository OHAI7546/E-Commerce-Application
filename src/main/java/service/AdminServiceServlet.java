package service;

import jakarta.servlet.http.HttpServlet;

import java.sql.*;

public class AdminServiceServlet  {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/newecommerce";
        String username = "root";
        String password = "#@Emeka7546";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            //admin info created already
            int insert = statement.executeUpdate("INSERT INTO admin VALUES(101, 'EMEKA OHAI', 'ohaichukwuemeka@gmail.com', 'mekus', 'Admin')");
            System.out.println(insert + " records inserted");

           // admin to READ
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getString(3) +
                        " " + resultSet.getString(4) +
                        " " + resultSet.getString(5));
            }

           // admin to UPDATE
            int update = statement.executeUpdate("UPDATE admin SET name='Godwin' WHERE id= 101");

            System.out.println(update + " record updated");

            //admin to DELETE
            int delete = statement.executeUpdate("DELETE FROM admin WHERE admin_id=101");

            System.out.println(delete + " records deleted");



            connection.close();
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
