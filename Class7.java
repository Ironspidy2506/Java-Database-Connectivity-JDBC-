import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Class7 {
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

            // SQL query to select all records from 'table1'
            String q = "SELECT * FROM table1";
            Statement stmt = con.createStatement();

            // Execute the query and store the results in a ResultSet
            ResultSet set = stmt.executeQuery(q);

            // Iterate through the ResultSet and print the values
            while (set.next()) {
                int id = set.getInt(1); // Get the ID from the first column
                String name = set.getString(2); // Get the name from the second column
                String city = set.getString(3); // Get the city from the third column
                System.out.println(id + " " + name + " " + city); // Print the values
            }

            System.out.println("Values Shown........");

            // Close the connection after completing the operation
            con.close();

        } catch (Exception e) {
            // Handle any exceptions and print the stack trace for debugging
            e.printStackTrace();
        }
    }
}
