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
public class DireccionCurso implements Serializable{
    private int idDir;
    private String idCurso;
    private int idProfesor;
    private String nombrePlat;
    private String linkLlamada;
    private String passLlamada;
}
