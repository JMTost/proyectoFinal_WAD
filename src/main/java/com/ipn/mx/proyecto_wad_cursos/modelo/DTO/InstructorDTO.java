/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.Instructor;
import lombok.Data;

/**
 *
 * @author FACTORING
 */
@Data
public class InstructorDTO {
    private Instructor entidad;
    public InstructorDTO(){
        entidad = new Instructor();
    }
    
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID Instructor: ").append(getEntidad().getIdProfesor()).append("\n");
         sb.append("Nombre: ").append(getEntidad().getNombre()).append("\n");
         sb.append("Ap. Paterno: ").append(getEntidad().getApPat()).append("\n");
         sb.append("Ap. Materno: ").append(getEntidad().getApMat()).append("\n");
         sb.append("Telefono: ").append(getEntidad().getTelefono()).append("\n");
         sb.append("Correo: ").append(getEntidad().getCorreo()).append("\n");
         sb.append("Contraseña: ").append(getEntidad().getPass()).append("\n");
         
         sb.append("Calle: ").append(getEntidad().getCalle()).append("\n");
         sb.append("Num Ext.: ").append(getEntidad().getNumExt()).append("\n");
         sb.append("C.P.: ").append(getEntidad().getCodPost()).append("\n");
         sb.append("Delegación: ").append(getEntidad().getDelegacion()).append("\n");
         return sb.toString();
     }
    }
