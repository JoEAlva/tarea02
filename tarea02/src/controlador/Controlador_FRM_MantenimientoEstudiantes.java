/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosConexionBD;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {

    //Referencias
    FRM_MantenimientoEstudiantes frmme;
    MetodosConexionBD mcbd;
    
    //Contructor
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frmme, MetodosConexionBD mcbd) {
        
        //Instancias
        this.mcbd = mcbd;
        this.frmme = frmme;
        mcbd.realizarConexion();
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("CONSULTAR")) {
            System.out.println("C");
            mcbd.consultarEstudiante(frmme.obtenerInformacion());
            /*
            Aquí le paso por parámetro al método el arreglo
            */
//            String arreglo[] = new String[2];
//            arreglo[0] = "Hola";
//            arreglo[1] = "mundo";
              frmme.mostrarInformacion(mcbd.devolverArreglo());
            
        }
        
        if(e.getActionCommand().equals("AGREGAR")) {
            System.out.println("A");
            mcbd.registrarEstudiante(frmme.obtenerInformacion());
            frmme.limpiarCampos();
        }
        
        if(e.getActionCommand().equals("MODIFICAR")) {
            System.out.println("M");
            mcbd.actualizarEstudiante(frmme.obtenerInformacion());
            frmme.limpiarCampos();
        }
        
        if(e.getActionCommand().equals("ELIMINAR")) {
            System.out.println("E");
            mcbd.eliminarEstudiante(frmme.obtenerInformacion());
            frmme.limpiarCampos();
        }
        
    }
    
}//Fin Controlador_FRM_MantenimientoEstudiantes
