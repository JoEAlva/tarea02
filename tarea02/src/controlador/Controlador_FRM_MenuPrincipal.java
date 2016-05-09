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
import vista.FRM_MantenimientoCursos;
import vista.FRM_Matricula1;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener {
    
    //Referencias
    FRM_MantenimientoEstudiantes frmme;
    FRM_MantenimientoCursos frmmc;
    FRM_Matricula1 frmm;
    MetodosConexionBD mcbd;
    
    //Constructor
    public Controlador_FRM_MenuPrincipal() {
        
        //Instancias
        mcbd = new MetodosConexionBD();
        frmme = new FRM_MantenimientoEstudiantes(mcbd);
        frmmc = new FRM_MantenimientoCursos(mcbd);
        frmm = new FRM_Matricula1(mcbd);
        
    }//Fin Constructor
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Mantenimiento Estudiante")) {
            
            frmme.setVisible(true);
            
        }
        
        if(e.getActionCommand().equals("Mantenimiento Curso")) {
            
            
            frmmc.setVisible(true);
            
        }
        
        if(e.getActionCommand().equals("Matricula")) {
            
            
            frmm.setVisible(true);
            mcbd.contarNumeroFilasMatricula();
            
            frmm.mostrarCodigoMatricula(""+mcbd.generarCodigo());
        }
        
    }//Fin actionPerformed
    
}//Fin Controlador_FRM_MenuPrincipal
