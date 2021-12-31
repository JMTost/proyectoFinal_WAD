/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InscripcionCursoDTO;
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
 * @author JMTN
 */
public class InscripcionCursoDAO {

    /*Scripts para las operaciones de CRUD*/
    private static final String SQL_INSERT = "call spInsertaInscripcionCurso(?,?)";
    private static final String SQL_UPDATE = "";
    private static final String SQL_DELETE = "call spEliminarInscripcion(?,?)";
    private static final String SQL_READ = "select * from seleccionaUnaInscripcion(?,?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaInscripcionCurso()";

    private Connection conexion;

    //METODO DE CONEXION
    /*public Connection conectar() {
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
    }*/
    private void conectar() {
        String user = "bfeszlnsmgkltd";
        String pwd = "f82a60dc9910e10bd1f80f0584e0be408579ac03fbe0f636d3b9a31b661108a0";
        String url = "postgres://bfeszlnsmgkltd:f82a60dc9910e10bd1f80f0584e0be408579ac03fbe0f636d3b9a31b661108a0@ec2-34-236-87-247.compute-1.amazonaws.com:5432/d8kdjahdr678r6";//sslmoderequire
        String pgDriver = "org.postgresql.Driver";
        try {
            //registra el driver de java para el manejador de base de datos
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
            //debería de ser dos excepciones, class not found exception y sql exception, por no colocar de forma correcta los datos para la conexion a la base 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void create(InscripcionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getIdCurso());
            ps.setInt(2, dto.getEntidad().getIdEstudiante());
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

    public void update() throws SQLException {
        
    }

    public void delete(InscripcionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setString(1, dto.getEntidad().getIdCurso());
            ps.setInt(2, dto.getEntidad().getIdEstudiante());
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

    public InscripcionCursoDTO read(InscripcionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setString(1, dto.getEntidad().getIdCurso());
            ps.setInt(2, dto.getEntidad().getIdEstudiante());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (InscripcionCursoDTO) resultados.get(0);
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
            InscripcionCursoDTO dto = new InscripcionCursoDTO();
            dto.getEntidad().setIdCurso(rs.getString("idCurso"));
            dto.getEntidad().setIdEstudiante(rs.getInt("idEstudiante"));
            resultados.add(dto);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        InscripcionCursoDAO dao = new InscripcionCursoDAO();
        InscripcionCursoDTO dto = new InscripcionCursoDTO();
        try {
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
