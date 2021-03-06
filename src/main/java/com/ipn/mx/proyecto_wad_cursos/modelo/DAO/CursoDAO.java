/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CursoDTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FACTORING
 */
public class CursoDAO {
    private static final String SQL_INSERT = "call spInsertarCurso(?,?,?,?)";
    private static final String SQL_UPDATE = "call spActualizarCurso(?,?,?,?)";
    private static final String SQL_DELETE = "call spEliminarCurso(?)";
    private static final String SQL_READ = "select * from seleccionaCurso(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaTodosCurso()";
    private static final String SQL_READ_ALL_PROFE = "select * from seleccionaCursosProfe(?)";
    
    private Connection conexion;

    //METODO DE CONEXION
    public Connection conectar() {
        String user = "wzevyustxebjfm";
        String pwd = "755144f18dd17ccee8d8d61aaadc9a1dcfc70d3e72871c7020e44ba2bb4c39fa";
        String url = "jdbc:postgresql://ec2-3-212-172-25.compute-1.amazonaws.com:5432/de7kvstj6o0h5d";//sslmoderequire
        String pgDriver = "org.postgresql.Driver";
        try {
            //registra el driver de java para el manejador de base de datos
            Class.forName(pgDriver);
            conexion = DriverManager.getConnection(url, user, pwd);
            //debería de ser dos excepciones, class not found exception y sql exception, por no colocar de forma correcta los datos para la conexion a la base 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }
    
    public void create(CursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            UUID uniqueKey = UUID.randomUUID();
            int tamaño = uniqueKey.toString().length();
            String IDFinal = uniqueKey.toString().substring(tamaño - 10);
            ps.setString(1, IDFinal);
            ps.setString(2, dto.getEntidad().getNombreCurso());
            ps.setInt(3, dto.getEntidad().getIdProfesor());
            ps.setString(4, dto.getEntidad().getDescripcion());
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
        
    public void update(CursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;        
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getIdCurso());
            ps.setString(2, dto.getEntidad().getNombreCurso());
            ps.setInt(3, dto.getEntidad().getIdProfesor());
            ps.setString(4, dto.getEntidad().getDescripcion());
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

    public void delete(CursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setString(1, dto.getEntidad().getIdCurso());
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

    public CursoDTO read(CursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setString(1, dto.getEntidad().getIdCurso());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CursoDTO) resultados.get(0);
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
    
    public List readAllProfe(int idprofe) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ_ALL_PROFE);
            ps.setInt(1, idprofe);
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
            CursoDTO dto = new CursoDTO();
            
            dto.getEntidad().setIdCurso(rs.getString("idCurso"));
            dto.getEntidad().setNombreCurso(rs.getString("nombreCurso"));
            dto.getEntidad().setIdProfesor(rs.getInt("idProfesor"));
            dto.getEntidad().setDescripcion(rs.getString("descripcion"));
            
            resultados.add(dto);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        CursoDAO dao = new CursoDAO();
        CursoDTO dto = new CursoDTO();
        try {
            
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*UUID uniqueKey = UUID.randomUUID();
        int tamaño = uniqueKey.toString().length();
        String cadenaFInal = uniqueKey.toString().substring(tamaño - 10);
        System.out.println (cadenaFInal);*/
    }
}