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
    public ElegirColor(){
        prepareElementos();
        prepareAcciones();
    }
    public void prepareElementos(){
        panelBotones=new JPanel();
        panelBotones.setBackground(Color.BLACK);
        panelOpciones=new JPanel();
        setSize(666,310);
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        color1=new JButton();
        color2=new JButton();
        color3=new JButton();
        color4=new JButton();
        color5=new JButton();
        color6=new JButton();
        cancelar=new JButton();
        aceptar=new JButton();
        panelBotones.add(color1);
        panelBotones.add(color2);
        panelBotones.add(color3);
        panelBotones.add(color4);
        panelBotones.add(color5);
        panelBotones.add(color6);
        panelOpciones.add(cancelar);
        panelOpciones.add(aceptar);
        add(panelBotones,BorderLayout.CENTER);
        add(panelOpciones,BorderLayout.SOUTH);
    }
    public void prepareAcciones(){
   }
}