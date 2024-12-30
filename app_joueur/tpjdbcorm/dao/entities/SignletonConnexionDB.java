package ma.enset.tpjdbcorm.dao.entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SignletonConnexionDB {
    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gestion_Equipe", "root", "");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
