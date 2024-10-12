import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Class2 {
    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Define the connection URL, username, and password
            String url = "jdbc:mysql://localhost:3306/javafull";
            String username = "root";
            String password = "system";

            // Create the connection using DriverManager
            Connection con = DriverManager.getConnection(url, username, password);

            // Check if the connection is closed or open
            if (con.isClosed()) {
                System.out.println("Connection is Closed");
            } else {
                System.out.println("Connection is Created");
            }

            // SQL query to create a new table 'table1' with columns tid, tName, and tCity
            String q = "create table table1 (tid int(20) primary key auto_increment, tName varchar(200) not null, tCity varchar(400))";

            // Create a Statement object to execute the query
            Statement stmt = con.createStatement();

            // Execute the update query (create table)
            stmt.executeUpdate(q);
            System.out.println("Table created in database");

            // Close the connection after executing the query
            con.close();

        } catch (Exception e) {
            // Handle any exceptions and print the stack trace for debugging
            e.printStackTrace();
        }
    }
}
