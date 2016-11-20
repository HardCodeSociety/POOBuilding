package presentacion;

import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Thread;
import java.io.*;
import java.util.*;
import java.lang.*;
public class ModoDeJuego extends JDialog{
    private JPanel botones;
    private JButton unoVsUno;
    private JButton maquinaVsMaquina;
    private JButton unoVsMaquina;
    private JButton volver;
    private JPanel panelVolver;
    private JFrame principal;
    public ModoDeJuego(JFrame owner){
        super(owner);
        principal=owner;
        prepareElementos();
        prepareAcciones();
    }
    public void prepareElementos(){
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen.width/2,2*screen.height/3);
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);
        botones=new JPanel();
		botones.setLayout(new  GridLayout(4,1,20,20));
        botones.setBackground(Color.BLACK);
        botones.setBorder(BorderFactory.createEmptyBorder(20,100,-130,-50));
        elementosPanelBotones();
        panelVolver=new JPanel();
        panelVolver.setBackground(Color.BLACK);
        panelVolver.setBorder(BorderFactory.createEmptyBorder(400,100,0,30));
        elementosPanelVolver();
        add(botones,BorderLayout.CENTER);
        add(panelVolver,BorderLayout.EAST);
    }
    public void prepareAcciones(){
        addWindowListener (
			new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					cerrarVentana();
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
        unoVsUno.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    elegirJugador(1);    
                }
            }
        );
    }
    public void cerrarVentana(){
			if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
                setVisible(false);
                principal.setVisible(true);
                setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}else{
				setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			}
	}
    public void cerrar(){
        if(JOptionPane.showConfirmDialog(null, "Estas seguro?")== JOptionPane.OK_OPTION){
            setVisible(false);
            principal.setVisible(true);
            dispose();
        }
    }
    public void elegirJugador(int modo){
        ElegirJugador elegir=new ElegirJugador(modo);
        setVisible(false);
        elegir.setVisible(true);
    }
    public void elementosPanelBotones(){
        unoVsUno=new JButton();
        unoVsUno.setBorderPainted(false);
        maquinaVsMaquina=new JButton();
        maquinaVsMaquina.setBorderPainted(false);
        unoVsMaquina=new JButton(); 
        unoVsMaquina.setBorderPainted(false);
        unoVsUno.setBackground(Color.BLACK);
        maquinaVsMaquina.setBackground(Color.BLACK);
        unoVsMaquina.setBackground(Color.BLACK);
        ImageIcon icono=new ImageIcon("imagenes/1vsM.png");
        unoVsMaquina.setIcon(icono);
        icono=new ImageIcon("imagenes/1vs1.png");
        unoVsUno.setIcon(icono);
        icono=new ImageIcon("imagenes/MvsM.png");
        maquinaVsMaquina.setIcon(icono);
        botones.add(unoVsUno);
        botones.add(unoVsMaquina);
        botones.add(maquinaVsMaquina);
        
    }
    public void elementosPanelVolver(){
        volver=new JButton();
        ImageIcon icono=new  ImageIcon("imagenes/volver.png");
        volver.setBorderPainted(false);
        volver.setBackground(Color.BLACK);
        volver.setIcon(icono);
        panelVolver.add(volver);
    }
    
}