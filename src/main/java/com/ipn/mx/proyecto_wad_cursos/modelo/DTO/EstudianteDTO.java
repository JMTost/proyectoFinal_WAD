/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DTO;

import com.ipn.mx.proyecto_wad_cursos.modelo.entidades.Estudiante;
import lombok.Data;

/**
 *
 * @author FACTORING
 */
@Data
public class EstudianteDTO {
    private Estudiante entidad;
    public EstudianteDTO(){
        entidad = new Estudiante();
    }
    
    @Override
     public String toString(){
         StringBuilder sb = new StringBuilder();
         sb.append("ID Estudiante: ").append(getEntidad().getIdEstudiante()).append("\n");
         sb.append("Nombre: ").append(getEntidad().getNombre()).append("\n");
         sb.append("Ap. Paterno: ").append(getEntidad().getApPatE()).append("\n");
         sb.append("Ap. Materno: ").append(getEntidad().getApMatE()).append("\n");
         sb.append("Telefono: ").append(getEntidad().getTelefono()).append("\n");
         sb.append("Correo: ").append(getEntidad().getCorreo()).append("\n");
         sb.append("Contraseña: ").append(getEntidad().getPassEstudiante()).append("\n");
         sb.append("Fecha Nacimiento:").append(getEntidad().getFechaNacimiento()).append("\n");
         return sb.toString();
     }
}

