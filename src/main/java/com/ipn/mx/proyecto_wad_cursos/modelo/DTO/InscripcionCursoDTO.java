/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.InscripcionCurso;
import lombok.Data;

/**
 *
 * @author yaron
 */
@Data
public class InscripcionCursoDTO {
    private InscripcionCurso entidad;
    public InscripcionCursoDTO(){
        entidad = new InscripcionCurso();
    }
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID curso: ").append(getEntidad().getIdCurso()).append("\n");
         sb.append("ID estudiante: ").append(getEntidad().getIdEstudiante()).append("\n");
         return sb.toString();
     }
}