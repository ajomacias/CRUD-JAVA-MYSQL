package com.ander.Services;
import java.sql.*;

import com.ander.Database.Conexion;

public class CRUD {
    public static void obtenerMensajes(){
        try{
           Connection connecion = new Conexion().getClient(); 
           String sql = "SELECT * FROM mensajes";
           PreparedStatement ps = connecion.prepareStatement(sql);
           ResultSet res = ps.executeQuery();
           while(res.next()){
               System.out.printf("%d %s %s %s\n",
               res.getInt("id"),res.getString("mensaje"),
               res.getString("autor"),res.getString("fecha"));
           }

        }
        catch(SQLException err){
            System.err.println("Hubo un error al obtener");
            err.printStackTrace(System.out);
        }
    }
    public static void crearMensaje(String autor,String msj){
        String sql = "INSERT INTO mensajes(mensaje,autor) VALUES(?,?);";
        try{
            Connection coneccion = new Conexion().getClient();
            PreparedStatement ps = coneccion.prepareStatement(sql);
            ps.setString(1, msj);
            ps.setString(2, autor);
            ps.executeUpdate();
            System.out.println("Se inserto correctamente");
            coneccion.close();
            ps.close();
        }catch(SQLException err){
            System.err.println("Hubo un error al insertar el mensaje");
            err.printStackTrace(System.out);
        }  
    }

    public static void editarMensaje(int id, String autor, String msj){
        String sql = "INSERT INTO mensajes SET mensaje=?,autor=? WHERE id=?";
        try{
            Connection coneccion = new Conexion().getClient();
            PreparedStatement ps = coneccion.prepareStatement(sql);
            ps.setString(1, msj);
            ps.setString(2, autor);
            ps.setInt(3, id);
            ps.executeUpdate();
            System.out.println("Se edito correctamente");
            coneccion.close();
            ps.close();
        }catch(SQLException err){
            System.out.println("Hubo un error al intentar editar");
            err.printStackTrace(System.out);
        }
    }

    public static void eliminarMensajePorId(int id){
        String sql = "DELETE FROM mensajes WHERE id=?;";
        try{
            Connection coneccion = new Conexion().getClient();
            PreparedStatement ps = coneccion.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("Se elimino el mensaje correctamente");
            coneccion.close();
            ps.close();

        }catch(SQLException err){
            System.out.println("Ocurrio un error al eliminar el mensaje");
            err.printStackTrace(System.out);
        }
    }
}