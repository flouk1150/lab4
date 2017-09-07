

import java.sql.*;

/**
 * This program demonstrates making JDBC connection to a SQLite database.
 * @author www.codejava.net
 *
 */
public class SQL {
    private static int id;
    static int d;
    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:caledar.db";
            Connection conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());


                String query = "Select * from calendar";
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()){
                    id = resultSet.getInt(1);
                    d=id;
                    String name = resultSet.getString(2);
                    double price = resultSet.getDouble(3);

                    System.out.println("id: "+id+" name: "+name+"price: "+price);
                }
                conn.close();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(test());

    }

    public static int test(){
        return id;
    }
    public static int test2(){
        return d;
    }
}