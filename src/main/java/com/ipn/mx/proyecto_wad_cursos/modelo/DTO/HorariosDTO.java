/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.Horarios;
import lombok.Data;

/**
 *
 * @author yaron
 */
@Data
public class HorariosDTO {
    private Horarios entidad;
    public HorariosDTO(){
        entidad = new Horarios();
    }
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID horario: ").append(getEntidad().getIdHorario()).append("\n");
         sb.append("ID curso: ").append(getEntidad().getIdCurso()).append("\n");
         sb.append("ID profesor: ").append(getEntidad().getIdProfesor()).append("\n");
         sb.append("Dias : ").append(getEntidad().getDias()).append("\n");
         sb.append("Horas : ").append(getEntidad().getHoras()).append("\n");
         sb.append("Disponible: ").append(getEntidad().getDisponible()).append("\n");
         sb.append("Nombre plataforma: ").append(getEntidad().getNombrePlataforma()).append("\n");
         return sb.toString();
     }
}