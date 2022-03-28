
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTS;

import OBJS.ObjVar;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris
 */
public class Consultas {
    private ResultSet rs = null;
    private Statement s = null;
    BDConexion conexion = new BDConexion();
    private Connection connection = null;  
    private Calendar taday;

    public Consultas() {

    }
    
    
    public int obtenerCantidadVuelos(int codigo) {
        int cant = 0;
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select * From vuelo where '"+codigo+"' = vuelo.c_avion");
            while (rs.next()) {
                cant += 1;
            }
        } catch (Exception e) {
            
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return cant;
    }
    public int obtenerCantidadVuelosAL(String AL) {
        int cant = 0;
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select * From vuelo where '"+AL+"' = vuelo.aerolinea");
            while (rs.next()) {
                cant += 1;
            }
        } catch (Exception e) {
            
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return cant;
    }
    
    public int obtenerCodigo(String modelo) {
        int codigo = 0;
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select id from avion where '"+modelo+"' = modelo");
            while (rs.next()) {
                codigo = rs.getInt("id");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        return codigo;
    }
    
    public String[] cargarAviones(){
        ArrayList<String> aviones = new ArrayList();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select modelo from avion");
            while (rs.next()) {
                aviones.add(rs.getString("modelo"));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        String[] avs = new String[aviones.size()];
        for (int i = 0; i < aviones.size(); i++) {
            String avion = aviones.get(i);
            avs[i]= avion;
        }
        return avs;
        
        
    }
    public ArrayList<String[]> obtenerTripulacionAL(String AL){
        ArrayList<String[]> Tripulacion = new ArrayList();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT tr.nombre as nombre, tr.trabaja_aerolinea as aerolinea, tr.rol_tripulacion as rol, tr.id_vuelo as id_vuelo " +
                                "FROM vuelo v, tripulacion tr "
                                + "WHERE CAST(tr.id_vuelo as integer) = v.id_vuelo AND tr.trabaja_aerolinea = '"+AL+"' AND tr.rol_tripulacion = 'Servicio al cliente'");
            while (rs.next()) {
                String[] row = {rs.getString("nombre"), rs.getString("aerolinea"), rs.getString("rol"), rs.getString("id_vuelo")};
                Tripulacion.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return Tripulacion;
       
            }
    public ArrayList<String[]> buscarTripulantes(){
        ArrayList<String[]> Tripulacion = new ArrayList();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT tr.nombre as nombre, tr.f_nacimiento as f_nacimiento FROM tripulacion tr");
            while (rs.next()) {
                Date date, todaydate;
                todaydate = new Date();
                date =new SimpleDateFormat("dd/MM/yyyy").parse(rs.getString("f_nacimiento")); 
                long msDiff = todaydate.getTime() - date.getTime() ;
                long year = (long) 3.156e+10;
                String[] row = {rs.getString("nombre"), String.valueOf(msDiff /year)};
                Tripulacion.add(row);
            } 
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }

        return Tripulacion;


    }
        
    
    public ArrayList<String[]> obtenerPilotos(){
        ArrayList<String[]> Tripulacion = new ArrayList();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT tr.nombre as nombre, tr.trabaja_aerolinea as aerolinea, av.modelo as modelo, pr.estado as estado_puerta FROM vuelo v, tripulacion tr, avion av, puerta pr " +
            "WHERE CAST(tr.id_vuelo as integer) = v.id_vuelo AND v.c_avion = av.id AND v.p_abordaje = num_puerta AND tr.rol_tripulacion = 'Piloto'");
            while (rs.next()) {
                String[] row = {rs.getString("nombre"), rs.getString("aerolinea"), rs.getString("modelo"), rs.getString("estado_puerta")};
                Tripulacion.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return Tripulacion;
        
        
    }
    public ArrayList<String[]> obtenerPistas(){
        ArrayList<String[]> Pistas = new ArrayList();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT v.id_vuelo as id_vuelo, v.a_salida as aeropuertoS, pt.num_pista as num_pista, pt.estado as estado FROM vuelo v, pista pt WHERE v.a_salida = 'aero_Panama' and pt.estado = 'Disponible' and v.pista = pt.num_pista");
            while (rs.next()) {
                String[] row = {rs.getString("id_vuelo"), rs.getString("aeropuertoS"), rs.getString("num_pista"), rs.getString("estado")};
                Pistas.add(row);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        return Pistas;
        
        
    }
    public String[] cargarAerolineas(){
        ArrayList<String> aerolineas = new ArrayList();
        try {
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("Select nombre_aerolinea from aerolinea");
            while (rs.next()) {
                aerolineas.add(rs.getString("nombre_aerolinea"));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error de conexión", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        String[] avs = new String[aerolineas.size()];
        for (int i = 0; i < aerolineas.size(); i++) {
            String avion = aerolineas.get(i);
            avs[i]= avion;
        }
        return avs;
    }
        public ArrayList<ObjVar> Var(){   
        try{
            connection = conexion.Conexion();
            s = connection.createStatement();
            rs = s.executeQuery("SELECT distinct aa.nombre_aero AS aname, av.cantidad_pas AS avpas, ae.nombre_aerolinea AS aename FROM aeropuerto aa, avion av, aerolinea ae");           
            while(rs.next()){
                
                ObjVar.Var.add(new ObjVar(rs.getString("aname"),rs.getInt("avpas"),rs.getString("aename")));
                
            }
        }catch (Exception e){
            System.out.println("Error en el Query SQL: " + e);
        }
        
        return ObjVar.Var;        
       
    }
        
    }
