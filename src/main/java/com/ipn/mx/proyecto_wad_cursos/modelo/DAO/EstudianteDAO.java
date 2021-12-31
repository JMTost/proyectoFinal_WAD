/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.EstudianteDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FACTORING
 */
public class EstudianteDAO {
    private static final String SQL_INSERT = "call spInsertarEstudiante(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "call spActualizarEstudiante(?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "call spEliminarEstudiante(?)";
    private static final String SQL_READ = "select * from LeerEstudiante(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaEstudiantes()";

    
    private Connection conexion;

    //METODO DE CONEXION
    public Connection conectar() {
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
    
    public void create(EstudianteDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombre());
            ps.setString(2, dto.getEntidad().getApPatE());
            ps.setString(3, dto.getEntidad().getApMatE());
            ps.setString(4, dto.getEntidad().getTelefono());
            ps.setString(5, dto.getEntidad().getCorreo());
            ps.setString(6, dto.getEntidad().getPassEstudiante());
            ps.setString(7, dto.getEntidad().getFechaNacimiento());
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
        
    public void update(EstudianteDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getIdEstudiante());
            ps.setString(2, dto.getEntidad().getNombre());
            ps.setString(3, dto.getEntidad().getApPatE());
            ps.setString(4, dto.getEntidad().getApMatE());
            ps.setString(5, dto.getEntidad().getTelefono());
            ps.setString(6, dto.getEntidad().getCorreo());
            ps.setString(7, dto.getEntidad().getPassEstudiante());
            ps.setString(8, dto.getEntidad().getFechaNacimiento());
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

    public void delete(EstudianteDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdEstudiante());
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

    public EstudianteDTO read(EstudianteDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdEstudiante());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (EstudianteDTO) resultados.get(0);
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
            EstudianteDTO dto = new EstudianteDTO();           
            dto.getEntidad().setIdEstudiante(rs.getInt("idEstudiante"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setApPatE(rs.getString("apPatE"));
            dto.getEntidad().setApMatE(rs.getString("apMatE"));
            dto.getEntidad().setTelefono(rs.getString("telefono"));
            dto.getEntidad().setCorreo(rs.getString("correo"));
            dto.getEntidad().setPassEstudiante(rs.getString("passEstudiante"));
            dto.getEntidad().setFechaNacimiento(rs.getString("fechaNacimiento"));         
            resultados.add(dto);
        }
        return resultados;
    }
        
    public static void main(String[] args) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        try {
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
