/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import vista.FRM_Matricula1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.MetodosConexionBD;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_Matricula implements ActionListener{
    
    //Referencias
    FRM_Matricula1 frm_Matricula;
    MetodosConexionBD mcbd;
    boolean encontroEstudiante=false; 
    boolean encontroCurso=false;
    
    public Controlador_FRM_Matricula(FRM_Matricula1 frm_Matricula, MetodosConexionBD mcbd)
    {
        this.mcbd = mcbd;
        this.frm_Matricula=frm_Matricula;

    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultarEst"))
        {
            
            System.out.println("ConsultarEst");
            mcbd.consultarEstudianteMatricula(frm_Matricula.devolverCedula());
            frm_Matricula.mostrarNombreEstudiante(mcbd.devolverNombreEst());
            
            
        }
        
        if(e.getActionCommand().equals("ConsultarCurso"))
        {
            System.out.println("ConsultaRapidaCurso");
            mcbd.consultarCursoMatricula(frm_Matricula.devolverSigla());
            frm_Matricula.mostrarNombreCurso(mcbd.devolverNombreCurso());
        }
        
        if(e.getActionCommand().equals("AGREGAR"))
        {  
            frm_Matricula.cargarTabla();
            encontroCurso=false;
            frm_Matricula.estadoInicial();
            frm_Matricula.limpiarCurso(); 
        }
        
        if(e.getActionCommand().equals("FINALIZAR"))
        {  
            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
                mcbd.registrarMatricula(frm_Matricula.getInformacionTabla(contador));

            }
            frm_Matricula.resetearInterfaz();
                        
        }
        
        if(encontroEstudiante && encontroCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
    }
    
//    public String colocarCodigo()
//    {
//        return metodosMatricula.devolverCodigo();
//    }
    
}//Controlador_FRM_Matricula
