package GUI;

import Entidades.Jugador;
import dao.Jugadores;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import java.applet.AudioClip;

/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class Interfaces_2 extends JFrame {
    
    public static int Ancho = 130, ALto= 30;
    
    private static Interfaces_2 menu;
    
    public JPanel panel ;
    
    public JLabel imagen_de_prueba, resultados_Finales, lblId, lblnombre, lblpuntos,lbltiempo;
    public JLabel fondo;
        
    public JLabel[] id,nombre,score,tiempo;
    
    //public JButton boton_aceptar; No lo ocupare todavia
    /*
        Tipos de letra
    */
    Font tipo_letra_usuarios = new Font("Rockwell",3, 12); // Tipo de letra (nombre del tipo de letra, codigo si es negrita etc, tamanio)

    Font lbls = new Font("Rockwell", 1, 16);
    
    //Inicializando lo que tendra la interfaz de los resultados finales    
    public Interfaces_2(String titulo) throws SQLException{
        super(titulo);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                
        this.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
        
         Labels_para_Registros();
         Sonido();
         
         this.setLocation(350, 100);
         
         this.setResizable(false);

         
        setSize(600,600);
        
    }
    //Patron Singleton para evitar que hayan mas de una ventana
    public static Interfaces_2 getInstance() throws Exception{// Patron singleton
        if(menu == null){
            menu = new Interfaces_2("Resultados Finales");
        } else{
            System.out.println("No se puede crear otro objeto resultados finales porque ya existe");
        }
        return menu;
    }
    
    //Agregando los labels y los detalles que estos tendran
    public void Labels_para_Registros() throws SQLException{
        
        Container cp = getContentPane();//Donde almacenara todas las cosas que tendra la ventana
        
        resultados_Finales = new JLabel();
        ImageIcon resultados = new ImageIcon(getClass().getResource("result.png"));
        resultados_Finales.setIcon(resultados);
        resultados_Finales.setBounds(40, 10, 523, 51);
        
        //Inicializando los labels
        lblId = new JLabel("ID");
        lblnombre = new JLabel("Nombre");
        lblpuntos = new JLabel("Puntos");
        lbltiempo = new JLabel("Tiempo");
        
        //Poniendo tipo de letra
        lblId.setFont(lbls);
        lblnombre.setFont(lbls);
        lblpuntos.setFont(lbls);
        lbltiempo.setFont(lbls);
        
        //Ubicando los labels
        lblId.setBounds(10, 20, 200, 150);
        lblnombre.setBounds(80, 20, 200, 150);
        lblpuntos.setBounds(265, 20, 200, 150);
        lbltiempo.setBounds(390, 20, 200, 150);
        
        //Colocando color a las letras de los labels
        lblId.setForeground(Color.black);
        lblnombre.setForeground(Color.black);
        lblpuntos.setForeground(Color.black);
        lbltiempo.setForeground(Color.black);
        
        //Decode sirve para convertir una cadena y leerlo como hexadecimal
        
        //Agragando al contenedor
        cp.add(resultados_Finales);
        cp.add(lblId);
        cp.add(lblnombre);
        cp.add(lblpuntos);
        cp.add(lbltiempo);
        Jugadores jugadoresLol = new Jugadores();//Lista obtenida de la base de datos a travez de xammp utilizando MySQL
         ArrayList<Jugador> jugadores = jugadoresLol.getJugadores();//Lista de jugadores con ls datos obtenidos de MySQL
         
         //Lista de labels para poder poner la info en la interfaz
         id = new JLabel[jugadores.size()];
         nombre = new JLabel[jugadores.size()];
         score = new JLabel[jugadores.size()];
         tiempo = new JLabel[jugadores.size()];
         for(int i =0; i< jugadores.size(); i++){
             id[i] = new JLabel();
             score[i] = new JLabel();
             nombre[i] = new JLabel();
             tiempo[i]= new JLabel();
             
             id[i].setFont(tipo_letra_usuarios);
             nombre[i].setFont(tipo_letra_usuarios);
             score[i].setFont(tipo_letra_usuarios);
             tiempo[i].setFont(tipo_letra_usuarios);
             
             //Colocando colores a las letras
             id[i].setForeground(Color.LIGHT_GRAY);
             nombre[i].setForeground(Color.LIGHT_GRAY);
             score[i].setForeground(Color.LIGHT_GRAY);
             tiempo[i].setForeground(Color.LIGHT_GRAY);
             
             //Obteniendo los valores de la base de datos 
             id[i].setText(Integer.toString(jugadores.get(i).getId()));
             nombre[i].setText(jugadores.get(i).getUsuario());
             score[i].setText(Integer.toString(jugadores.get(i).getScore()));
             tiempo[i].setText(Float.toString(jugadores.get(i).getTime()));
             
             //Ubicacion de los datos
             id[i].setBounds(10, (i * 30) + 30, 500, 200);
             nombre[i].setBounds(80,(i * 30) + 30, 500, 200);
             score[i].setBounds(270,(i * 30) + 30, 500, 200);
             tiempo[i].setBounds(400,(i * 30) + 30, 500, 200);
             
             //Agregarlos al contenedor
            cp.add(id[i]);
            cp.add(nombre[i]);
            cp.add(score[i]);
            cp.add(tiempo[i]);
        }
         
        imagen_de_prueba = new JLabel();
        ImageIcon cool = new ImageIcon(getClass().getResource("cool_ghost.gif"));
        ImageIcon cool_ghost = new ImageIcon(cool.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        imagen_de_prueba.setIcon(cool_ghost);
        imagen_de_prueba.setBounds(450, 350, 200, 300);
        cp.add(imagen_de_prueba);
         
        fondo = new JLabel();
        ImageIcon fon1 =new ImageIcon(getClass().getResource("res3.jpg"));
        fondo.setIcon(fon1);
        fondo.setBounds(0, 0, 600, 600);
        cp.add(fondo);
        
        
        
    }
    
//    public void Eventos(){ //Despues se utilizara :v
//        boton_aceptar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Funciona LOL");
//            }
//        });
//    }   
    public void Sonido(){
        AudioClip audio,trueno;
        audio = Applet.newAudioClip(getClass().getResource("musica.wav"));
        trueno = Applet.newAudioClip(getClass().getResource("trueno.wav"));
        audio.loop();
        trueno.play();
    }

}
