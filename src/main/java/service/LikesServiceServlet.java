package service;

import java.sql.*;

public class LikesServiceServlet {

    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/newecommerce";
        String username = "root";
        String password = "#@Emeka7546";

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();


            //liked product created already
            int insert = statement.executeUpdate("INSERT INTO likes VALUES(404, 'customer', '303')");
            System.out.println(insert + " records inserted");

            // READ liked products
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getString(3));
            }

            // UPDATE likes
            int update = statement.executeUpdate("UPDATE likes SET id='405' WHERE id= 404");

            System.out.println(update + " record updated");

            //DELETE likes
            int delete = statement.executeUpdate("DELETE FROM likes WHERE id=404");

            System.out.println(delete + " records deleted");



            connection.close();
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
    }
}
