/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesParcialesDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CalificacionesPacrialesDAO;
import com.ipn.mx.utilerias.EnviarMail;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author JMTN
 */
@WebServlet(name = "CalificacionesParcialesServlet", urlPatterns = {"/CalificacionesParcialesServlet"})
public class CalificacionesParcialesServlet extends HttpServlet {

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
            if(accion.equals("listaCalPar")){
                listaDeCalPar(request, response);
            }else{
                if(accion.equals("nuevaCalP")){
                    agregarCalPar(request, response);
                }else{
                    if(accion.equals("eliminarCalP")){
                        eliminarCalPar(request, response);
                    }else{
                        if(accion.equals("actualizarCalP")){
                            actualizarCalPar(request, response);
                        }else{
                            if(accion.equals("guardarCalP")){
                                almacenarCalPar(request, response);
                            }else{
                                if(accion.equals("mostrarCalP")){
                                    mostrarCalPar(request, response);
                                }else{
                                    if(accion.equals("mostrarReporteCalPar")){
                                        mostrarReporteParcial(request, response);
                                    }else{
                                        if(accion.equals("mostrarGraficaCalPar")){
                                            mostrarGraficaParcial(request, response);
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

    private void listaDeCalPar(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesPacrialesDAO dao = new CalificacionesPacrialesDAO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeCalPar", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/calPar/listaCalPar.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void agregarCalPar(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/calPar/calParFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarCalPar(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesPacrialesDAO dao = new CalificacionesPacrialesDAO();
        CalificacionesParcialesDTO dto = new CalificacionesParcialesDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setLlave_califi(Integer.parseInt(request.getParameter("id")));
        try {
            dao.delete(dto);
            mail.enviarCorreo("max.55@live.com.mx", "Eliminación de calificación parcial - aviso sistema", "Se ha realizado una eliminación de Calificación parcial con los siguientes datos. ID: "+dto.getEntidad().getLlave_califi()+"\t descripción: "+dto.getEntidad().getDesc());
            listaDeCalPar(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarCalPar(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesPacrialesDAO dao = new CalificacionesPacrialesDAO();
        CalificacionesParcialesDTO dto = new CalificacionesParcialesDTO();
        dto.getEntidad().setLlave_califi(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/calPar/calParFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("calPar", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarCalPar(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesPacrialesDAO dao = new CalificacionesPacrialesDAO();
        CalificacionesParcialesDTO dto = new CalificacionesParcialesDTO();
        EnviarMail mail = new EnviarMail();
        if(Integer.parseInt(request.getParameter("modificar"))==0){
            dto.getEntidad().setDesc(request.getParameter("txtDescCalPar"));
            try {
                dao.create(dto);
                mail.enviarCorreo("max.55@live.com.mx", "Creación de Calificación parcial - aviso sistema", "Creación de nueva calificación de profesor con datos ID: "+dto.getEntidad().getLlave_califi()+"\t con descripción: "+dto.getEntidad().getDesc());
                request.setAttribute("mensaje", "Creación de calificación parcial, ¡Exitosa!");
                listaDeCalPar(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            dto.getEntidad().setLlave_califi(Integer.parseInt(request.getParameter("txtIdCalPar")));
            dto.getEntidad().setDesc(request.getParameter("txtDescCalPar"));
            try {
                dao.update(dto);
                mail.enviarCorreo("max.55@live.com.mx", "Actualización de calificación parcial - aviso sistema", "Actualización de nueva calificación");
                request.setAttribute("mensaje", "Actualización de calificación, ¡Exitosa!");
                listaDeCalPar(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarCalPar(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesPacrialesDAO dao = new CalificacionesPacrialesDAO();
        CalificacionesParcialesDTO dto = new CalificacionesParcialesDTO();
        dto.getEntidad().setLlave_califi(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/calPar/datosCalPar.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("calPar", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CalificacionesParcialesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarReporteParcial(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarGraficaParcial(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
