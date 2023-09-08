import DataAccess.*;
import FrameWork.AppExceptionAriel;

import javax.swing.SwingUtilities;

import BusinessLogic.BibliotecaBL;
import BusinessLogic.Entities.Biblioteca;
import UserInterface.BibliotecaMenu;
import UserInterface.BibliotecaSplash;
public class App {
    public static void main(String[] args) throws Exception {
        BibliotecaMenu menu=new BibliotecaMenu();
        menu.mostrarMenu();
    }
}
