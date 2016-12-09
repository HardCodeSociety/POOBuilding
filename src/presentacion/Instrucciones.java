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
  private JPanel panelInstrucciones;
  private JPanel panelIntroduccion;
  private JFrame ventanaPrincipal;
//Botones
  private JButton botonJuego;
  private JButton botonRetorno;
  //JButton botonInstrucciones;

//Textos
  private JLabel logo;
  private JLabel instruc;
  private JLabel evitar;
  private JLabel recoger;
  private JLabel mover;
  private JLabel arreglar;

  public Instrucciones(JFrame owner){
    super(owner);
    ventanaPrincipal=owner;
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
     addWindowListener (
			     new WindowAdapter(){
				         public void windowClosing(WindowEvent e){
					              cerrarVentana();
				          }
			    }
		  );
  }

//Metodos
public void cerrarVentana(){
                setVisible(false);
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
                ventanaPrincipal.setVisible(true);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			}
	}
  public void jugar(){
		ModoDeJuego modoDeJuego=new ModoDeJuego(ventanaPrincipal);
		setVisible(false);
		modoDeJuego.setVisible(true);
	}
  public void menu(){
    setVisible(false);
    ventanaPrincipal.setVisible(true);
    dispose();  
}
  public void prepareElementos(){
    setTitle("INSTRUCCIONES");
		setSize(1366,710);
    setResizable(false);
    setLayout(new BorderLayout());
    panelIntroduccion=new JPanel();
    panelInstrucciones=new JPanel();
    panelIntroduccion.setLayout(new BorderLayout());
    panelIntroduccion.setBackground(Color.BLACK);
    elementosPanelIntroduccion();
    panelInstrucciones.setLayout(new GridLayout(4,2,10,10));
    panelInstrucciones.setBackground(Color.BLACK);
    elementosPanelInstrucciones();
    add(panelIntroduccion,BorderLayout.NORTH);
    add(panelInstrucciones,BorderLayout.CENTER);
  }
  private void elementosPanelIntroduccion(){
    File archivo= new File("font/FunSized.ttf");
    GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
		try{ 
        Font wreckFont = Font.createFont(Font.TRUETYPE_FONT,archivo);
        ge.registerFont(wreckFont);
		}catch(Exception e){}
    Font fuente = new Font("FunSized", Font.BOLD, 20);
    instruc = new JLabel("<html><body>Repare todas las ventanas que Ralph rompa, la persona que tenga la mayor cantidad de ventanas reparadas al terminar el edificio gana. </html></body>");
    instruc.setBackground(Color.BLACK);
    instruc.setFont(fuente);
    instruc.setForeground(Color.WHITE);
    instruc.setBorder(BorderFactory.createEmptyBorder(20,5,25,0));
    fuente = new Font("SEGA LOGO FONT",Font.TRUETYPE_FONT, 27);
    logo=new JLabel("INSTRUCCIONES");
		logo.setFont(fuente);
		logo.setForeground(Color.RED);
    logo.setBorder(BorderFactory.createEmptyBorder(30,520,0,0));
		panelIntroduccion.add(logo,BorderLayout.NORTH);
    panelIntroduccion.add(instruc,BorderLayout.CENTER);
  }
  private void  elementosPanelInstrucciones(){
    Font fuente = new Font("Cooper Black", Font.BOLD, 14);
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
    arreglar = new JLabel("<html><body>Presione la tecla espacio para reparar y para hacer caer a su rival del edificio</html></body>");
    //arreglar.setLayout(new GridLayout(2,2,10,10));
    ImageIcon iarreglar= new ImageIcon("imagenes/espacio.png");
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
    botonJuego = new JButton();
    ImageIcon icono=new ImageIcon("imagenes/jugar.png");
    botonJuego.setBorderPainted(false);
    botonJuego.setBackground(Color.BLACK);
    botonJuego.setIcon(icono);
    botonRetorno = new JButton();
    icono=new  ImageIcon("imagenes/volver.png");
    botonRetorno.setBorderPainted(false);
    botonRetorno.setBackground(Color.BLACK);
    botonRetorno.setIcon(icono);  
    panelInstrucciones.add(mover);
    panelInstrucciones.add(evitar);
    panelInstrucciones.add(arreglar);
    panelInstrucciones.add(recoger);
    panelInstrucciones.add(botonRetorno);
    panelInstrucciones.add(botonJuego);
  }
}
