/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import Entidades.Jugador;
import dao.Jugadores;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class Interfaces_2 extends JFrame{
    
    public static int Ancho = 130, ALto= 30;
    
    private static Interfaces_2 menu;
    
    public JPanel panel;
    
    public JLabel titulo_Menu, imagen_de_prueba;
    public JLabel[] info_jugadores;
    
    public JButton boton_aceptar;
    
    private static int step = 20,izquierda=37,arriba = 38,derecha=39,abajo=40;
    
    public Interfaces_2(String titulo) throws SQLException{
        super(titulo);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //labels_y_botones();
        Container cp = getContentPane();//Donde almacenara todas las cosas que tendra la ventana
        //cp.add(titulo_Menu);
        //cp.add(boton_aceptar);
        //cp.add(imagen_de_prueba);
        //setLocationRelativeTo(null);
        //this.addKeyListener(this);
        
        Jugadores jugadoresLol = new Jugadores();//Lista obtenida de la base de datos a travez de xammp utilizando MySQL
         ArrayList<Jugador> jugadores = jugadoresLol.getJugadores();//Lista de jugadores con ls datos obtenidos de MySQL
         //GridLayout experimento = new GridLayout(jugadores.size(),4,3,2);
         info_jugadores = new JLabel[jugadores.size()];//Lista de labels para poder poner la info en la interfaz
         for(int i =0; i< jugadores.size(); i++){
             //cp.setLayout(experimento);
             info_jugadores[i] = new JLabel(jugadores.get(i).getId()+"\t"+jugadores.get(i).getUsuario()+" \t "+jugadores.get(i).getScore()+" \t "+jugadores.get(i).getTime());
             info_jugadores[i].setBounds(10, (i * 30) + 10, 500, 200);
             cp.add(info_jugadores[i]);
         }
         
        setSize(600,600);
        
    }
    
    public static Interfaces_2 getInstance() throws Exception{
        if(menu == null){
            menu = new Interfaces_2("Menu");
        } else{
            System.out.println("No se puede crear otro objeto Menu porque ya existe");
        }
        return menu;
    }
    
    public void labels_y_botones(){
        boton_aceptar = new JButton("Aceptar");
        titulo_Menu = new JLabel("MENU");
        imagen_de_prueba = new JLabel();
        titulo_Menu.setBounds(100, 0, Ancho, ALto);
        boton_aceptar.setBounds(0, 0, Ancho, ALto);
        imagen_de_prueba.setIcon(new ImageIcon(getClass().getResource("Mariodance.gif")));
        imagen_de_prueba.setBounds(40, 40, 250, 348);
        
    }
    
    
    
    
}
