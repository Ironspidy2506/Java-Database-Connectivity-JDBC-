import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Class6 {
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

            // SQL query to update data in 'table1'
            String q = "UPDATE table1 SET tName = ?, tCity = ? WHERE tid = ?";
            PreparedStatement pstmt = con.prepareStatement(q);

            // Create BufferedReader to read user input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            // Prompt user for input
            System.out.print("Enter new Name: ");
            String name = br.readLine(); // Read new name
            System.out.print("Enter new City: ");
            String city = br.readLine(); // Read new city
            System.out.print("Enter the ID where data should be changed: ");
            int id = Integer.parseInt(br.readLine()); // Read the ID for update

            // Set the values for the placeholders in the query
            pstmt.setString(1, name); // Set the new name
            pstmt.setString(2, city); // Set the new city
            pstmt.setInt(3, id); // Set the ID where data will be updated

            // Execute the update query to modify the values in the table
            pstmt.executeUpdate(); // Executes the update statement

            System.out.println("Values Updated........");

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
