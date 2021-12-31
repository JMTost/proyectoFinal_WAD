/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InstructorDTO;
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
public class InstructorDAO {
    private static final String SQL_INSERT = "call spInsertarInstructor(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "call spActualizarIntructor(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_DELETE = "call spEliminarInstructor(?)";
    private static final String SQL_READ = "select * from LeerInstructor(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaTodosIntructor()";

    
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
    
    
    
    public void create(InstructorDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getCorreo());
            ps.setString(2, dto.getEntidad().getPass());
            ps.setString(3, dto.getEntidad().getNombre());
            ps.setString(4, dto.getEntidad().getApPat());
            ps.setString(5, dto.getEntidad().getApMat());
            ps.setString(6, dto.getEntidad().getCalle());
            ps.setInt(7, dto.getEntidad().getNumExt());
            ps.setInt(8, dto.getEntidad().getCodPost());
            ps.setString(9, dto.getEntidad().getDelegacion());
            ps.setString(10, dto.getEntidad().getTelefono());
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
        
    public void update(InstructorDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getIdProfesor());
            ps.setString(2, dto.getEntidad().getCorreo());
            ps.setString(3, dto.getEntidad().getPass());
            ps.setString(4, dto.getEntidad().getNombre());
            ps.setString(5, dto.getEntidad().getApPat());
            ps.setString(6, dto.getEntidad().getApMat());
            ps.setString(7, dto.getEntidad().getCalle());
            ps.setInt(8, dto.getEntidad().getNumExt());
            ps.setInt(9, dto.getEntidad().getCodPost());
            ps.setString(10, dto.getEntidad().getDelegacion());
            ps.setString(11, dto.getEntidad().getTelefono());
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

    public void delete(InstructorDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProfesor());
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

    public InstructorDTO read(InstructorDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdProfesor());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (InstructorDTO) resultados.get(0);
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
            InstructorDTO dto = new InstructorDTO();           
            dto.getEntidad().setIdProfesor(rs.getInt("idProfesor"));
            dto.getEntidad().setCorreo(rs.getString("correo"));
            dto.getEntidad().setPass(rs.getString("pass"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setApPat("apPat");
            dto.getEntidad().setApMat(rs.getString("apMat"));
            dto.getEntidad().setCalle(rs.getString("calle"));
            dto.getEntidad().setNumExt(rs.getInt("numExt"));
            dto.getEntidad().setCodPost(rs.getInt("codPost"));
            dto.getEntidad().setDelegacion(rs.getString("delegacion"));
            dto.getEntidad().setTelefono(rs.getString("telefono"));          
            resultados.add(dto);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        try {
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
