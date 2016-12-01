package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.border.*;
public class ElegirJugador extends JDialog{
    private JFrame principal;
    private JPanel panelImagenes;
    private JPanel panelNombres;
    private JPanel panelMaquina;
    private JPanel panelOpciones;
    private JPanel panelJugar;
    private int tipoDeJuego;
    //Elementos panelImagenes
    private JButton jugador1;
    private JButton jugador2;
    //Elementos panelNombres
    private JLabel indicador1;
    private JLabel indicador2;
    private JTextField cambiarJugador1;
    private JTextField cambiarJugador2;
    private String nombre1="Jugador 1";
    private String nombre2="Jugador 2";
    //Elementos panelMaquina
    private JRadioButton candy;
    private JRadioButton calhoun;
    private JRadioButton candy2;
    private JRadioButton calhoun2;
    private ButtonGroup maquinas;
    private ButtonGroup maquinas2;
    private JColorChooser cambiarColor;
    private Color color1=Color.RED;
    private Color color2=Color.BLUE;
    //Elementos panelOpciones
    private JButton jugar;
    private JButton volver;
    public ElegirJugador(JFrame owner,int tipoDeJuego){
        super(owner);
        principal=owner;
        this.tipoDeJuego=tipoDeJuego;
        prepareElementos();
        prepareAcciones();
    }

    public void prepareElementos(){
        setTitle("CONFIGURACION DE JUGADORES");
		setSize(1366,710);
        setResizable(false);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        panelImagenes=new JPanel();
        panelImagenes.setSize(200,400); 
        panelImagenes.setLayout(new GridLayout(1,3,200,7));
        panelImagenes.setBackground(Color.BLACK);
        panelImagenes.setBorder(new CompoundBorder(BorderFactory.createEmptyBorder(100,200,30,200),(new TitledBorder("Colores"))));
        panelImagenes.setForeground(Color.RED);
        elementosPanelImagenes();
        panelNombres=new JPanel();
        panelNombres.setBackground(Color.BLACK);
        panelNombres.setLayout(new GridLayout(1,4,40,7));
        panelNombres.setBorder(BorderFactory.createEmptyBorder(70,30,0,30));
        elementosPanelNombres();
        panelOpciones=new JPanel();
        panelOpciones.setLayout(new GridLayout(1,2,20,7));
        panelOpciones.setBackground(Color.BLACK);
        elementosPanelOpciones();
        add(panelNombres,BorderLayout.NORTH);
        add(panelImagenes,BorderLayout.CENTER);
        add(panelOpciones,BorderLayout.SOUTH);
    }
    public void elementosPanelNombres(){
        indicador1=new JLabel("Nombre Jugador 1");
        indicador2=new JLabel("Nombre Jugador 2");
        indicador1.setForeground(Color.WHITE);
        indicador2.setForeground(Color.WHITE);
        indicador1.setBackground(Color.BLACK);
        indicador2.setBackground(Color.BLACK);
        cambiarJugador1=new JTextField(20);
        cambiarJugador1.setText("Nombre del jugador");
        cambiarJugador2=new JTextField(20);
        cambiarJugador2.setText("Nombre del jugador");
        panelNombres.add(indicador1);
        panelNombres.add(cambiarJugador1);
        panelNombres.add(indicador2);
        panelNombres.add(cambiarJugador2);
    }
    public void elementosPanelMaquina(){
        panelMaquina=new JPanel();
        panelMaquina.setBorder(BorderFactory.createEmptyBorder(0,300,300,0));
        panelMaquina.setLayout(new GridLayout(2,1,10,6));
        panelMaquina.setBackground(Color.BLACK);
        candy=new JRadioButton("CANDY");
        candy.setBackground(Color.BLACK);
        candy.setForeground(Color.WHITE);
        calhoun=new JRadioButton("CALHOUN"); 
        calhoun.setBackground(Color.BLACK);
        calhoun.setForeground(Color.WHITE);       
        if(tipoDeJuego==2){
            panelMaquina.add(candy);
            panelMaquina.add(calhoun);
        }
    }
    public void elementosPanelImagenes(){
        ImageIcon icono=new ImageIcon("imagenes/felix.png");
        maquinas=new ButtonGroup();
        jugador1=new JButton();
        jugador1.setIcon(icono);
        jugador1.setBackground(color1);
        jugador1.setBorderPainted(false);
        jugador2=new JButton();
        jugador2.setIcon(icono);
        jugador2.setBackground(color2);
        jugador2.setBorderPainted(false);
        panelImagenes.add(jugador1);
        panelImagenes.add(jugador2);
    }
    public void elementosPanelJugar(){
        panelJugar=new JPanel();
        panelJugar.setLayout(new GridLayout(1,2,20,7));
        panelJugar.setBackground(Color.BLACK);
        panelJugar.setBorder(BorderFactory.createEmptyBorder(200,200,0,0));
        jugar=new JButton();
        volver=new JButton();
        ImageIcon icono=new  ImageIcon("imagenes/volver.png");
        volver.setBorderPainted(false);
        volver.setBackground(Color.BLACK);
        volver.setIcon(icono);
        icono=new ImageIcon("imagenes/jugar.png");
        jugar.setBorderPainted(false);
        jugar.setBackground(Color.BLACK);
        jugar.setIcon(icono);
        panelJugar.add(volver);
        panelJugar.add(jugar);
    }
    public void elementosPanelOpciones(){
        elementosPanelMaquina();
        elementosPanelJugar();
        panelOpciones.add(panelMaquina);
        panelOpciones.add(panelJugar);
    }

