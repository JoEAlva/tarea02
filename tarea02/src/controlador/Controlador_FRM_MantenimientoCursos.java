/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosConexionBD;
import vista.FRM_MantenimientoCursos;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener {
    
    //Referencias
    FRM_MantenimientoCursos frmmc;
    MetodosConexionBD mcbd;
    
    //Constructor   
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frmmc, MetodosConexionBD mcbd) {
        this.mcbd = mcbd;
        this.frmmc = frmmc;
        
    }//Controlador_FRM_Mantenimientos

    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("CONSULTAR")) {
            
            System.out.println("C");
            mcbd.consultarCurso(frmmc.devolverInformacion());
            frmmc.mostrarInformacion(mcbd.devolverArregloCurso());
            
        }
        
        if(e.getActionCommand().equals("AGREGAR")) {
            
            System.out.println("A");
            mcbd.registrarCurso(frmmc.devolverInformacion());
            frmmc.limpiarCampos();
            
        }
        
        if(e.getActionCommand().equals("MODIFICAR")) {
            
            System.out.println("M");
            mcbd.actualizarCurso(frmmc.devolverInformacion());
            frmmc.limpiarCampos();
            
        }
        
        if(e.getActionCommand().equals("ELIMINAR")) {
            
            System.out.println("E");
            mcbd.eliminarCurso(frmmc.devolverInformacion());
            frmmc.limpiarCampos();
            
        }
        
    } //Fin actionPerformed
    
}//Fin Controlador_FRM_MantenimientoCursos
