/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesFinalDTO;
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
public class CalificacionesFinalDAO {

    /*Scripts para las operaciones de CRUD*/
    private static final String SQL_INSERT = "call spInsertaCalFinal(?,?,?)";
    private static final String SQL_UPDATE = "call spActualizarCalFinal(?,?,?,?)";
    private static final String SQL_DELETE = "call spEliminarCalFinal(?)";
    private static final String SQL_READ = "select * from seleccionaCalFinal(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaCalFinales()";
    private static final String SQL_READ_ID = "select * from calificacionesfinales where idcurso = ? and idestudiante = ?";
    private static final String SQL_READ_ALLxEstudiante = "select * from seleccionaCalFinalXestudiante(?)";
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

    public void create(CalificacionesFinalDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setInt(1, dto.getEntidad().getIdEstudiante());
            ps.setString(2, dto.getEntidad().getIdCurso());
            ps.setInt(3, dto.getEntidad().getCalF());
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

    public void update(CalificacionesFinalDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getIdCalFinal());
            ps.setInt(2, dto.getEntidad().getIdEstudiante());
            ps.setString(3, dto.getEntidad().getIdCurso());
            ps.setInt(4, dto.getEntidad().getCalF());
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

    public void delete(CalificacionesFinalDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCalFinal());
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

    public CalificacionesFinalDTO read(CalificacionesFinalDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCalFinal());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CalificacionesFinalDTO) resultados.get(0);

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

    
    public CalificacionesFinalDTO readID(CalificacionesFinalDTO dto) throws SQLException{
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ_ID);
            ps.setString(1, dto.getEntidad().getIdCurso());
            ps.setInt(2, dto.getEntidad().getIdEstudiante());
            rs = ps.executeQuery();
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if(resultados.size() > 0){
                return (CalificacionesFinalDTO) resultados.get(0);
                
            }else{
                return null;
            }
        } finally {
            if(rs != null){
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
        
    public List readAll() throws  SQLException{
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

    public List readALLxEstudiantes(CalificacionesFinalDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ_ALLxEstudiante);
            ps.setInt(1, dto.getEntidad().getIdEstudiante());
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

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
            dto.getEntidad().setIdCalFinal(rs.getInt("idCalFinal"));
            dto.getEntidad().setIdEstudiante(rs.getInt("idEstudiante"));
            dto.getEntidad().setIdCurso(rs.getString("idCurso"));
            dto.getEntidad().setCalF(rs.getInt("calF"));
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        dto.getEntidad().setIdEstudiante(3);
        try {
            //System.out.println(dao.readAll());
            System.out.println(dao.readALLxEstudiantes(dto));
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesFinalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
