package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class PantallaJuego extends JDialog {
    private JFrame pantallaPrincipal;
    private JPanel panelJugadores;
    private JPanel panelJuego;
    public PantallaJuego(JFrame owner){
        super(owner);
        pantallaPrincipal=owner;
        prepareElementos();
        //prepareAcciones();
    }
    public void prepareElementos(){
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen.width/2,2*screen.height/3);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelJugadores=new JPanel();
        panelJuego=new JPanel();
        panelJugadores.setLayout(new GridLayout(3,3,7,7));


    }
}