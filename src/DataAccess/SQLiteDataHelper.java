package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import FrameWork.AppExceptionAriel;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:dataBase\\Biblioteca.db"; //URL de la conexion a la base de datos.
    private static Connection conn = null; 
    public SQLiteDataHelper(){
        
    } 
    protected static synchronized Connection openConnection() throws AppExceptionAriel{
        try {
            if(conn == null)
                conn = DriverManager.getConnection(DBPathConnection);
            System.out.println("La conexión con la base de datos se ha establecido.");
        } catch (SQLException e) {
            throw new AppExceptionAriel(e,"SQLiteDataHelper","Fallo la conexion a la base de datos");
        } 
        return conn; 
    }
    protected static void closeConnection() throws AppExceptionAriel{
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            throw new AppExceptionAriel(e,"SQLiteDataHelper", "Fallo la conección con la base de datos");
        }
    }
    

}
