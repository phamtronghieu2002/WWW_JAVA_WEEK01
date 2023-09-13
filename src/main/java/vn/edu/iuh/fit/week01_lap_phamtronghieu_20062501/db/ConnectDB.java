package vn.edu.iuh.fit.week01_lap_phamtronghieu_20062501.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {



    private static ConnectDB instance;
    private Connection connection;

    private ConnectDB() {

        try {
        System.out.println("Connecting to the database...");
            Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/mydb",
                "root", "sapassword");
        System.out.println("Connection valid: " + connection.isValid(5));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static ConnectDB getInstance() {
        if(instance == null)
            instance = new ConnectDB();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }




//    private static Connection connection;
//
//    /**
//     * Entry point of the application. Opens and closes the database connection.
//     *
//     * @param args (not used)
//     * @throws SQLException if an error occurs when interacting with the database
//     */
//    public static void main(String[] args) throws SQLException {
//
//            initDatabaseConnection();
//
//    }
//
//    private static void initDatabaseConnection() throws SQLException {
//        System.out.println("Connecting to the database...");
//        connection = DriverManager.getConnection(
//                "jdbc:mariadb://localhost:3306/mydb",
//                "root", "sapassword");
//        System.out.println("Connection valid: " + connection.isValid(5));
//		/*
//		If you are using MariaDB SkySQL (https://mariadb.com/products/skysql),
//		enable SSL and specify the path to the CA chain file that you can download
//		from the SkySQL Portal (https://cloud.mariadb.com):
//			jdbc:mariadb://demo-db0000xxxx.mdb000xxxx.db.skysql.net:5047/demo?useSsl=true&serverSslCert=/path/to/your/skysql_chain.pem
//		*/
//    }
//
//    private static void closeDatabaseConnection() throws SQLException {
//        System.out.println("Closing database connection...");
//        connection.close();
//        System.out.println("Connection valid: " + connection.isValid(5));
//    }
}
