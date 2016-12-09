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
	//Ventanas Externas;
	private ModoDeJuego modoDeJuego;
	private Instrucciones instrucciones;
	//Menu Principal
	private JPanel panelLogo;
	private JPanel panelOpciones;

	//Elementos del panel logo
	private JLabel logo;
	//Elementos del panel de opciones
	private JButton botonJugar;
	private JButton botonAbrir;
	private JButton botonInstrucciones;
	private JButton botonImportar;
	private JButton botonSalir;
	//Otras opciones
	private JFileChooser abrirArchivo;
	private JFileChooser importarArchivo;

	/**
	 * Creador JFrame POOBuildinGU
	 **/
	public POOBuildinGUI(){
		prepareElementos();
		prepareAcciones();
		//partida = new Partida();
		//inicie();
	}
	public void importar(){
		importarArchivo= new JFileChooser();
		int desicion = importarArchivo.showOpenDialog(this);
		if (desicion == JFileChooser.APPROVE_OPTION) {
            File file = importarArchivo.getSelectedFile();
            JOptionPane.showMessageDialog(null,"importar esta en construccion. El archivo seleccionado es:  "+file.getName() );
		}
	}

	public void abrir(){
		abrirArchivo= new JFileChooser();
		int desicion = abrirArchivo.showOpenDialog(this);
		if (desicion == JFileChooser.APPROVE_OPTION) {
						File file = abrirArchivo.getSelectedFile();
						JOptionPane.showMessageDialog(null,"Abrir esta en construccion. El archivo seleccionado es:  "+file.getName() );
		}
	}
	public void instrucciones(){
		instrucciones = new Instrucciones(this);
		setVisible(false);
		instrucciones.setVisible(true);
	}

	public void prepareElementos(){
		File archivo= new File("font/Sega-Logo-Font.ttf");
        GraphicsEnvironment ge =GraphicsEnvironment.getLocalGraphicsEnvironment();
		try{ 
        Font wreckFont = Font.createFont(Font.TRUETYPE_FONT,archivo);
        ge.registerFont(wreckFont);
		}catch(Exception e){}
		//String[] fontNames=ge.getAvailableFontFamilyNames();
		//System.out.println(Arrays.toString(fontNames));
		setTitle("MENU PRINCIPAL");
		setSize(1366,710);
        setResizable(false);
		setLayout(new BorderLayout());
		panelLogo = new JPanel();
		panelLogo.setLayout(new GridLayout(1,1,7,7));
		panelLogo.setBackground(Color.BLACK);
		panelLogo.setBorder(BorderFactory.createEmptyBorder(30,520,10,320));
		elementosPanelLogo();
		panelOpciones = new JPanel();
		panelOpciones.setLayout(new GridLayout(5,1,7,7));
		panelOpciones.setBackground(Color.BLACK);
		panelOpciones.setBorder(BorderFactory.createEmptyBorder(10,320,10,320));
		elementosPanelBotones();
		add(panelLogo,BorderLayout.NORTH);
		add(panelOpciones,BorderLayout.CENTER);
	}
	public void prepareAcciones(){
		addWindowListener (
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					cerrarVentana();
				}
			}
		);
		botonJugar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					jugar();
				}
			}
		);
		botonSalir.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					cerrar();
				}
			}
		);
		botonInstrucciones.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					instrucciones();
				}
			}
		);
		botonAbrir.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						abrir();
				}
			}
		);
		botonImportar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){
						importar();
				}
			}
		);
	}
	public void jugar(){
		modoDeJuego=new ModoDeJuego(this);
		setVisible(false);
		modoDeJuego.setVisible(true);
	}
	public void cerrar(){
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
							System.exit(0);
			}
	}
	public void cerrarVentana(){
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
							setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
	}
	public void elementosPanelBotones(){
		Font fuente = new Font("SEGA LOGO FONT",Font.TRUETYPE_FONT, 25);
		botonJugar=new JButton("JUGAR");
		botonJugar.setBorderPainted(false);
		botonJugar.setBackground(Color.BLACK);
    	botonJugar.setFont(fuente);
		botonJugar.setForeground(Color.RED);
		botonAbrir=new JButton("ABRIR");
		botonAbrir.setBorderPainted(false);
		botonAbrir.setBackground(Color.BLACK);
    	botonAbrir.setFont(fuente);
		botonAbrir.setForeground(Color.RED);
		botonInstrucciones=new JButton("INSTRUCCIONES");
		botonInstrucciones.setBorderPainted(false);
		botonInstrucciones.setBackground(Color.BLACK);
    botonInstrucciones.setFont(fuente);
		botonInstrucciones.setForeground(Color.RED);
		botonImportar=new JButton("IMPORTAR");
		botonImportar.setBorderPainted(false);
		botonImportar.setBackground(Color.BLACK);
    botonImportar.setFont(fuente);
		botonImportar.setForeground(Color.RED);
		botonSalir=new JButton("SALIR");
		botonSalir.setBorderPainted(false);
		botonSalir.setBackground(Color.BLACK);
		botonSalir.setFont(fuente);
		botonSalir.setForeground(Color.RED);
		panelOpciones.add(botonJugar);
		panelOpciones.add(botonAbrir);
		panelOpciones.add(botonImportar);
		panelOpciones.add(botonInstrucciones);
		panelOpciones.add(botonSalir);
	}
	public void elementosPanelLogo(){
		logo=new JLabel();
		ImageIcon icono=new ImageIcon("imagenes/icono.png");
		logo.setBackground(Color.BLACK);
		logo.setIcon(icono);
		panelLogo.add(logo);
	}
	public static void main(String[] args){
		POOBuildinGUI edificio = new POOBuildinGUI();
		edificio.setVisible(true);
	}



}
