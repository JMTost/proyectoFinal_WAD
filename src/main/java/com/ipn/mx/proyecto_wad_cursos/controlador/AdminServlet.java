/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.AdminDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.AdminDTO;
import com.ipn.mx.utilerias.EnviarMail;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JMTN
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String accion = request.getParameter("accion");
            if(accion.equals("listaDeAdminis")){
                listaDeAdmins(request, response);
            }else{
                if(accion.equals("nuevoAdmin")){
                    agregarAdmin(request, response);
                }else{
                    if(accion.equals("eliminarAdmin")){
                        eliminarAdmin(request, response);
                    }else{
                        if(accion.equals("actualizarAdmin")){
                            actualizarAdmin(request, response);
                        }else{
                            if(accion.equals("guardarAdmin")){
                                almacenarAdmin(request, response);
                            }else{
                                if(accion.equals("mostrarAdmin")){
                                    mostrarAdmin(request, response);
                                }else{
                                    if(accion.equals("mostrarReporteAdmin")){
                                        mostrarReporteAdmin(request, response);
                                    }else{
                                        if(accion.equals("mostrarGraficaAdmin")){
                                            mostrarGraficaAdmin(request, response);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listaDeAdmins(HttpServletRequest request, HttpServletResponse response) {
        AdminDAO dao = new AdminDAO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaAdmins", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/admins/listaAdmins.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarAdmin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/admins/adminsFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void eliminarAdmin(HttpServletRequest request, HttpServletResponse response) {
        AdminDAO dao = new AdminDAO();
        AdminDTO dto = new AdminDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdAdmin(request.getParameter("id"));
        try {
            dao.delete(dto);
            mail.enviarCorreo("max.55@live.com.mx", "Eliminación de usuario - aviso sistema", "Se ha realizado la eliminación de un administrador.\n ID: "+dto.getEntidad().getIdAdmin()+"\n Contraseña: "+dto.getEntidad().getPassAdmin());
            listaDeAdmins(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarAdmin(HttpServletRequest request, HttpServletResponse response) {
        AdminDAO dao = new AdminDAO();
        AdminDTO dto = new AdminDTO();
        dto.getEntidad().setIdAdmin(request.getParameter("id"));
        RequestDispatcher vista = request.getRequestDispatcher("/admins/adminsFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("admin", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarAdmin(HttpServletRequest request, HttpServletResponse response) {
        EnviarMail mail = new EnviarMail();
        AdminDAO dao = new AdminDAO();
        AdminDTO dto = new AdminDTO();
        if(Integer.parseInt(request.getParameter("modificar"))==0){
            dto.getEntidad().setIdAdmin(request.getParameter("txtIdAdmin"));
            dto.getEntidad().setPassAdmin(request.getParameter("txtPassAdmin"));
            try {
                dao.create(dto);
                //Solo enviamos correo al administrador inicial del sistema
                mail.enviarCorreo("max.55@live.com.mx", "Creación de nuevo administrador", "Los datos del nuevo usuario son.\n ID: "+dto.getEntidad().getIdAdmin()+" \nContraseña: "+dto.getEntidad().getPassAdmin());
                request.setAttribute("mensaje", "Creación de administrador, ¡Exitosa!");
                listaDeAdmins(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            dto.getEntidad().setIdAdmin(request.getParameter("txtIdAdmin"));
            dto.getEntidad().setPassAdmin(request.getParameter("txtPassAdmin"));
            try {
                dao.update(dto);
                mail.enviarCorreo("max.55@live.com.mx", "Actualización del administrador - aviso del sistema", "Los datos del actualizados del administrador son.\n ID: "+dto.getEntidad().getIdAdmin()+" \nContraseña: "+dto.getEntidad().getPassAdmin());
                request.setAttribute("mensaje", "Actualización de administrador, ¡Exitosa!");
                listaDeAdmins(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarAdmin(HttpServletRequest request, HttpServletResponse response) {
        AdminDAO dao = new AdminDAO();
        AdminDTO dto = new AdminDTO();
        dto.getEntidad().setIdAdmin(request.getParameter("id"));
        RequestDispatcher vista = request.getRequestDispatcher("/admins/datosAdministrador.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("instructor", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarReporteAdmin(HttpServletRequest request, HttpServletResponse response) {
        
        
    }

    private void mostrarGraficaAdmin(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
