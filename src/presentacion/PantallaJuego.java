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
    private String tipoMaquina;
    private JPanel panelJugadores;
    private JPanel panelJuego;

    private JLabel nombreJugador1;
    private JLabel energia1;
    private JLabel vidas1;
    private JLabel poderes1;
    private Color color1;
    private String nombre1;
    private JLabel nombreJugador2;
    private JLabel energia2;
    private JLabel poderes2;
    private JLabel vidas2;
    private Color color2;
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
        panelJugadores.setLayout(new GridLayout(4,3,7,7));
        panelJugadores.setBorder(BorderFactory.createEmptyBorder(10,30,0,20));
        elementosPanelJugadores();
        add(panelJugadores,BorderLayout.NORTH);
        add(panelJuego,BorderLayout.CENTER);
    }
    private void elementosPanelJugadores(){
        Font fuente = new Font("SEGA LOGO FONT",Font.TRUETYPE_FONT, 15);
        nombreJugador1=new JLabel(nombre1);
        nombreJugador2=new JLabel(nombre2);
        nombreJugador1.setFont(fuente);
        nombreJugador2.setFont(fuente);
		nombreJugador1.setForeground(color1);
        nombreJugador2.setForeground(color2);
        energia1=new JLabel();
        energia2=new JLabel();
        energia1.setOpaque(true);
        energia2.setOpaque(true);
        energia1.setBackground(color1);
        energia2.setBackground(color2);
        ImageIcon icono=new ImageIcon("imagenes/barra.png");
        energia1.setIcon(icono);
        energia2.setIcon(icono);
        icono=new ImageIcon("imagenes/vidas.png");
        vidas1=new JLabel();
        vidas2=new JLabel();
        vidas1.setOpaque(true);
        vidas2.setOpaque(true);
        vidas1.setBackground(color1);
        vidas2.setBackground(color2);   
        vidas1.setIcon(icono);
        vidas2.setIcon(icono);
        poderes1=new JLabel();
        poderes2=new JLabel();
        icono=new ImageIcon("imagenes/poderes.png");
        poderes1.setIcon(icono);
        poderes2.setIcon(icono);
        panelJugadores.add(nombreJugador1);
        panelJugadores.add(nombreJugador2);
        panelJugadores.add(energia1);
        panelJugadores.add(energia2);
        panelJugadores.add(vidas1);
        panelJugadores.add(vidas2);
        panelJugadores.add(poderes1);
        panelJugadores.add(poderes2);
        
    }
}
