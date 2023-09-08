import DataAccess.*;
import FrameWork.AppExceptionAriel;

import javax.swing.SwingUtilities;
import DataAccess.*;
import BusinessLogic.BibliotecaBL;
import BusinessLogic.Entities.Biblioteca;
import UserInterface.BibliotecaMenu;
import UserInterface.BibliotecaSplash;

public class App {
    public static  String directorioHorario= ".\\Horarios";
    public static void main(String[] args) throws Exception {
        LecturaArchivo la= new LecturaArchivo();
        la.LeerArchivos(directorioHorario);
        // LecturaArchivo lArchivo= new LecturaArchivo();
        // lArchivo.LeerArchivos(directorioHorario);
        // BibliotecaMenu menu=new BibliotecaMenu();
        // menu.mostrarMenu();
    }
}
