
import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/slastymordasty";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args){



        Driver mySqlDriver = null;
        try {
            mySqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mySqlDriver);
            Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String phone = resultSet.getString("PHONE");
                String password = resultSet.getString("PASSWORD");
                int role = resultSet.getInt("ROLE");
                String address = resultSet.getString("ADDRESS");

                System.out.println(id + " " + name + " " + email + " " + phone + " " + password + " " + role + " " + address);
            }

        } catch (SQLException e) {
            System.out.println("Connection wrong");
        }






    }


}
