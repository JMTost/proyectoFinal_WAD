/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.CalificacionesFinal;
import lombok.Data;

/**
 *
 * @author JMTN
 */
@Data
public class CalificacionesFinalDTO {
    private CalificacionesFinal entidad;
    public CalificacionesFinalDTO(){
        entidad = new CalificacionesFinal();
    }
    public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID calificacion final: ").append(getEntidad().getIdCalFinal()).append("\n");
         sb.append("ID estudiante: ").append(getEntidad().getIdEstudiante()).append("\n");
         sb.append("ID curso: ").append(getEntidad().getIdCurso()).append("\n");
         sb.append("Calificacion final: ").append(getEntidad().getCalF()).append("\n");
         return sb.toString();
     }
}
