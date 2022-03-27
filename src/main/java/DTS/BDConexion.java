/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTS;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author AAQ
 */
public class BDConexion {

    private Connection connection = null;

    public Connection Conexion() {
        String url = "jdbc:postgresql://localhost:5432/vuelosx";
        String password = "Postgres3620";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);
            if (connection != null) {
                System.out.println("Conectándo a la base de datos...");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            System.out.println("Problema conectándose a la base de datos.");
        }
        return connection;
    }
}
