/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InscripcionCursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InscripcionCursoDTO;

import com.ipn.mx.utilerias.EnviarMail;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author JMTN
 */
@WebServlet(name = "InscripcionCursoServlet", urlPatterns = {"/InscripcionCursoServlet"})
public class InscripcionCursoServlet extends HttpServlet {

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
            String accion = request.getParameter("accion");
            if (accion.equals("listaDeInscripcionCurso")) {
                listaDeInscripcionCurso(request, response);
            } else {
                
                    if (accion.equals("eliminarHora")) {
                        eliminarInscripcionCurso(request, response);
                    } else {
                        /*if (accion.equals("actuallizarHora")) {
                            actualizarHorarios(request, response);
                        } else {
                            */
                            if (accion.equals("guardarHora")) {
                                almacenarInscripcionCurso(request, response);
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

    private void listaDeInscripcionCurso(HttpServletRequest request, HttpServletResponse response) {
        InscripcionCursoDAO dao = new InscripcionCursoDAO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeInscripcionCurso", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/InscripcionCurso/listaInscripcionCurso.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(InscripcionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarInscripcionCurso(HttpServletRequest request, HttpServletResponse response) {
        InscripcionCursoDAO dao = new DescripcionCursoDAO();
        try {
            dao.create(request.getParameter("idCurso"), request.getParameter("IdEstudiante"));
            listaDeInscripcionCurso(request,response);
        } catch (ServletException ex) {
            Logger.getLogger(InscripcionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InscripcionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eliminarInscripcionCurso(HttpServletRequest request, HttpServletResponse response) {
        InscripcionCursoDAO dao = new InscripcionCursoDAO();
        InscripcionCursoDTO dto = new InscripcionCursoDTO();
        dto.getEntidad().setIdCurso(request.getParameter("idCurso"));
        dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("idEstudiante")));
        try {
            dao.delete(dto);
            listaDeInscripcionCurso(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
