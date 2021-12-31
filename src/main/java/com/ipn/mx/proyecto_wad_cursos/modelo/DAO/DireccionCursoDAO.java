/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.DireccionCursoDTO;
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
public class DireccionCursoDAO {

    /*Scripts para las operaciones de CRUD*/
    private static final String SQL_INSERT = "call spInsertaDirCur(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "call spActDirCur(?,?,?,?,?,?)";
    private static final String SQL_DELETE = "call spEliminarDirCurso(?)";
    private static final String SQL_READ = "select * from seleccionaUnDirCurso(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionadirCurso()";

    private Connection conexion;

    //METODO DE CONEXION
    private void conectar() {
        String user = "bfeszlnsmgkltd";
        String pwd = "f82a60dc9910e10bd1f80f0584e0be408579ac03fbe0f636d3b9a31b661108a0";
        String url = "jdbc:postgresql://ec2-34-236-87-247.compute-1.amazonaws.com:5432/d8kdjahdr678r6";//sslmoderequire
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

    public void create(DireccionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setInt(1, dto.getEntidad().getIdDir());
            ps.setString(2, dto.getEntidad().getIdCurso());
            ps.setInt(3, dto.getEntidad().getIdProfesor());
            ps.setString(4, dto.getEntidad().getNombrePlat());
            ps.setString(5, dto.getEntidad().getLinkLlamada());
            ps.setString(6, dto.getEntidad().getPassLlamada());
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

    public void update(DireccionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setInt(1, dto.getEntidad().getIdDir());
            ps.setString(2, dto.getEntidad().getIdCurso());
            ps.setInt(3, dto.getEntidad().getIdProfesor());
            ps.setString(4, dto.getEntidad().getNombrePlat());
            ps.setString(5, dto.getEntidad().getLinkLlamada());
            ps.setString(6, dto.getEntidad().getPassLlamada());
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

    public void delete(DireccionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdDir());
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

    public DireccionCursoDTO read(DireccionCursoDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdDir());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (DireccionCursoDTO) resultados.get(0);
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
            DireccionCursoDTO dto = new DireccionCursoDTO();
            dto.getEntidad().setIdDir(rs.getInt("idDir"));
            dto.getEntidad().setIdCurso(rs.getString("idCurso"));
            dto.getEntidad().setIdProfesor(rs.getInt("idProfesor"));
            dto.getEntidad().setNombrePlat(rs.getString("NombrePlat"));
            dto.getEntidad().setLinkLlamada(rs.getString("LinkLlamada"));
            dto.getEntidad().setPassLlamada(rs.getString("PassLlamada"));;
            resultados.add(dto);
        }
        return resultados;
    }
    
    public static void main(String[] args) {
        DireccionCursoDAO dao = new DireccionCursoDAO();
        DireccionCursoDTO dto = new DireccionCursoDTO();
        try {
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
