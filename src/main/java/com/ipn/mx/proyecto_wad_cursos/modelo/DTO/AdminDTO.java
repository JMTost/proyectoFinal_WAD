/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.Admin;
import lombok.Data;

/**
 *
 * @author JMTN
 */
@Data
public class AdminDTO {
    private Admin entidad;
    public AdminDTO(){
        entidad = new Admin();
    }
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID admin: ").append(getEntidad().getIdAdmin()).append("\n");
         sb.append("Password: ").append(getEntidad().getPassAdmin()).append("\n");
         return sb.toString();
     }
}
