import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); // set timeout to 30 sec.
            String query = """
                    SELECT *
                    FROM price
                    WHERE entry_price > 200000
                    ORDER BY entry_price;
                    """;
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                // read the result set
                System.out.println(rs.getString("Maker") + " " + rs.getString("Entry_price"));
                // System.out.println("id = " + rs.getInt("id"));
            }

        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e.getMessage());
            }
        }
    }
}