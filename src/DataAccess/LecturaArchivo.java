package DataAccess;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

import FrameWork.AppExceptionAriel;
public class LecturaArchivo {
    public List<String> lines;
    public void LeerArchivos(String directorioHorario) throws IOException, AppExceptionAriel, SQLException{
        File f = new File(directorioHorario);
        if(f.isDirectory()){
            String[] fileNames = f.list();
            for (String nomArchivo : fileNames) {
                if(nomArchivo.endsWith(".csv")){
                    String nombreArchivo= directorioHorario+"\\"+nomArchivo;
                    lines = Files.readAllLines(Paths.get(nombreArchivo));
                    String nombreTabla= nomArchivo.substring(nomArchivo.indexOf("-")+1,nomArchivo.lastIndexOf("."));
                    String [] nombreTabla2=nombreTabla.split(" ");
                    String nombreT= nombreTabla2 [0];
                    SQLiteDataHelper.crearTablaDesdeCSV(lines,nombreT);
                          
                }
            }
        }else{
            System.out.println(";/ Error en directorioHorario: "+ directorioHorario);
        }
    }

}
 