/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.FRM_MantenimientoEstudiantes;

/**
 *
 * @author JorgeIgnacio
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener {

    //Referencias
    FRM_MantenimientoEstudiantes frmme;
    
    //Contructor
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes frmme) {
        
        //Instancias
        this.frmme = frmme;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("CONSULTAR")) {
            System.out.println("C");
        }
        
        if(e.getActionCommand().equals("AGREGAR")) {
            System.out.println("A");
        }
        
        if(e.getActionCommand().equals("MODIFICAR")) {
            System.out.println("M");
        }
        
        if(e.getActionCommand().equals("ELIMINAR")) {
            System.out.println("E");
        }
        
    }
    
}//Fin Controlador_FRM_MantenimientoEstudiantes
