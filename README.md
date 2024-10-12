
# 📚 JDBC Overview

Java Database Connectivity (JDBC) is a Java API used to connect and execute queries with databases. Below is a brief overview of the basic JDBC steps.

---

## 🛠️ Steps to connect and work with JDBC:

### 1️⃣ Load the Driver  
You need to load the driver for the database you want to connect to. Here's how you can do it for MySQL:

```java
Class.forName("com.mysql.jdbc.Driver");
// Or you can register the driver
DriverManager.registerDriver(new com.mysql.jdbc.Driver());
```

### 2️⃣ Create a Connection  
After loading the driver, establish a connection to the database:

```java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "system");
```

### 3️⃣ Create a Query and Statement  
You can use `Statement`, `PreparedStatement`, or `CallableStatement` to run SQL queries:

```java
// Example query
String query = "SELECT * FROM Students";

// Creating a statement and executing it
Statement stmt = con.createStatement();
ResultSet set = stmt.executeQuery(query);  // For SELECT
```

For other operations (INSERT, DELETE, UPDATE):
```java
stmt.executeUpdate(query);
```

### 4️⃣ Process the Data  
Once you have the result, you can loop through the data:

```java
while(set.next()) {
    int id = set.getInt(1);  // or set.getInt("columnName")
    String name = set.getString("studentName");
    System.out.println(id + " " + name);
}
```

### 5️⃣ Close the Connection  
Don't forget to close the connection when done:

```java
con.close();
```

---

### 🎯 Summary

1. Load the Driver
2. Create a Connection
3. Create a Query
4. Process the Results
5. Close the Connection

---

Enjoy your coding! 💻✨
