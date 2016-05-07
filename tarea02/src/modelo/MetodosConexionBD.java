/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author JorgeIgnacio
 */
public class MetodosConexionBD {
    
    //Referencias
    Connection con = null;
    public String arregloInformacion[];
    String nombre = "";
    String direccion = "";
            
    //Se declaran las variables
    
    //Constructor
    public MetodosConexionBD() {
                
        arregloInformacion = new String[2];
        
    }//Fin constructor
    
    /*
    Realiza la conexion con la base de datos
    */
    public void realizarConexion()
    {
        
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
        
    }//Fin realizarConexion
    
    /*
    Registra un estudiante en la base de datos
    */
    public boolean registrarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
                cmd = con.createStatement();
                ejecutar = cmd.execute("INSERT INTO estudiantes(cedula, nombre, direccion) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }//Fin registrarEmpleado
    
    /*
    Altualiza los datos de la base de datos o modifica un estudiante
    */
    public boolean actualizarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("UPDATE estudiantes SET nombre='"+arregloInformacion[1]+"',direccion='"+arregloInformacion[2]+"' WHERE cedula='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia " + e.getMessage());
            return false;
        }
        
    }//Fin actualizarEstudiante
    
    /*
    Elimina un estudiante de la base de datos
    */
    public boolean eliminarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("DELETE FROM `estudiantes` WHERE cedula='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia "+e.getMessage());
            return false;
        }
        
    }//Fin eliminarEstudiante
    
    /*
    Busca un estuddiante en la base de datos y guarda los valores un arreglo
    */
    public void consultarEstudiante(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre, direccion FROM estudiantes WHERE cedula = '"+arregloInformacion[0]+"'");
                
                while (rs.next()) 
                {
                    nombre = rs.getString("nombre");
                    direccion = rs.getString("direccion");
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD: "+nombre+" "+direccion);
                    
                    
                    //System.out.println(""+direccion);
                }
                rs.close();
                arregloInformacion[0] = " Aquí debería ir el nombre "+nombre;
                arregloInformacion[1] = "Aquí debería ir la dirección "+direccion;
                System.out.println("Método devolver arreglo "+arregloInformacion[0]+" "+arregloInformacion[1]);
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
       
        
    }//Fin consultarEmpleado

    /*
    Retorna el arreglo con la información del estudiante
    */
    public String[] devolverArreglo() {
        System.out.println("Método devolver arreglo "+arregloInformacion[0]+" "+arregloInformacion[1]);
        return this.arregloInformacion;
    }

    /*
    Registra un estudiante en la base de datos
     */
    public boolean registrarCurso(String arregloInformacion[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
            cmd = con.createStatement();
            ejecutar = cmd.execute("INSERT INTO cursos(sigla, nombre, creditos, horario) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"','"+arregloInformacion[3]+"')");
            
            return true;
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    } //Fin registrarEmpleado
    
    /*
    Altualiza los datos de la base de datos o modifica un estudiante
    */
    public boolean actualizarCurso(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("UPDATE cursos SET nombre='"+arregloInformacion[1]+"',creditos='"+arregloInformacion[2]+"',horario='"+arregloInformacion[3]+"' WHERE sigla='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia " + e.getMessage());
            return false;
        }
        
    }//Fin actualizarEstudiante
    
    /*
    Elimina un estudiante de la base de datos
    */
    public boolean eliminarCurso(String arregloInformacion[]) {
        
        ResultSet rs=null;
        Statement cmd=null;
        boolean ejecutar;
        
        try
        {
            cmd=con.createStatement();
            ejecutar= cmd.execute("DELETE FROM `cursos` WHERE sigla='"+arregloInformacion[0]+"'");
            return true;
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia "+e.getMessage());
            return false;
        }
        
    }//Fin eliminarEstudiante
    
    /*
    Busca un estuddiante en la base de datos y guarda los valores un arreglo
    */
    public void consultarCurso(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT sigla, nombre, creditos, horario FROM cursos WHERE sigla = '"+arregloInformacion[0]+"'");
                
                while (rs.next()) 
                {
                    String sigla = rs.getString("sigla");
                    String nombreCurso = rs.getString("nombre");
                    String creditos = rs.getString("creditos");
                    String horario = rs.getString("horario");
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD: "+sigla+" "+nombreCurso+" "+creditos+" "+" "+horario);
                   
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }//Fin consultarEmpleado
    
    /*
    
    */
    public void consultarCursoMatricula(String sigla) {
        
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre FROM cursos WHERE sigla = '"+sigla+"'");
                
                while (rs.next()) 
                {
                    String siglaTemp = rs.getString("sigla");
                    String nombreCurso = rs.getString("nombre");
                    
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD: "+sigla+" "+nombreCurso);
                   
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }//Fin consultarCursoMatricula
    
    /*
    
    */
    public void consultarEstudianteMatricula(String cedula) {
        
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre FROM estudiantes WHERE cedula = '"+cedula+"'");
                
                while (rs.next()) 
                {
                    String cedulaTemp = rs.getString("cedula");
                    String nombreEst = rs.getString("nombre");
                    
                    //int edad = rs.getInt(2);
                    System.out.println("Información de la BD: "+cedula+" "+nombreEst);
                   
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        
    }//Fin consultarEstudianteMatricula
    
    /*
    Registra un estudiante en la base de datos
     */
    
    /*
    Aquí quedé
    */
    public boolean registrarMatricula(String arregloInformacion[]) {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
            cmd = con.createStatement();
            ejecutar = cmd.execute("INSERT INTO matricula(cedula, sigla) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"')");
            
            return true;
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    } //Fin registrarEmpleado
    
    
    
}//Fin MetodoConexionBD
