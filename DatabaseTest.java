import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String sql = """
                    SELECT *
                    FROM price
                    WHERE entry_price < ?
                    ORDER BY entry_price;
                    """;
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            String userPrice = "5000";
            preparedStatement.setString(1, userPrice);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                System.out.println(rs.getString("Maker") + " " + rs.getString("Entry_price"));
                // System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // error message is "out of memory", probably means no database file is found
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