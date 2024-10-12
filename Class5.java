import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Class5 {
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

            // SQL query to insert binary data into 'table2'
            String q = "INSERT INTO table2(pic) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(q);

            // Create a FileInputStream to read the image file
            FileInputStream fis = new FileInputStream("D:\\Java Full Stack\\JDBC\\Sign.jpg");

            // Set the binary stream for the PreparedStatement
            pstmt.setBinaryStream(1, fis, fis.available());

            // Execute the update to insert the image into the table
            pstmt.executeUpdate(); // Executes the insert statement

            System.out.println("Insertion done........");

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
