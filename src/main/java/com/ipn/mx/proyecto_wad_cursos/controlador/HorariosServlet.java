/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.HorariosDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.HorariosDTO;

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
@WebServlet(name = "HorariosServlet", urlPatterns = {"/HorariosServlet"})
public class HorariosServlet extends HttpServlet {

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
            if (accion.equals("listaDeHorarios")) {
                listaDeHorarios(request, response);
            } else {
                if (accion.equals("nuevoHora")) {
                    agregarHorarios(request, response);
                } else {
                    if (accion.equals("eliminarHora")) {
                        eliminarHorarios(request, response);
                    } else {
                        if (accion.equals("actuallizarHora")) {
                            actualizarHorarios(request, response);
                        } else {
                            if (accion.equals("guardarHora")) {
                                almacenarHorarios(request, response);
                            } else {
                                if (accion.equals("mostrarHora")) {
                                    mostrarHora(request, response);
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

    private void listaDeHorarios(HttpServletRequest request, HttpServletResponse response) {
        HorariosDAO dao = new HorariosDAO();
        Collection lista;
        try {
            //lista = dao.readAll(request.getParameter("idCurso"), Integer.parseInt(request.getParameter("idProfesor")));
            lista = dao.readAll();
            request.setAttribute("listaDeHorarios", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/horarios/listahorarios.jsp");
            rd.forward(request, response);
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarHorarios(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/horarios/horariosFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eliminarHorarios(HttpServletRequest request, HttpServletResponse response) {
        HorariosDAO dao = new HorariosDAO();
        HorariosDTO dto = new HorariosDTO();
        dto.getEntidad().setIdHorario(Integer.parseInt(request.getParameter("idHorario")));
        try {
            dao.delete(dto);
            listaDeHorarios(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarHorarios(HttpServletRequest request, HttpServletResponse response) {
        HorariosDAO dao = new HorariosDAO();
        HorariosDTO dto = new HorariosDTO();
        dto.getEntidad().setIdHorario(Integer.parseInt(request.getParameter("idHorario")));
        RequestDispatcher vista = request.getRequestDispatcher("/horarios/horariosFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("horario", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarHorarios(HttpServletRequest request, HttpServletResponse response) {
        HorariosDAO dao = new HorariosDAO();
        HorariosDTO dto = new HorariosDTO();
        if (Integer.parseInt(request.getParameter("modificar")) == 0) {
            dto.getEntidad().setIdCurso(request.getParameter("idCurso"));
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("idProfesor")));
            dto.getEntidad().setHora(request.getParameter("txtHora"));
            dto.getEntidad().setDisponible(true);
            dto.getEntidad().setNombrePlataforma(request.getParameter("txtNombrePlataforma"));
            try {
                dao.create(dto);
                listaDeHorarios(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dto.getEntidad().setIdHorario(Integer.parseInt(request.getParameter("idHorario")));
            dto.getEntidad().setIdCurso(request.getParameter("idCurso"));
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("idProfesor")));
            dto.getEntidad().setHora(request.getParameter("txtHora"));
            dto.getEntidad().setDisponible(Boolean.parseBoolean(request.getParameter("txtDisponible")));
            dto.getEntidad().setNombrePlataforma(request.getParameter("txtNombrePlataforma"));
            try {
                dao.update(dto);
                listaDeHorarios(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarHora(HttpServletRequest request, HttpServletResponse response) {
        HorariosDAO dao = new HorariosDAO();
        HorariosDTO dto = new HorariosDTO();
        dto.getEntidad().setIdHorario(Integer.parseInt("txtIdHorario"));
        RequestDispatcher vista = request.getRequestDispatcher("/horarios/datosHorario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("horario", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(HorariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
