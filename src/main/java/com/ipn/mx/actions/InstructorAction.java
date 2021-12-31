/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.actions;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InstructorDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InstructorDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.Instructor;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JMTN
 */
public class InstructorAction extends ActionSupport {

    private InstructorDTO instructor = new InstructorDTO();
    private List instructores = new ArrayList<>();

    private final InstructorDAO dao = new InstructorDAO();

    public String listarInstructores() {
        try {
            this.instructores = dao.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(InstructorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String agregarInstructores() {
        try {
            dao.create(instructor);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }

    public String almacenaInstructor() {
        try {
            if (instructor.getEntidad().getIdProfesor() == 0) {
                dao.create(instructor);
            } else {
                dao.update(instructor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String eliminaInstructor(){
        
        try {
            instructor = dao.read(instructor);
            dao.delete(instructor);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
    public String actualizaInstructor(){
        try {
            instructor = dao.read(instructor);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return SUCCESS;
    }
    
}
