package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Statement;
import FrameWork.AppExceptionAriel;

public abstract class SQLiteDataHelper {
    private static String DBPathConnection = "jdbc:sqlite:dataBase\\prueba3.db"; //URL de la conexion a la base de datos.
    private static Connection conn = null; 
    public SQLiteDataHelper(){
        
    } 
    public static synchronized Connection openConnection() throws AppExceptionAriel{
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
    public static void crearTablaDesdeCSV(List<String> lines, String nombreTabla)throws AppExceptionAriel, SQLException{
        if (lines !=null && !lines.isEmpty()) {
            Connection connection= openConnection();
            Statement stmt=  connection.createStatement();
            String encabezado= lines.get(0);
            String [] columNames= encabezado.split(";");
            StringBuilder crearTablaSql= new StringBuilder("CREATE TABLE ");
            crearTablaSql.append(nombreTabla).append(" (");
            for (String columName : columNames) {
                crearTablaSql.append(columName.trim()).append(" TEXT,");
            }
            crearTablaSql.setLength(crearTablaSql.length() - 2);
            crearTablaSql.append(");");
            stmt.executeUpdate(crearTablaSql.toString());
            System.out.println("Se creo la tabla con exito");
            insertarDatos(lines, nombreTabla, connection);
            
        }
    }
    public static void insertarDatos(List<String> lines, String nombreTabla, Connection connection){
        String insertSQL= "INSERT INTO " + nombreTabla + " (Nro, Codigo, Materia, Paral, Aula, Créditos, " +
        "Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Carrera, Obs) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         try (PreparedStatement pstmt = connection.prepareStatement(insertSQL)) {
            for (String line : lines) {
                String[] values = line.split(";");
                if (values.length <= 14) { // Asegura que haya 14 valores (uno por cada columna)
                    for (int i = 0; i < values.length; i++) {
                        pstmt.setString(i + 1, values[i].trim()); // El índice comienza en 1
                    }
                    pstmt.executeUpdate(); // Ejecuta la inserción
                } else {
                    // Maneja el caso en el que no haya suficientes valores en la línea
                    System.err.println("La línea no tiene suficientes valores: " + line);
                }
            }
        } catch (SQLException e) {
            // Manejar cualquier excepción SQL que pueda ocurrir
            e.printStackTrace();
        }
    }

}
