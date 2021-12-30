/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.entidades;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author JMTN
 */
@Data
@NoArgsConstructor
public class Estudiante implements Serializable{
    private int idEstudiante;
    private String nombre;
    private String apPatE;
    private String apMatE;
    private String telefono;
    private String correo;
    private String passEstudiante;
    private String fechaNacimiento;
}
