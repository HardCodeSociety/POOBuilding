package presentacion;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Instrucciones extends JDialog{

  //Panel principal instrucciones
  JPanel panelInstrucciones;

//Botones
  JButton botonJuego;
  JButton botonRetorno;

//Textos
  JLabel instruc;
  JLabel evitar;
  JLabel recoger;
  JLabel mover;
  JLabel arreglar;

  public Instrucciones(){
    prepareAcciones();
    prepareElementos();
  }
  public void prepareAcciones(){
    botonJuego.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          jugar();
        }
      }
    );
    botonRetorno.addActionListener(
      new ActionListener(){
        public void actionPerformed(ActionEvent e){
          menu();
        }
      }
    );
  }

//Metodos
  public void jugar(){
    //ModoDeJuego jug= new ModoDeJuego();
    //jug.setVisible(true);
  }
  public void menu(){
    POOBuildinGUI men= new POOBuildinGUI();
    men.setVisible(true);
  }

  public void prepareElementos(){
    Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screen.width/2,screen.height/2);
    Font fuente = new Font("Tahoma", Font.BOLD, 25);
    ImageIcon imover= new ImageIcon("imagenes/imagenmover.jpg");
    ImageIcon ievitar = new ImageIcon("imagenes/imagenevitar.jpg");
    ImageIcon irecoger = new ImageIcon("imagenes/imagenrecoger.jpg");
    ImageIcon iarreglar = new ImageIcon("imagenes/imagenarreglar.jpg");
    instruc = new JLabel("Repare todas las ventanas que Ralph rompa, la persona que tenga la mayor cantidad de ventanas reparadas al terminar el edificio gana.");

    instruc.setLayout(new GridLayout(2,2,10,10));
    instruc.setBackground(Color.BLACK);
    instruc.setFont(fuente);
    instruc.setForeground(Color.WHITE);

    mover = new JLabel("Pulse las siguientes teclas para mover el heroe",imover, JLabel.EAST);
    mover.setLayout(new GridLayout(2,2,10,10));
    mover.setBackground(Color.BLACK);
    mover.setFont(fuente);
    mover.setForeground(Color.WHITE);

    evitar = new JLabel("Evite los siguientes obstaculos",ievitar, JLabel.WEST);
    evitar.setLayout(new GridLayout(2,2,10,10));
    evitar.setBackground(Color.BLACK);
    evitar.setFont(fuente);
    evitar.setForeground(Color.WHITE);

    arreglar = new JLabel("Tiene que arreglar las siguientes ventanas",iarreglar, JLabel.SOUTH);
    arreglar.setLayout(new GridLayout(2,2,10,10));
    arreglar.setBackground(Color.BLACK);
    arreglar.setFont(fuente);
    arreglar.setForeground(Color.WHITE);


    recoger = new JLabel("En lo posible trate de tomar los siguientes obstaculos",ievitar, JLabel.WEST);
    recoger.setLayout(new GridLayout(2,2,10,10));
    recoger.setBackground(Color.BLACK);
    recoger.setFont(fuente);
    recoger.setForeground(Color.WHITE);


    botonJuego = new JButton("Jugar");
    botonJuego.setBackground(Color.BLACK);
    botonJuego.setFont(fuente);
    botonJuego.setForeground(Color.WHITE);

    botonRetorno = new JButton("Volver al menu");
    botonRetorno.setBackground(Color.BLACK);
    botonRetorno.setFont(fuente);
    botonRetorno.setForeground(Color.WHITE);

    panelInstrucciones.add(instruc);
    panelInstrucciones.add(mover);
    panelInstrucciones.add(evitar);
    panelInstrucciones.add(arreglar);
    panelInstrucciones.add(recoger);
    panelInstrucciones.add(botonJuego);
    panelInstrucciones.add(botonInstrucciones);
}
