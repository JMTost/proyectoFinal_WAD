/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.DireccionCurso;
import lombok.Data;

/**
 *
 * @author yaron
 */
@Data
public class DireccionCursoDTO {
    private DireccionCurso entidad;
    public DireccionCursoDTO(){
        entidad = new DireccionCurso();
    }
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID direccion curso: ").append(getEntidad().getIdDir()).append("\n");
         sb.append("ID curso: ").append(getEntidad().getIdCurso()).append("\n");
         sb.append("ID profesor: ").append(getEntidad().getIdProfesor()).append("\n");
         sb.append("Nombre plataforma: ").append(getEntidad().getNombrePlat()).append("\n");
         sb.append("Link llamada: ").append(getEntidad().getLinkLlamada()).append("\n");
         sb.append("Contraseña llamada: ").append(getEntidad().getPassLlamada()).append("\n");
         return sb.toString();
     }
}