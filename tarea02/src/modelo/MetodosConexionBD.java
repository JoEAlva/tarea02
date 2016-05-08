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
    public String infoEst[];
    public String infoCurso[];
    public String nombreCurso;
    public String nombreEst;
    
    String nombre = "";
    String direccion = "";
            
    //Se declaran las variables
    
    //Constructor
    public MetodosConexionBD() {
                
        infoEst = new String[2];
        infoCurso = new String[3];
        
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
        String info[] = new String[2];

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT nombre, direccion FROM estudiantes WHERE cedula = '"+arregloInformacion[0]+"'");
                
                while (rs.next()) 
                {
                    info[0] = rs.getString("nombre");
                    info[1] = rs.getString("direccion");
                    //int edad = rs.getInt(2);
                    this.infoEst = info;
                    
                }
                
                rs.close();
                
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
       
    }//Fin consultarEmpleado

    /*
    Retorna el arreglo con la información del estudiante
    */
    public String[] devolverArregloEst() {
        
        return this.infoEst;
        
    }//Fin devolverArregloInformacion

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
        String info[] = new String[4];

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT sigla, nombre, creditos, horario FROM cursos WHERE sigla = '"+arregloInformacion[0]+"'");
                
                while (rs.next()) 
                {
                    
                    info[0] = rs.getString("nombre");
                    info[1] = ""+rs.getInt("creditos");
                    info[2] = rs.getString("horario");
                    //int edad = rs.getInt(2);
                    this.infoCurso = info;
                    
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
    public String[] devolverArregloCurso() {
        
        return this.infoCurso;
        
    }//Fin devolverArregloCurso
    
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
                   
                    String nombreCurso = rs.getString("nombre");
                    this.nombreCurso = nombreCurso;
                    //int edad = rs.getInt(2);
                   
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
    public String devolverNombreCurso() {
        
        return this.nombreCurso;
        
    }//Fin devolverNombreCurso
    
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
                    
                    String nombreEst = rs.getString("nombre");
                    this.nombreEst = nombreEst;
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
    
    */
    public String devolverNombreEst() {
        
        return this.nombreEst;
        
    }//Fin devolverNombreEst
    
    /*
    Registra un estudiante en la base de datos
     */
    
    /*
    
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
    
    /*
    
    */
    public boolean registrarDetalleMatricula(String arregloInformacion[]) {
        
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecutar;
        
        try {
            cmd = con.createStatement();
            ejecutar = cmd.execute("INSERT INTO detalle_matricula(cedula, nombreEstudiante, sigla, nombreCurso) VALUES ('"+arregloInformacion[0]+"','"+arregloInformacion[1]+"','"+arregloInformacion[2]+"','"+arregloInformacion[3]+"')");
            
            return true;
            // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
        
    }//Fin registrarDetalleMatricula
    
    
    
}//Fin MetodoConexionBD
