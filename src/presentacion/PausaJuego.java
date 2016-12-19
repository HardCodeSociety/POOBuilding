package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;

public class PausaJuego extends JDialog{
    private JPanel panelBotones;
    private JPanel panelInformacion;
    private JButton guardar;
    private JButton salir;
    private JButton cancelar;
    private JButton menuPrincipal;
    private JDialog principal;
    private  String nombre1;
    private  String nombre2;
    private  Color color1;
    private  Color color2;
    public PausaJuego(JDialog owner, String nNombre1, String nNombre2, Color nColor1, Color nColor2){
        super(owner);
        principal=owner;
        nombre1 = nNombre1;
        nombre2 = nNombre2;
        color1 = nColor1;
        color2 = nColor2;
        prepareElementos();
        prepareAcciones();
    }
    public void prepareElementos(){
      setTitle("Menu de pausa");
      setResizable(false);
      setSize(1366,710);
      setLayout(new BorderLayout());
      panelBotones = new JPanel();
      panelBotones.setLayout(new GridLayout(5,1,7,7));
      panelBotones.setBackground(Color.BLACK);
      panelBotones.setBorder(BorderFactory.createEmptyBorder(10,320,10,320));
      panelInformacion = new JPanel();
      panelInformacion.setLayout(new GridLayout(5,3,100,0));
      panelInformacion.setBorder(BorderFactory.createEmptyBorder(0,200,0,200));
      preprareInformacion();
      prepareBotones();
      panelInformacion.setBackground(Color.BLACK);
      add(panelInformacion,BorderLayout.NORTH);
      add(panelBotones,BorderLayout.CENTER);

    }
    public void preprareInformacion(){
      Font fuente = new Font("SEGA LOGO FONventanaT",Font.TRUETYPE_FONT, 14);
      JLabel nombreJugador1=new JLabel(nombre1);
      JLabel nombreJugador2=new JLabel(nombre2);
      nombreJugador1.setFont(fuente);
      nombreJugador2.setFont(fuente);
      nombreJugador1.setForeground(color1);
      nombreJugador2.setForeground(color2);
      JProgressBar energia1=new JProgressBar(0,100);
      JProgressBar energia2=new JProgressBar(0,100);
      energia1.setValue(100);
      energia1.setOpaque(false);
      energia1.setForeground(color1);
      energia1.setStringPainted(true);
      energia2.setValue(100);
      energia2.setOpaque(false);
      energia2.setForeground(color2);
      energia2.setStringPainted(true);
      ImageIcon icono=new ImageIcon("imagenes/vidas.png");
      JLabel vidas1=new JLabel();
      JLabel vidas2=new JLabel();
      vidas1.setOpaque(true);
      vidas2.setOpaque(true);
      vidas1.setBackground(color1);
      vidas2.setBackground(color2);
      vidas1.setIcon(icono);
      vidas2.setIcon(icono);
      JLabel poderes1=new JLabel();
      JLabel poderes2=new JLabel();
      icono=new ImageIcon("imagenes/poderes.png");
      poderes1.setIcon(icono);
      poderes2.setIcon(icono);
      icono=new ImageIcon("imagenes/pausa.png");
      JTextField puntaje1=new JTextField("0");
      puntaje1.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      puntaje1.setEditable(false);
      puntaje1.setBackground(Color.BLACK);
      puntaje1.setForeground(color1);
      JTextField puntaje2=new JTextField("0");
      puntaje2.setBorder(BorderFactory.createEmptyBorder(0,0,5,0));
      puntaje2.setEditable(false);
      puntaje2.setBackground(Color.BLACK);
      puntaje2.setForeground(color2);
      panelInformacion.add(nombreJugador1);
      panelInformacion.add(nombreJugador2);
      panelInformacion.add(puntaje1);
      panelInformacion.add(puntaje2);
      panelInformacion.add(energia1);
      panelInformacion.add(energia2);
      panelInformacion.add(vidas1);
      panelInformacion.add(vidas2);
      panelInformacion.add(poderes1);
      panelInformacion.add(poderes2);
    }
    public void prepareAcciones(){
      addWindowListener (
        new WindowAdapter(){
          public void windowClosing(WindowEvent e){
            cerrarVentana();
          }
        }
      );
      guardar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            guardar();
          }
        }
      );
      addKeyListener(
           new KeyAdapter(){
              @Override
              public void keyPressed(KeyEvent e){
                  if (e.getKeyCode()==KeyEvent.VK_P){
                      cancelar();
                  }
              }
          }
      );
      salir.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            salir();
          }
        }
      );
      cancelar.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            cancelar();
          }
        }
      );
      menuPrincipal.addActionListener(
        new ActionListener(){
          public void actionPerformed(ActionEvent e){
            retornar();
          }
        }
      );
    }
    public void guardar(){
      JFileChooser chooser = new JFileChooser();
      int seleccion = chooser.showSaveDialog(this);
      if (seleccion == JFileChooser.APPROVE_OPTION) {
          File file = chooser.getSelectedFile();
          JOptionPane.showMessageDialog(null,"Guardar esta en construccion. El archivo seleccionado es:  "+file.getName() );
      }
    }
    public void cancelar(){
      setVisible(false);
    }
    public void retornar(){
      POOBuildinGUI.main(null);
    }
    public void salir(){
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
    public void prepareBotones(){
      Font fuente = new Font("SEGA LOGO FONT",Font.TRUETYPE_FONT, 25);
      guardar= new JButton("Guardar");
      guardar.setBorderPainted(false);
  		guardar.setBackground(Color.BLACK);
      guardar.setFont(fuente);
  		guardar.setForeground(Color.RED);
      cancelar = new JButton("cancelar");
      cancelar.setBorderPainted(false);
      cancelar.setBackground(Color.BLACK);
      cancelar.setFont(fuente);
      cancelar.setForeground(Color.RED);
      salir= new JButton("Salir del Juego");
      salir.setBorderPainted(false);
      salir.setBackground(Color.BLACK);
      salir.setFont(fuente);
      salir.setForeground(Color.RED);
      menuPrincipal = new JButton("Retornar al menu principal");
      menuPrincipal.setBorderPainted(false);
      menuPrincipal.setBackground(Color.BLACK);
      menuPrincipal.setFont(fuente);
      menuPrincipal.setForeground(Color.RED);
      panelBotones.add(guardar);
      panelBotones.add(cancelar);
      panelBotones.add(salir);
      panelBotones.add(menuPrincipal);
    }
}
