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
    private int tipoDeJuego;
    private JPanel panelJugadores;
    private JPanel panelJuego;
    private JLabel jugador1;
    private JLabel jugador2;
    private String tipoMaquina;
    private Color color1;
    private Color color2;
    private String nombre1;
    private String nombre2;
    public PantallaJuego(JFrame owner,int tipoDeJuego,ArrayList<String> nombres,ArrayList<Color> colores){
        super(owner);
        pantallaPrincipal=owner;
        this.tipoDeJuego=tipoDeJuego;
        nombre1=nombres.get(0);
        nombre2=nombres.get(1);
        color1=colores.get(0);
        color2=colores.get(1);
        if (tipoDeJuego==2)
            tipoMaquina=nombres.get(2);
        prepareElementos();
        //prepareAcciones();
    }
    public void prepareElementos(){
        setTitle("PANTALLA DE JUEGO");
		setSize(1366,710);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelJugadores=new JPanel();
        panelJugadores.setBackground(Color.BLACK);
        panelJuego=new JPanel();
        panelJugadores.setLayout(new GridLayout(3,3,7,7));
        prepararPanelJugadores();
        add(panelJuego,BorderLayout.CENTER);
    }
    private void prepararPanelJugadores(){
        jugador1=new JLabel();

    }
}
