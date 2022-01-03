/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.EstudianteDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InstructorDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.EstudianteDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InstructorDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author FACTORING
 */
@WebServlet(name = "SesionesServlet", urlPatterns = {"/SesionesServlet"})
public class SesionesServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            if (accion.equals("registroAlumno")) {
                registrarAlumno(request, response);
            } else {
                if (accion.equals("registroProfesor")) {
                    registrarProfesor(request, response);
                } else {
                    if (accion.equals("registro")) {
                        registro(request, response);
                    } else {
                        if (accion.equals("cerrarSesion")) {
                            cerrarSesion(request, response);
                        } else {
                            if (accion.equals("inicioSesion")) {
                                inicioSesion(request, response);
                            } else {
                                if (accion.equals("inicioSesionAlumno")) {
                                    inicioSesionAlumno(request, response);
                                } else {
                                    if (accion.equals("inicioSesionProfesor")) {
                                        inicioSesionProfesor(request, response);
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

    private void registro(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/signin/registroForm.jsp");
        request.setAttribute("modificar", 0);
        try {
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("index.jsp");
        request.getSession().removeAttribute("dto");
        request.getSession().removeAttribute("type");

        try {
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void inicioSesion(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/signin/login.jsp");

        try {
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void inicioSesionAlumno(HttpServletRequest request, HttpServletResponse response) {
       EstudianteDAO dao = new EstudianteDAO();
       EstudianteDTO dto = new EstudianteDTO();
       dto.getEntidad().setPassEstudiante(request.getParameter("txtPassAlumno"));
       dto.getEntidad().setCorreo(request.getParameter("txtCorreoAlumno"));
       try {
            if (dao.validate(dto)) {
                request.getSession().setAttribute("dto", dto);
                request.getSession().setAttribute("type", "estudiante");
                request.setAttribute("mensaje", "Creación de instructor, ¡Exitosa!");
                response.sendRedirect(request.getContextPath() + "/estudiante/dashboardEstudiante.jsp");
            } else {
                
                RequestDispatcher vista = request.getRequestDispatcher("/signin/login.jsp");
                vista.forward(request, response);
            }
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void inicioSesionProfesor(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        dto.getEntidad().setPass(request.getParameter("txtPassInstructor"));
        dto.getEntidad().setCorreo(request.getParameter("txtCorreoInstructor"));
        try {
            if (dao.validate(dto)) {
                request.getSession().setAttribute("dto", dto);
                request.getSession().setAttribute("type", "profesor");
                request.setAttribute("mensaje", "Creación de instructor, ¡Exitosa!");
                response.sendRedirect(request.getContextPath() + "/instructores/bienvenida.jsp");
            } else {
                
                RequestDispatcher vista = request.getRequestDispatcher("/signin/login.jsp");
                vista.forward(request, response);
            }
        } catch (ServletException | IOException | SQLException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

    private void registrarProfesor(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        dto.getEntidad().setPass(request.getParameter("txtPassInstructor"));
        dto.getEntidad().setNombre(request.getParameter("txtNombreInstructor"));
        dto.getEntidad().setApPat(request.getParameter("txtApPatInstructor"));
        dto.getEntidad().setApMat(request.getParameter("txtApMatInstructor"));
        dto.getEntidad().setCalle(request.getParameter("txtCalleInstructor"));
        dto.getEntidad().setNumExt(Integer.parseInt(request.getParameter("txtNumExtInstructor")));
        dto.getEntidad().setCodPost(Integer.parseInt(request.getParameter("txtCodPostInstructor")));
        dto.getEntidad().setDelegacion(request.getParameter("txtDelegacionInstructor"));
        dto.getEntidad().setTelefono(request.getParameter("txtTelefonoInstructor"));
        dto.getEntidad().setCorreo(request.getParameter("txtCorreoInstructor"));
        try {
            if (dao.exist(dto)) {
                request.setAttribute("ifExiste", true);
                RequestDispatcher vista = request.getRequestDispatcher("/signin/registroForm.jsp");
                vista.forward(request, response);
            } else {
                dao.create(dto);
                request.getSession().setAttribute("dto", dto);
                request.getSession().setAttribute("type", "profesor");
                request.setAttribute("mensaje", "Creación de instructor, ¡Exitosa!");
                response.sendRedirect(request.getContextPath() + "/instructores/bienvenida.jsp");

            }
        } catch (IOException | ServletException | SQLException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void registrarAlumno(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();

        dto.getEntidad().setNombre(request.getParameter("txtnombreE"));
        dto.getEntidad().setApPatE(request.getParameter("txtapPatE"));
        dto.getEntidad().setApMatE(request.getParameter("txtapMatE"));
        dto.getEntidad().setCorreo(request.getParameter("txtcorreo"));
        dto.getEntidad().setPassEstudiante(request.getParameter("txtpassEstudiante"));
        dto.getEntidad().setTelefono(request.getParameter("txttelefono"));
        dto.getEntidad().setFechaNacimiento(request.getParameter("txtfechaNacimiento"));

        try {
            if (dao.exist(dto)) {
                request.setAttribute("ifExiste", true);
                RequestDispatcher vista = request.getRequestDispatcher("/signin/registroForm.jsp");
                vista.forward(request, response);
            } else {
                dao.create(dto);
                request.getSession().setAttribute("dto", dto);
                request.getSession().setAttribute("type", "estudiante");
                response.sendRedirect(request.getContextPath() + "/estudiante/dashboardEstudiante.jsp");
            }
        } catch (IOException | SQLException | ServletException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
