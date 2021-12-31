/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.modelo.DAO;

import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.AdminDTO;
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
public class AdminDAO {

    /*Scripts para las operaciones de CRUD*/
    private static final String SQL_INSERT = "call spInsertAdmin(?,?)";
    private static final String SQL_UPDATE = "call spActualizarAdmin(?,?)";
    private static final String SQL_DELETE = "call spEliminarAdmin(?)";
    private static final String SQL_READ = "select * from buscaUnAdmin(?)";
    private static final String SQL_READ_ALLS = "select * from seleccionaAdmins()";

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

    public void create(AdminDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getIdAdmin());
            ps.setString(2, dto.getEntidad().getPassAdmin());
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

    public void update(AdminDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getIdAdmin());
            ps.setString(2, dto.getEntidad().getPassAdmin());
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

    public void delete(AdminDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        try {
            ps = conexion.prepareCall(SQL_DELETE);
            ps.setString(1, dto.getEntidad().getIdAdmin());
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

    public AdminDTO read(AdminDTO dto) throws SQLException {
        conectar();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareCall(SQL_READ);
            ps.setString(1, dto.getEntidad().getIdAdmin());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (AdminDTO) resultados.get(0);
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

    public List readAll() throws SQLException {
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

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            AdminDTO dto = new AdminDTO();
            dto.getEntidad().setIdAdmin(rs.getString("idAdmin"));
            dto.getEntidad().setPassAdmin(rs.getString("passAdmin"));
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        AdminDTO dto = new AdminDTO();
        dto.getEntidad().setIdAdmin("prueba");
        dto.getEntidad().setPassAdmin("prueba");
        try {
            //System.out.println(dao.readAll());

            //dao.create(dto);
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
