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
public class Controlador_FRM_MenuPrincipal implements ActionListener {
    
    //Referencias
    FRM_MantenimientoEstudiantes frmme;
    
    //Constructor
    public Controlador_FRM_MenuPrincipal() {
        
        //Instancias
        frmme = new FRM_MantenimientoEstudiantes();
        
    }//Fin Constructor
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Estudiantes")) {
            
            frmme.setVisible(true);
            
        }
        
    }//Fin actionPerformed
    
}//Fin Controlador_FRM_MenuPrincipal
