import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Class3 {
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

            // SQL query to insert values into 'table1'
            String q = "INSERT INTO table1(tName, tCity) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            // Set the values for the placeholders in the query
            pstmt.setString(1, "Aaru"); // Set the first parameter (tName)
            pstmt.setString(2, "Jamshedpur"); // Set the second parameter (tCity)

            // Execute the update to insert the values into the table
            pstmt.executeUpdate(); // Executes the insert statement

            System.out.println("Values Inserted........");

            // Close the connection after executing the query
            con.close();

        } catch (Exception e) {
            // Handle any exceptions and print the stack trace for debugging
            e.printStackTrace();
        }
    }
}

/*
 * Prepared Statement = Dynamic Query during Runtime
 */
