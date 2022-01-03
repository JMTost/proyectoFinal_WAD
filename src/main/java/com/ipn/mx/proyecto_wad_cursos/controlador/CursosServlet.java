/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InstructorDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CursoDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InstructorDTO;
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
@WebServlet(name = "CursosServlet", urlPatterns = {"/CursosServlet"})
public class CursosServlet extends HttpServlet {

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
            if (accion.equals("listaDeCursos")) {
                listaDeCursos(request, response);
            } else {
                if (accion.equals("nuevoCurso")) {
                    agregarCurso(request, response);
                } else {
                    if (accion.equals("eliminarCurso")) {
                        eliminarCurso(request, response);
                    } else {
                        if (accion.equals("actualizarCurso")) {
                            actualizarCurso(request, response);
                        } else {
                            if (accion.equals("guardarCurso")) {
                                guardarCurso(request, response);
                            } else {
                                if (accion.equals("mostrarCurso")) {
                                    mostrarCurso(request, response);
                                } else {
                                    if (accion.equals("mostrarReporteCurso")) {
                                        mostrarReporteCurso(request, response);
                                    } else {
                                        if (accion.equals("mostrarGraficaCurso")) {
                                            mostrarGraficaCurso(request, response);
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

    private void listaDeCursos(HttpServletRequest request, HttpServletResponse response) {
        CursoDAO dao = new CursoDAO();
        CursoDTO dto = new CursoDTO();
        Collection lista;
        try {
            InstructorDTO dtoProfe = (InstructorDTO)request.getSession().getAttribute("dto1");
            int idprofe = dtoProfe.getEntidad().getIdProfesor();            
            lista = dao.readAllProfe(idprofe);
            request.setAttribute("listaDeCursos", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/cursos/listaCursos.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarCurso(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/cursos/cursosFormulario.jsp");
        InstructorDTO dto = (InstructorDTO)request.getSession().getAttribute("dto1");
        int idprofe = dto.getEntidad().getIdProfesor();
        try {
            request.setAttribute("modificar", 0);
            request.setAttribute("IDProfe",idprofe);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarCurso(HttpServletRequest request, HttpServletResponse response) {
        CursoDAO dao = new CursoDAO();
        CursoDTO dto = new CursoDTO();
        InstructorDAO profeDAO = new InstructorDAO();
        InstructorDTO profeDTO = new InstructorDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdCurso(request.getParameter("id"));
        profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
        try {
            dao.delete(dto);
            profeDTO = profeDAO.read(profeDTO);
            //Enviamos mensaje al profesor del curso
            mail.enviarCorreo(profeDTO.getEntidad().getCorreo(), "Se a realizado la eliminación de un curso", "Se ha realizado una eliminación de un curso en el que eres el profesor");
            mail.enviarCorreo("max.55@live.com.mx", "Eliminamos el curso - aviso sistema", "Se ha realizado la eliminación de un curso");
            listaDeCursos(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarCurso(HttpServletRequest request, HttpServletResponse response) {
        CursoDAO dao = new CursoDAO();
        CursoDTO dto = new CursoDTO();
        dto.getEntidad().setIdCurso(request.getParameter("id"));
        RequestDispatcher vista = request.getRequestDispatcher("/cursos/cursosFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("curso", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void guardarCurso(HttpServletRequest request, HttpServletResponse response) {
        CursoDAO dao = new CursoDAO();
        CursoDTO dto = new CursoDTO();
        InstructorDAO profeDAO = new InstructorDAO();
        InstructorDTO profeDTO = new InstructorDTO();
        EnviarMail mail = new EnviarMail();
        if (Integer.parseInt(request.getParameter("modificar")) == 0) {
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("txtIdProfesor")));
            dto.getEntidad().setNombreCurso(request.getParameter("txtNombreCurso"));
            dto.getEntidad().setDescripcion(request.getParameter("txtDescCurso"));
            try {
                dao.create(dto);
                profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
                profeDTO = profeDAO.read(profeDTO);
                mail.enviarCorreo(profeDTO.getEntidad().getCorreo(), "Creación de nuevo curso", "Creación de nuevo curso, en el cual tu eres el instructor, los datos del curso son. Nombre: " + dto.getEntidad().getNombreCurso() + "\nDescripción: " + dto.getEntidad().getDescripcion());
                mail.enviarCorreo("max.55@live.com.mx", "Creación de nuevo curso - aviso sistema", "Creación de curso con esta información. ID: " + dto.getEntidad().getIdCurso() + "\n nombre: " + dto.getEntidad().getNombreCurso() + "\nNombre del instructor: " + dto.getEntidad().getIdProfesor() + " con nombre: " + profeDTO.getEntidad().getNombre() + " " + profeDTO.getEntidad().getApPat() + " " + profeDTO.getEntidad().getApMat());
                request.setAttribute("mensaje", "Creación de cutso, ¡Exitoso!");
                listaDeCursos(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("txtIdProfesor")));
            dto.getEntidad().setNombreCurso(request.getParameter("txtNombreCurso"));
            dto.getEntidad().setDescripcion(request.getParameter("txtDescCurso"));
            dto.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
            try {
                dao.update(dto);
                profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
                profeDTO = profeDAO.read(profeDTO);
                mail.enviarCorreo(profeDTO.getEntidad().getCorreo(), "Actualización del curso al que eres instructor", "Actualización de datos.\nDatos.\nNombre: "+dto.getEntidad().getNombreCurso()+"\t descripción: "+dto.getEntidad().getDescripcion());
                mail.enviarCorreo("max.55@live.com.mx", "Actualización de curso - aviso sistema", "Se realizó la actualización al curso con ID: "+dto.getEntidad().getIdCurso()+"\t con nombre: "+dto.getEntidad().getNombreCurso());
                listaDeCursos(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarCurso(HttpServletRequest request, HttpServletResponse response) {
        CursoDAO dao = new CursoDAO();
        CursoDTO dto = new CursoDTO();
        InstructorDAO profeDAO = new InstructorDAO();
        InstructorDTO profeDTO = new InstructorDTO();
        dto.getEntidad().setIdCurso(request.getParameter("id"));
        RequestDispatcher vista = request.getRequestDispatcher("/cursos/datosCursos.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("curso", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CursosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarReporteCurso(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarGraficaCurso(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
