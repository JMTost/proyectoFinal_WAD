/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.Curso;
import lombok.Data;

/**
 *
 * @author FACTORING
 */
@Data
public class CursoDTO {
    private Curso entidad;
    public CursoDTO(){
        entidad = new Curso();
    }
    
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID Curso: ").append(getEntidad().getIdCurso()).append("\n");
         sb.append("Nombre Curso: ").append(getEntidad().getNombreCurso()).append("\n");
         sb.append("ID Profesor: ").append(getEntidad().getIdProfesor()).append("\n");
         sb.append("Descripcion: ").append(getEntidad().getDescripcion()).append("\n");       
         return sb.toString();
     }
}