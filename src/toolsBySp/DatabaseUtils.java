package toolsBySp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * A utility class for handling database operations such as establishing 
 * connections, closing connections, loading drivers, and displaying query results.
 * 
 * <p>This class provides methods to simplify database interaction, making it 
 * easier to connect to a database, close connections safely, and display 
 * query results in a readable format.</p>
 * 
 * @author Samuel Pestana
 */
public class DatabaseUtils {

	/**
	 * Establishes a connection to the database.
	 *
	 * @param url      The database URL (e.g., "jdbc:mysql://localhost:3306/mydb").
	 * @param user     The database username.
	 * @param password The database password.
	 * @return A Connection object if successful, or null if a SQLException occurs.
	 */
	public Connection getConnection(String url, String user, String password) {
		try {	
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			return null;
		}
	}
	
	/**
	 * Closes the given database connection.
	 *
	 * @param conn The Connection object to close.
	 * @return True if the connection was closed successfully, false if it was null or already closed.
	 */
	public boolean closeConnection(Connection conn) {
		if (conn == null) return false;
		try {
			if (!conn.isClosed()) {
				conn.close();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**
     * Loads a specific database driver manually if needed.
     *
     * @param driverClass The full class name of the driver (e.g., "com.mysql.cj.jdbc.Driver").
     * @return True if the driver was loaded successfully, false otherwise.
     */
    public boolean loadDriver(String driverClass) {
        try {
            Class.forName(driverClass);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    /**
     * Displays the contents of a {@link ResultSet} in a formatted table.
     *
     * @param rs The {@code ResultSet} to display.
     * @return {@code true} if the ResultSet contains data and was displayed successfully, 
     *         {@code false} if it is empty, null, or an error occurs.
     */
    public boolean showResultSetData(ResultSet rs) {
        if (rs == null) return false; // Return false if ResultSet is null

        try {
            if (!rs.isBeforeFirst()) { // Check if the ResultSet has data
                return false;
            }

            // Retrieve metadata from the ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount(); // Get the number of columns
            int[] colWidths = new int[cols]; // Array to store column widths

            // Calculate column widths based on column names and display sizes
            for (int i = 1; i <= cols; i++) {
                String colName = rsmd.getColumnName(i);
                colWidths[i - 1] = Math.max(colName.length(), rsmd.getColumnDisplaySize(i));
                System.out.print(String.format("%-" + colWidths[i - 1] + "s", colName) + "\t");
            }
            System.out.println(); // New line after headers

            // Print separator line
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < colWidths[i]; j++) {
                    System.out.print("-");
                }
                System.out.print("\t");
            }
            System.out.println(); // New line after separator

            // Iterate through rows and print data
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    String dato = rs.getString(i);
                    System.out.print(String.format("%-" + colWidths[i - 1] + "s", dato != null ? dato : "NULL") + "\t");
                }
                System.out.println(); // New line after each row
            }
            return true; // Return true if data was displayed
        } catch (SQLException e) {
            return false; // Return false if an error occurs
        }
    }
}
