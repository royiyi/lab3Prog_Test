/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Definiendo las varibales necesarias para conectar con la base de datos con la
 * bDB COVEFAR
 *
 * @author Royer Marcelo Acuña Mercado
 */
public class VariablesConexion {

    public static String URL_BBDD = "jdbc:postgresql://localhost:5432/onlineStore";
    public static String DRIVER_BBDD = "org.postgresql.Driver";
    public static String USUARIO_BBDD = "postgres";
    public static String PASSWORD_BBDD = "royer123";

    //Objeto para realizar la conexion
    private Connection connection;

    public void inicioConexion() throws SQLException {
        try {
            Class.forName(DRIVER_BBDD);
            connection = DriverManager.getConnection(URL_BBDD, USUARIO_BBDD, PASSWORD_BBDD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //METODO PARA CERRAR LA CONEXION
    /*no podemos mantener la conexion ya que es un proceso que no esta siendo use and gasta memoria*/
    public void cerrarConexion() {
        if (connection != null) {

            try {
                //cerrando Conexion
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //get and set
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
