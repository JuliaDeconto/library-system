import br.com.librarysystem.connection.DatabaseConnection;

import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {

            Connection connection = DatabaseConnection.getConnection();

            System.out.println("Successful connection");

            connection.close();
        } catch (Exception e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
