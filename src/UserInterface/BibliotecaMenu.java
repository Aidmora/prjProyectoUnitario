package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.BibliotecaBL;
import BusinessLogic.Entities.Biblioteca;
import FrameWork.AppExceptionAriel;
import UserInterface.CustomerControl.ArielButton;

public class BibliotecaMenu extends JFrame implements ActionListener{
    private BibliotecaBL  bibliotecaBL  = null;
    private Biblioteca   biblioteca    = null;
    private JPanel pnlTabla   = new JPanel();
    public BibliotecaSplash bibliotecaSplash= new BibliotecaSplash();
    public ArielButton mostrarTabla;
    private DefaultTableModel tableModel;
    private int nroRegistros = 3; 
    private int pagActual = 1; 
    private List<Biblioteca> biblioData; 
    private JTable table; 
    private JPanel panelBotonPaginado;
public BibliotecaMenu() throws AppExceptionAriel {
    bibliotecaBL = new BibliotecaBL();
    biblioData = bibliotecaBL.getAllData();
    setTitle("Biblioteca");
    setGridBagLayout();
    mostrarTabla=new ArielButton("/UserInterface/Img/libroAbierto3.png");
    add(mostrarTabla);
    mostrarTabla.addActionListener(new ActionListener() {
        @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mostrarTabla){
            mostrarTabla.setVisible(false); 
            mostrarInfo();
        }
    }
    });

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
}

private void generarTabla() {
    String[] header = {"Comentario", "Libro", "Autor"};
    Object[][] data = new Object[nroRegistros][3]; 

    tableModel = new DefaultTableModel(data, header); 
    table = new JTable(tableModel); 

    table.setShowHorizontalLines(true);
    table.setGridColor(Color.BLACK);
    table.setRowSelectionAllowed(true);
    table.setColumnSelectionAllowed(false);
    table.setPreferredScrollableViewportSize(new Dimension(650, 150));

    pnlTabla.removeAll();
    pnlTabla.add(table);
    JScrollPane scrollPane = new JScrollPane(table);
    pnlTabla.add(scrollPane);
}

private void mostrarPaginado(int page) {
    pagActual = page;
    int inicioPagina = (page - 1) * nroRegistros;
    int nroFinalPag = Math.min(inicioPagina + nroRegistros, biblioData.size());

    Object[][] datosPagina = new Object[nroRegistros][3];

    for (int i = inicioPagina; i < nroFinalPag; i++) {
        Biblioteca bli = biblioData.get(i);
        datosPagina[i - inicioPagina][0] = bli.getReseña();
        datosPagina[i - inicioPagina][1] = bli.getNombreLibro();
        datosPagina[i - inicioPagina][2] = bli.getNombreAutor();
    }
    tableModel.setDataVector(datosPagina, new String[]{"<html><font color='#e2c15c'>Comentario</font></html>", 
                                                    "<html><font color='#e2c1 5c'>Libro</font></html>", 
                                                    "<html><font color='#e2c15c'>Correo electr\u00F3nico</font></html>"});
}
private void botonPaginado() {
    panelBotonPaginado = new JPanel();
    JButton pagAnterior = new JButton("<-");
    JButton pagPosterior = new JButton("->");

    pagAnterior.setBackground(Color.CYAN);
    pagPosterior.setBackground(Color.CYAN);
    pagAnterior.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (pagActual > 1) {
                mostrarPaginado(pagActual - 1);
            }
        }
    });

    pagPosterior.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int totalPages = (int) Math.ceil((double) biblioData.size() / nroRegistros);
            if (pagActual < totalPages) {
                mostrarPaginado(pagActual + 1);
            }
        }
    });

    panelBotonPaginado.add(pagAnterior);
    panelBotonPaginado.add(pagPosterior);
    panelBotonPaginado.setLocation(500, 500);
    add(panelBotonPaginado);
}

    public void setGridBagLayout(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=3;                   
        gbc.ipady = 250;                   
        gbc.ipadx = 750;                   
        pnlTabla.add(new Label("Loading data..."));
        pnlTabla.setBackground(Color.WHITE);
        add(pnlTabla, gbc);
        
        
    }
    public void mostrarMenu(){
        bibliotecaSplash.mostrarPantallazo();
        setVisible(true); 
    }
    private void mostrarInfo() {
        generarTabla(); 
        mostrarPaginado(pagActual); 
        botonPaginado(); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}

