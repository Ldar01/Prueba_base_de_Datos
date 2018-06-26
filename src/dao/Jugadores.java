/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Conexion.Conexion;
import Entidades.Jugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Luisa Arevalo <00038617@uca.edu.sv>
 */
public class Jugadores {
    //Nombres de las columnas y nombre de la tabla que esta en MySQL
    private String TABLE_NAME = "jugador";
    private String ID = "id";
    private String USUARIO = "usuario";
    private String SCORE = "score";
    private String TIEMPO = "tiempo";
    
    //Esta funcion regresa una lista de los jugadores que estan almacenados en MySQL
    public ArrayList<Jugador> getJugadores() throws SQLException {
        java.sql.Connection con = null; // Inicializando la conexion para SQL
        ArrayList<Jugador> jugadores = new ArrayList<>();//Inicializando la lista

        try {
            con = Conexion.conectar().getCnx();//Obtenemos la direccion de la base
            Statement statement = con.createStatement();//Creando una declaracion

            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE_NAME);//Comando de SQL para obtener los datos que estan en la base

            while (resultSet.next()) {// Mientras haya algo en la tabla guardada hara un bucle
                Jugador jugador = new Jugador();//Crea nuevo jugador
                jugador.setId(resultSet.getInt(ID));//Obtiene el id del jugador
                jugador.setUsuario(resultSet.getString(USUARIO));//Obtiene el nombre de usuario
                jugador.setScore(resultSet.getInt(SCORE));//Obtiene la puntuacion obtenida en el juego
                jugador.setTime(resultSet.getFloat(TIEMPO));//Obtiene el tiempo que realizo en el juego
                jugadores.add(jugador);//Lo agrega a la lista
            }
            resultSet.close();//Cierra el comando
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();//Si hubo problemas lo cierra para que la conxion no quede abierta
                } catch (SQLException e) {
                    e.printStackTrace();
                    }
                }
            }
        return jugadores;
    }
    
    public void InsertarJugador(Jugador jugador){
        java.sql.Connection con = null;
        try {
            con = Conexion.conectar().getCnx();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO " + TABLE_NAME +
                            "(" + USUARIO + "," + SCORE + "," + TIEMPO + ")"
                            + " VALUES(?,?,?)");
            preparedStatement.setString(1, jugador.getUsuario());
            preparedStatement.setInt(2, jugador.getScore());
            preparedStatement.setFloat(3, jugador.getTime());

            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
