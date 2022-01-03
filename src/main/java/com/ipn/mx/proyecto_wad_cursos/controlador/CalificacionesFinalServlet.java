/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CalificacionesFinalDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.EstudianteDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesFinalDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CursoDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.EstudianteDTO;
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
@WebServlet(name = "CalificacionesFinalServlet", urlPatterns = {"/CalificacionesFinalServlet"})
public class CalificacionesFinalServlet extends HttpServlet {

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
            if (accion.equals("listaCalificacionesF")) {
                listaDeCalificacionesF(request, response);
            } else {
                if (accion.equals("nuevaCalificacionF")) {
                    agregarCalificacionF(request, response);
                } else {
                    if (accion.equals("eliminarCalificacionF")) {
                        eliminarCalificacionF(request, response);
                    } else {
                        if (accion.equals("actualizarCalificacionF")) {
                            actualizarCalificacionF(request, response);
                        } else {
                            if (accion.equals("guardarCalificacionF")) {
                                almacenarCalificacionF(request, response);
                            } else {
                                if (accion.equals("mostrarCalificacionF")) {
                                    mostrarCalificacionF(request, response);
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

    private void listaDeCalificacionesF(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaCalF", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/calF/listaCalF.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarCalificacionF(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/calF/calificacionesForm.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarCalificacionF(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdCalFinal(Integer.parseInt(request.getParameter("id")));
        try {
            dao.delete(dto);
            mail.enviarCorreo("max.55@live.com.mx", "Eliminarción de calificación final - aviso sistema", "Se ha realizado la eliminación de la calificación final id: " + dto.getEntidad().getIdCalFinal());
            listaDeCalificacionesF(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarCalificacionF(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        dto.getEntidad().setIdCalFinal(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/calF/calificacionesForm.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("calF", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarCalificacionF(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        EstudianteDAO daoEst = new EstudianteDAO();
        EstudianteDTO dtoEst = new EstudianteDTO();
        CursoDTO cursoDTO = new CursoDTO();
        CursoDAO cursoDAO = new CursoDAO();
        EnviarMail mail = new EnviarMail();
        if (Integer.parseInt(request.getParameter("modificar")) == 0) {
            dto.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
            dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("txtIdEstudiante")));
            dto.getEntidad().setCalF(Integer.parseInt(request.getParameter("txtCalF")));
            try {
                dao.create(dto);
                dtoEst.getEntidad().setIdEstudiante(dto.getEntidad().getIdEstudiante());
                dtoEst = daoEst.read(dtoEst);
                cursoDTO.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
                cursoDTO = cursoDAO.read(cursoDTO);
                mail.enviarCorreo(dtoEst.getEntidad().getCorreo(), "Tienes una nueva calificación", "Tienes una nueva calificación del curso: " + cursoDTO.getEntidad().getNombreCurso() + "\t con una calificación de: " + dto.getEntidad().getCalF());
                mail.enviarCorreo("max.55@live.com.mx", "Creación de nueva calificación - aviso sistema", "Se ha creado una nueva calificación del curso con id: " + dto.getEntidad().getIdCurso() + "\t con nombre: " + cursoDTO.getEntidad().getNombreCurso() + "\n Para el estudiante con ID: " + dtoEst.getEntidad().getIdEstudiante());
                request.setAttribute("mensaje", "Creación de calificación final, ¡Exitosa!");
                listaDeCalificacionesF(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            dto.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
            dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("txtIdEstudiante")));
            dto.getEntidad().setCalF(Integer.parseInt(request.getParameter("txtCalF")));
            dto.getEntidad().setIdCalFinal(Integer.parseInt(request.getParameter("txtIdCalFinal")));
            try {
                dao.update(dto);
                dtoEst.getEntidad().setIdEstudiante(dto.getEntidad().getIdEstudiante());
                dtoEst = daoEst.read(dtoEst);
                cursoDTO.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
                cursoDTO = cursoDAO.read(cursoDTO);
                mail.enviarCorreo("max.55@live.com.mx", "Actualización de nueva calificación - aviso sistema", "Se ha actualizado una calificación del curso con id: " + dto.getEntidad().getIdCurso() + "\t con nombre: " + cursoDTO.getEntidad().getNombreCurso() + "\n Para el estudiante con ID: " + dtoEst.getEntidad().getIdEstudiante());
                request.setAttribute("mensaje", "Actualización de calificación final, ¡Exitosa!");
                listaDeCalificacionesF(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void mostrarCalificacionF(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        EstudianteDAO daoEst = new EstudianteDAO();
        EstudianteDTO dtoEst = new EstudianteDTO();
        CursoDTO cursoDTO = new CursoDTO();
        CursoDAO cursoDAO = new CursoDAO();
        dto.getEntidad().setIdCalFinal(Integer.parseInt(request.getParameter("txtIdCalFinal")));
        RequestDispatcher vista = request.getRequestDispatcher("/calF/datosCalF.jsp");
        try {
            dto = dao.read(dto);
            dtoEst.getEntidad().setIdEstudiante(dto.getEntidad().getIdEstudiante());
            dtoEst = daoEst.read(dtoEst);
            cursoDTO.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
            cursoDTO = cursoDAO.read(cursoDTO);
            request.setAttribute("calF", dto);
            request.setAttribute("curso", cursoDTO);
            request.setAttribute("est", dtoEst);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CalificacionesFinalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
