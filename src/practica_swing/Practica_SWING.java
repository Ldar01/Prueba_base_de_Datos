/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica_swing;

import Entidades.Jugador;
import GUI.Interfaces_2;
import dao.Jugadores;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class Practica_SWING {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        // TODO code application logic here
        Interfaces_2 menu = Interfaces_2.getInstance();
        menu.setVisible(true);
    }

}
