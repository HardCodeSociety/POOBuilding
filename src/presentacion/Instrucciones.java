package  presentacion;
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
  //JButton botonInstrucciones;

//Textos
  JLabel instruc;
  JLabel evitar;
  JLabel recoger;
  JLabel mover;
  JLabel arreglar;

  public Instrucciones(JFrame owner){
    super(owner);
    prepareElementos();
    prepareAcciones();
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
    //ModoDeJuego jug= new ModoDeJuego(super);
    //jug.setVisible(true);
  }
  public void menu(){
    POOBuildinGUI men= new POOBuildinGUI();
    men.setVisible(true);
  }

  public void prepareElementos(){
    setTitle("INSTRUCCIONES");
		setSize(1366,710);
    setResizable(false);
    panelInstrucciones=new JPanel();
    panelInstrucciones.setLayout(new GridLayout(4,1,10,10));
    panelInstrucciones.setBackground(Color.BLACK);
    Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
    setSize(screen.width/2,screen.height/2);
    Font fuente = new Font("Cooper Black", Font.BOLD, 14);
    instruc = new JLabel("<html><body>Repare todas las ventanas que Ralph rompa, la persona que tenga la mayor cantidad de <br> ventanas reparadas al terminar el edificio gana. </html></body>");
    instruc.setBackground(Color.BLACK);
    instruc.setFont(fuente);
    instruc.setForeground(Color.WHITE);
    mover = new JLabel("<html><body>Pulse las siguientes teclas <br> para mover el heroe</html></body>");
    //mover.setLayout(new GridLayout(2,2,10,10));
    ImageIcon imover =new ImageIcon("imagenes/imagenmover.png");
    mover.setBackground(Color.BLACK);
    mover.setFont(fuente);
    mover.setForeground(Color.WHITE);
    mover.setIcon(imover);
    mover.setIcon(new ImageIcon(imover.getImage().getScaledInstance(400,200,Image.SCALE_SMOOTH)));
    evitar = new JLabel("<html><body>Evite los siguientes obstaculos</html></body>");
    //evitar.setLayout(new GridLayout(2,2,10,10));
    ImageIcon ievitar=new ImageIcon("imagenes/evitar.png");
    evitar.setBackground(Color.BLACK);
    evitar.setFont(fuente);
    evitar.setIcon(ievitar);
    evitar.setForeground(Color.WHITE);
    evitar.setIcon(new ImageIcon(ievitar.getImage().getScaledInstance(400,200,Image.SCALE_SMOOTH)));
    arreglar = new JLabel("<html><body>Tiene que arreglar las<br> siguientes ventanas</html></body>");
    //arreglar.setLayout(new GridLayout(2,2,10,10));
    ImageIcon iarreglar= new ImageIcon("imagenes/ventana.png");
    arreglar.setBackground(Color.BLACK);
    arreglar.setFont(fuente);
    arreglar.setForeground(Color.WHITE);
    arreglar.setIcon(iarreglar);
    recoger = new JLabel("<html><body>En lo posible trate de tomar<br> los siguientes obstaculos</html></body>");
    arreglar.setIcon(new ImageIcon(iarreglar.getImage().getScaledInstance(400,200,Image.SCALE_SMOOTH)));
    //recoger.setLayout(new GridLayout(2,2,10,10));
    ImageIcon irecoger=new ImageIcon("imagenes/recoger.png");
    recoger.setIcon(irecoger);
    recoger.setBackground(Color.BLACK);
    recoger.setFont(fuente);
    recoger.setForeground(Color.WHITE);
    recoger.setIcon(new ImageIcon(irecoger.getImage().getScaledInstance(400,200,Image.SCALE_SMOOTH)));
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
    panelInstrucciones.add(botonRetorno);
    add(panelInstrucciones);
  }
}
