
import javax.swing.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class Interfaces{
    /**
         *  Acciones de cierre
         * - JFrame.EXIT_ON_CLOSE: Abandona la aplicacion
         * - JFrame.DISPOSE_ON_CLOSE: Libera los recursos asociados a la ventana
         * - JFrame.DO_NOTHING_ON_CLOSE: No hace nada
         * - JFrame.HIDE_ON_CLOSE: Cierra la ventana sin liberar los recursos
         *
         */
    public static void main(String[] args){
        JPanel p = new JPanel ();
        JFrame ventana = new JFrame("Ventana"); // Constructor de la ventana
        ventana.setSize(600,600);//Tamanio de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para cuando cierre la ventana ya no siga corriendo el programa
        ventana.setVisible(true);// Para que se vea la ventana
        
               
        
    }
    
}
