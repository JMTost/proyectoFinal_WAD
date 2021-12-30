/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.CalificacionesParciales;
import lombok.Data;

/**
 *
 * @author JMTN
 */
@Data
public class CalificacionesParcialesDTO {
    private CalificacionesParciales entidad;
    public CalificacionesParcialesDTO(){
        entidad = new CalificacionesParciales();
    }
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("Llave calificacion: ").append(getEntidad().getLlave_califi()).append("\n");
         sb.append("Password: ").append(getEntidad().getDesc()).append("\n");
         return sb.toString();
     }
}
