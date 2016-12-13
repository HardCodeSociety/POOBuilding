package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;

public class ElegirColor extends JDialog{
    private JPanel panelBotones;
    private JPanel panelOpciones;
    private JButton color1;
    private JButton color2;
    private JButton color3;
    private JButton color4;
    private JButton color5;
    private JButton color6;
    private JButton cancelar;
    private JButton aceptar;
    private Boolean esperar=true;
    private Color elegido=null;
    private ElegirJugador principal;
    private int jugador;

    public ElegirColor(ElegirJugador principal,int jugador){
        prepareElementos();
        prepareAcciones();
        setVisible(true);
        this.principal=principal;
        this.jugador=jugador;
    }
    public Color elegirPersonaje(){
        return elegido;
    }
    public void prepareElementos(){
        setTitle("COLOR JUGADOR");
        panelBotones=new JPanel();
        panelBotones.setLayout(new GridLayout(1,5,10,10));
        panelBotones.setBackground(Color.BLACK);
        panelOpciones=new JPanel();
        panelOpciones.setLayout(new GridLayout(1,2,10,10));
        panelOpciones.setBackground(Color.BLACK);
        setSize(666,310);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        elementosPanelBotones();
        elementosPanelOpciones();
        add(panelBotones,BorderLayout.CENTER);
        add(panelOpciones,BorderLayout.SOUTH);
    }
    private void elementosPanelBotones(){
        color1=new JButton();
        color1.setBorderPainted(false);
        color1.setBackground(Color.BLACK);
        color1.setIcon(new ImageIcon("imagenes/felix/felixAmarillo/1.png"));
        color2=new JButton();
        color2.setBorderPainted(false);
        color2.setBackground(Color.BLACK);
        color2.setIcon(new ImageIcon("imagenes/felix/felixAzul/1.png"));
        color3=new JButton();
        color3.setBorderPainted(false);
        color3.setBackground(Color.BLACK);
        color3.setIcon(new ImageIcon("imagenes/felix/felixMorado/1.png"));
        color4=new JButton();
        color4.setBorderPainted(false);
        color4.setBackground(Color.BLACK);
        color4.setIcon(new ImageIcon("imagenes/felix/felixNegro/1.png"));
        color5=new JButton();
        color5.setBorderPainted(false);
        color5.setBackground(Color.BLACK);
        color5.setIcon(new ImageIcon("imagenes/felix/felixRojo/1.png"));
        color6=new JButton();
        color6.setBorderPainted(false);
        color6.setBackground(Color.BLACK);
        color6.setIcon(new ImageIcon("imagenes/felix/felixVerde/1.png"));
        panelBotones.add(color1);
        panelBotones.add(color2);
        panelBotones.add(color3);
        panelBotones.add(color4);
        panelBotones.add(color5);
        panelBotones.add(color6);
    }
    private void elementosPanelOpciones(){
        cancelar=new JButton();
        cancelar.setBorderPainted(false);
        cancelar.setBackground(Color.BLACK);
        cancelar.setIcon(new ImageIcon("imagenes/cancelar.png"));
        aceptar=new JButton();
        aceptar.setBorderPainted(false);
        aceptar.setBackground(Color.BLACK);
        aceptar.setIcon(new ImageIcon("imagenes/aceptar.png"));
        panelOpciones.add(aceptar);
        panelOpciones.add(cancelar);
    }
    public void prepareAcciones(){
        addWindowListener (
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					cerrarVentana();
				}
			}
		);
        color1.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido=Color.YELLOW;
                }
            }
        );
         color2.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido=Color.BLUE;
                }
            }
        );
         color3.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido= new Color(127, 0, 255);
                }
            }
        );
         color4.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido=Color.BLACK;
                }
            }
        );
         color5.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido=Color.RED;
                }
            }
        );
         color6.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido=Color.GREEN;
                }
            }
        );
        aceptar.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    cerrar();
                }
            }
        );
        cancelar.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegido=null;
                    cerrar();
                }
            }
        );
    }
    public void cerrarVentana(){
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
    public void cerrar(){
        principal.setColor(elegido,jugador);
        dispose();
    }

}