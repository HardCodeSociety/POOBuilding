package presentacion;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class POOBuildinGUI extends JFrame{
	//private Partida partida;
	
	//Menu Principal
	private JLabel logo;
	private JPanel panelOpciones;
	
	//Elementos del panel de opciones
	private JButton botonJugar;
	private JButton botonAbrir;
	private JButton botonInstrucciones;
	private JButton botonImportar;
	
	
	public POOBuildinGUI(){
		//prepareAcciones();
		prepareElementos();
		//partida = new Partida();
		//inicie();
	}
	//elementosPanelBotones(){}
	public void prepareElementos(){
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(3,3));
		logo = new JLabel();
		logo.setBorder(BorderFactory.createEmptyBorder(10,320,10,320));
		logo.setLayout(new GridLayout(1,4,7,7));
		ImageIcon icono=new ImageIcon("imagenes/icono.jpg");
		panelOpciones = new JPanel();
		//elementosPanelBotones();
		logo.setIcon(icono);
		logo.setBackground(Color.BLACK);
		add(logo,BorderLayout.NORTH);
		add(panelOpciones,BorderLayout.CENTER);
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen.width/2,screen.height/2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args){
		POOBuildinGUI edificio = new POOBuildinGUI();
		edificio.setVisible(true);
	}
	
	
	
}

