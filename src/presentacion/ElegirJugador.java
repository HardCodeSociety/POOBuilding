package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class ElegirJugador extends JDialog{
    JPanel panelImagenes;
    int tipoDeJuego;
    //Elementos panelImagenes
    JButton jugador1;
    JButton jugador2;
    JButton candy;
    JButton calhoun;
    JButton candy2;
    JButton calhoun2;

    public ElegirJugador(int tipoDeJuego){
        this.tipoDeJuego=tipoDeJuego;
        prepareElementos();
    }

    public void prepareElementos(){
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(4*screen.width/6,4*screen.height/6);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelImagenes=new JPanel();
        panelImagenes.setSize(200,200); 
        panelImagenes.setLayout(new GridLayout(1,3,200,7));
        panelImagenes.setBackground(Color.BLACK);
        panelImagenes.setBorder(BorderFactory.createEmptyBorder(0,200,200,300));
        elementosPanelImagenes();
        add(panelImagenes,BorderLayout.CENTER);
    }
    public void elementosPanelImagenes(){
        ImageIcon icono=new ImageIcon("imagenes/felix.png");
        if(tipoDeJuego==1|tipoDeJuego==2){
            jugador1=new JButton();
            jugador1.setIcon(icono);
            jugador1.setBackground(Color.RED);
            jugador1.setSize(236,236);
            jugador1.setBorderPainted(false);
            panelImagenes.add(jugador1);
        }if(tipoDeJuego==2|tipoDeJuego==3){
            candy=new JButton();
            calhoun=new JButton();
            candy.setIcon(icono);
            calhoun.setIcon(icono);
            candy.setBackground(Color.GREEN);
            panelImagenes.add(candy);
            calhoun.setBackground(Color.YELLOW);
            panelImagenes.add(calhoun);
        } if (tipoDeJuego==1){
            jugador2=new JButton();
            jugador2.setIcon(icono);
            jugador2.setBackground(Color.BLUE);
            panelImagenes.add(jugador2);
        } if (tipoDeJuego==3){
            candy2=new JButton();
            calhoun2=new JButton();
            candy2.setIcon(icono);
            calhoun2.setIcon(icono);
            candy2.setBackground(Color.ORANGE);
            panelImagenes.add(candy2);
            calhoun2.setBackground(Color.WHITE);
            panelImagenes.add(calhoun2);
        }
    }
}