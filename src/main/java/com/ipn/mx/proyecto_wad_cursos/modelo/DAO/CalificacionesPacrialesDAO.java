/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesParcialesDTO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JMTN
 */
public class CalificacionesPacrialesDAO {
    /*Scripts para las operaciones de CRUD*/
    private static final String SQL_INSERT = "call spInsertaCalParcial(?)";
    private static final String SQL_UPDATE = "call spActualizarCalParcial(?,?)";
    private static final String SQL_DELETE = "call spEliminarCalParcial(?)";
    private static final String SQL_READ = "select * from seleccionaCalPar(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaCalParciales()";
    
    private Connection conexion;
    
    //METODO DE CONEXION
    public Connection conectar(){
        String user = "postgres";
        String pass = "123";
        String url = "jdbc:postgresql://localhost:5432/proyectoWAD";
        String pgDriver = "org.postgresql.Driver";
        try {
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return conexion;
    }
    
    public void create(CalificacionesParcialesDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getDesc());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(CalificacionesParcialesDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getLlave_califi());
            ps.setString(2, dto.getEntidad().getDesc());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(CalificacionesParcialesDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getLlave_califi());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public CalificacionesParcialesDTO read(CalificacionesParcialesDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getLlave_califi());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CalificacionesParcialesDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }

    }
    
    public List readAll() throws SQLException{
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ_ALLS);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    
    private List obtenerResultados(ResultSet rs) throws SQLException{
        List resultados = new ArrayList();
        while(rs.next()){
            CalificacionesParcialesDTO dto = new CalificacionesParcialesDTO();
            dto.getEntidad().setLlave_califi(rs.getInt("llave_califi"));
            dto.getEntidad().setDesc(rs.getString("descripcion"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        CalificacionesPacrialesDAO dao = new CalificacionesPacrialesDAO();
        CalificacionesParcialesDTO dto = new CalificacionesParcialesDTO();
        try {
            System.out.println(dao.readAll());
            /*dto.getEntidad().setLlave_califi(1);
            dto = dao.read(dto);
            System.out.println("BUSQUEDA: "+dto.getEntidad().getLlave_califi());*/
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