    public void prepareAcciones(){
        addWindowListener (
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					cerrarVentana();
				}
			}
		);

        jugador1.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirColor(1);
                }
            }
        );
        jugador2.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirColor(2);
                }
            }
        );
         volver.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                cerrar();
                }
            }
        );
        jugar.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    jugar();
                }
            }
        );
        
    }
    public void cerrarVentana(){
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
    public void cerrar(){
        ModoDeJuego modoDeJuego=new ModoDeJuego(principal);
        setVisible(false);
		modoDeJuego.setVisible(true);
            dispose();
    }
    public void elegirColor(int jugador){
        cambiarColor=new JColorChooser();
        Color color=cambiarColor.showDialog(null,"Seleccione un color",Color.GRAY);
        if(color!=null){
                if(jugador==1){
                    if ((!color.equals(color2))){
                        jugador1.setBackground(color);
                        color1=color;
                    }else{
                      JOptionPane.showMessageDialog(null, "El jugador 2 ya esta usando ese color");
                    }
                }else if(jugador==2){
                    if((!color.equals(color1))){
                        jugador2.setBackground(color);
                        color2=color;
                    }else{
                      JOptionPane.showMessageDialog(null, "El jugador 1 ya esta usando ese color");
                    }
                }
        }
    }
    private void jugar(){
       nombre1= cambiarJugador1.getText();
       nombre2=cambiarJugador2.getText();
       String tipoDeMaquina=null;
       if (nombre1.equals("")||nombre2.equals("")){
            JOptionPane.showMessageDialog(null,"Debe definir el nombre de los jugadores");    
       }else{
           
           if (tipoDeJuego==2){
               if (!candy.isSelected()&&!calhoun.isSelected())
                    JOptionPane.showMessageDialog(null,"Debe definir el tipo de la maquina");
               else{
                   if(candy.isSelected()){
                       tipoDeMaquina="candy";
                   }else{
                       tipoDeMaquina="calhoun";
                   }
                    pantallaDeJuego(tipoDeMaquina);    
               }
           }else{
               pantallaDeJuego(tipoDeMaquina);
           }
       }
    }
    private void pantallaDeJuego(String tipoDeMaquina){
         ArrayList<String> nombres=new ArrayList<String>();
         ArrayList<Color> colores=new ArrayList<Color>();
         nombres.add(nombre1);
         nombres.add(nombre2);
         colores.add(color1);
         colores.add(color2);
         nombres.add(tipoDeMaquina);
         PantallaJuego pantalla=new PantallaJuego(principal,tipoDeJuego,nombres,colores);
		 setVisible(false);
		 pantalla.setVisible(true);
    }
}