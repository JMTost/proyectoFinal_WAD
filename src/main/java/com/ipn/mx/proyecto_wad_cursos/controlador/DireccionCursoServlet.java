/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.DireccionCursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InstructorDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CursoDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.DireccionCursoDTO;
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
@WebServlet(name = "DireccionCursoServlet", urlPatterns = {"/DireccionCursoServlet"})
public class DireccionCursoServlet extends HttpServlet {

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
            if (accion.equals("listaDeDireccionesC")) {
                listaDeDireccionesC(request, response);
            } else {
                if (accion.equals("nuevaDireccionC")) {
                    agregarDireccionC(request, response);
                } else {
                    if (accion.equals("eliminarDireccionC")) {
                        eliminarDireccionC(request, response);
                    } else {
                        if (accion.equals("actualizarDireccionC")) {
                            actualizarDireccionC(request, response);
                        } else {
                            if (accion.equals("guardarDireccionC")) {
                                almacenarDireccionC(request, response);
                            } else {
                                if (accion.equals("mostrarDireccionC")) {
                                    mostrarDireccionC(request, response);
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

    private void listaDeDireccionesC(HttpServletRequest request, HttpServletResponse response) {
        DireccionCursoDAO dao = new DireccionCursoDAO();
        DireccionCursoDTO dto = new DireccionCursoDTO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeDireccionesC", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/direcciones/listaDireccionesC.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarDireccionC(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/direcciones/direccionesCursosFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarDireccionC(HttpServletRequest request, HttpServletResponse response) {
        DireccionCursoDAO dao = new DireccionCursoDAO();
        DireccionCursoDTO dto = new DireccionCursoDTO();
        InstructorDAO profeDAO = new InstructorDAO();
        InstructorDTO profeDTO = new InstructorDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdDir(Integer.parseInt(request.getParameter("id")));
        try {
            dao.delete(dto);
            profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
            profeDTO = profeDAO.read(profeDTO);
            mail.enviarCorreo(profeDTO.getEntidad().getCorreo(), "Eliminación de direción", "Se ha eliminado la dirección del curso en el que eres instructor");
            mail.enviarCorreo("max.55@live.com.mx", "Eliminación de direccion de curso- aviso sistema", "Se ha eliminado la dirección del curso: " + dto.getEntidad().getIdCurso());
            listaDeDireccionesC(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarDireccionC(HttpServletRequest request, HttpServletResponse response) {
        DireccionCursoDAO dao = new DireccionCursoDAO();
        DireccionCursoDTO dto = new DireccionCursoDTO();
        dto.getEntidad().setIdDir(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/direcciones/direccionesCursosFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("direccion", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarDireccionC(HttpServletRequest request, HttpServletResponse response) {
        DireccionCursoDAO dao = new DireccionCursoDAO();
        DireccionCursoDTO dto = new DireccionCursoDTO();
        InstructorDAO profeDAO = new InstructorDAO();
        InstructorDTO profeDTO = new InstructorDTO();
        CursoDAO cursoDAO = new CursoDAO();
        CursoDTO cursoDTO = new CursoDTO();
        EnviarMail mail = new EnviarMail();
        if (Integer.parseInt(request.getParameter("modificar")) == 0) {
            dto.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("txtIdProfesor")));
            dto.getEntidad().setLinkLlamada(request.getParameter("txtEnlaceLlamada"));
            dto.getEntidad().setNombrePlat(request.getParameter("txtNombrePlat"));
            dto.getEntidad().setPassLlamada(request.getParameter("txtPassLlamada"));
            try {
                dao.create(dto);
                cursoDTO.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
                profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
                profeDTO = profeDAO.read(profeDTO);
                cursoDTO = cursoDAO.read(cursoDTO);
                mail.enviarCorreo(profeDTO.getEntidad().getCorreo(), "Creación de direccion de curso", "Los datos de la dirección del curso son. Nombre de la plataforma: " + dto.getEntidad().getNombrePlat() + "\n Enlace de la llamada: " + dto.getEntidad().getLinkLlamada() + "\nContraseña de la llamada: " + dto.getEntidad().getPassLlamada() + "\n Del curso: " + cursoDTO.getEntidad().getNombreCurso());
                mail.enviarCorreo("max.55@live.com.mx", "Creación de dirección de curso - aviso sistema", "Se ha creado de forma exitosa la dirección del curso. ID: " + dto.getEntidad().getIdCurso() + "\n Del curso: " + cursoDTO.getEntidad().getIdCurso() + "\t con nombre: " + cursoDTO.getEntidad().getNombreCurso());
                request.setAttribute("mensaje", "Creación de dirección de curso, ¡Exitosa!");
                listaDeDireccionesC(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dto.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("txtIdProfesor")));
            dto.getEntidad().setLinkLlamada(request.getParameter("txtEnlaceLlamada"));
            dto.getEntidad().setNombrePlat(request.getParameter("txtNombrePlat"));
            dto.getEntidad().setPassLlamada(request.getParameter("txtPassLlamada"));
            dto.getEntidad().setIdDir(Integer.parseInt(request.getParameter("txtIdDirCursos")));
            try {
                dao.update(dto);
                cursoDTO.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
                profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
                profeDTO = profeDAO.read(profeDTO);
                cursoDTO = cursoDAO.read(cursoDTO);
                mail.enviarCorreo(profeDTO.getEntidad().getCorreo(), "Actualización de direccion de curso", "Los datos de la dirección del curso son. Nombre de la plataforma: " + dto.getEntidad().getNombrePlat() + "\n Enlace de la llamada: " + dto.getEntidad().getLinkLlamada() + "\nContraseña de la llamada: " + dto.getEntidad().getPassLlamada() + "\n Del curso: " + cursoDTO.getEntidad().getNombreCurso());
                mail.enviarCorreo("max.55@live.com.mx", "Actualización de dirección de curso - aviso sistema", "Se ha actualizado de forma exitosa la dirección del curso. ID: " + dto.getEntidad().getIdCurso() + "\n Del curso: " + cursoDTO.getEntidad().getIdCurso() + "\t con nombre: " + cursoDTO.getEntidad().getNombreCurso());
                request.setAttribute("mensaje", "Actualización de la dirección del curso, ¡Exitosa!");
                listaDeDireccionesC(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarDireccionC(HttpServletRequest request, HttpServletResponse response) {
        DireccionCursoDAO dao = new DireccionCursoDAO();
        DireccionCursoDTO dto = new DireccionCursoDTO();
        InstructorDAO profeDAO = new InstructorDAO();
        InstructorDTO profeDTO = new InstructorDTO();
        CursoDAO cursoDAO = new CursoDAO();
        CursoDTO cursoDTO = new CursoDTO();
        dto.getEntidad().setIdDir(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/direcciones/datosDireccionC.jsp");
        try {
            dto = dao.read(dto);
            profeDTO.getEntidad().setIdProfesor(dto.getEntidad().getIdProfesor());
            cursoDTO.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
            profeDTO = profeDAO.read(profeDTO);
            cursoDTO = cursoDAO.read(cursoDTO);
            request.setAttribute("dir", dto);
            request.setAttribute("profesor", profeDTO);
            request.setAttribute("curso", cursoDTO);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(DireccionCursoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
