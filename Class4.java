import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Class4 {
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

            // Create BufferedReader to read user input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Prompt user for input
            System.out.print("Enter Name: ");
            String name = br.readLine(); // Read the name input from the user
            System.out.print("Enter City: ");
            String city = br.readLine(); // Read the city input from the user

            // Set the values for the placeholders in the query
            pstmt.setString(1, name); // Set the first parameter (tName)
            pstmt.setString(2, city); // Set the second parameter (tCity)

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
