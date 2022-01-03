/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.AdminDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.EstudianteDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InstructorDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.AdminDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.EstudianteDTO;
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
            if (accion.equals("listaDeAdminis")) {
                listaDeAdmins(request, response);
            } else {
                if (accion.equals("nuevoAdmin")) {
                    agregarAdmin(request, response);
                } else {
                    if (accion.equals("eliminarAdmin")) {
                        eliminarAdmin(request, response);
                    } else {
                        if (accion.equals("actualizarAdmin")) {
                            actualizarAdmin(request, response);
                        } else {
                            if (accion.equals("guardarAdmin")) {
                                almacenarAdmin(request, response);
                            } else {
                                if (accion.equals("mostrarAdmin")) {
                                    mostrarAdmin(request, response);
                                } else {
                                    if (accion.equals("listaDeEstudiantes")) {
                                        listaDeEstudiantes(request, response);
                                    } else {
                                        if (accion.equals("nuevoEstudiante")) {
                                            agregarEstudiante(request, response);
                                        } else {
                                            if (accion.equals("eliminarEstudiante")) {
                                                eliminarEstudiante(request, response);
                                            } else {
                                                if (accion.equals("actualizarEstudiante")) {
                                                    actualizarEstudiante(request, response);
                                                } else {
                                                    if (accion.equals("guardarEstudiante")) {
                                                        almacenarEstudiante(request, response);
                                                    } else {
                                                        if (accion.equals("mostrarEstudiante")) {
                                                            mostrarEstudiante(request, response);
                                                        } else {
                                                            if (accion.equals("listaDeInstructores")) {
                                                                listaDeInstructores(request, response);
                                                            } else {
                                                                if (accion.equals("nuevoInstr")) {
                                                                    agregarInstructor(request, response);
                                                                } else {
                                                                    if (accion.equals("eliminarInstr")) {
                                                                        eliminarInstructor(request, response);
                                                                    } else {
                                                                        if (accion.equals("actuallizarInstr")) {
                                                                            actualizarInstructor(request, response);
                                                                        } else {
                                                                            if (accion.equals("guardarInstr")) {
                                                                                almacenarInstructor(request, response);
                                                                            } else {
                                                                                if (accion.equals("mostrarInstr")) {
                                                                                    mostrarInstructor(request, response);
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
            mail.enviarCorreo("max.55@live.com.mx", "Eliminación de usuario - aviso sistema", "Se ha realizado la eliminación de un administrador.\n ID: " + dto.getEntidad().getIdAdmin() + "\n Contraseña: " + dto.getEntidad().getPassAdmin());
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
        if (Integer.parseInt(request.getParameter("modificar")) == 0) {
            dto.getEntidad().setIdAdmin(request.getParameter("txtIdAdmin"));
            dto.getEntidad().setPassAdmin(request.getParameter("txtPassAdmin"));
            try {
                dao.create(dto);
                //Solo enviamos correo al administrador inicial del sistema
                mail.enviarCorreo("max.55@live.com.mx", "Creación de nuevo administrador", "Los datos del nuevo usuario son.\n ID: " + dto.getEntidad().getIdAdmin() + " \nContraseña: " + dto.getEntidad().getPassAdmin());
                request.setAttribute("mensaje", "Creación de administrador, ¡Exitosa!");
                listaDeAdmins(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            dto.getEntidad().setIdAdmin(request.getParameter("txtIdAdmin"));
            dto.getEntidad().setPassAdmin(request.getParameter("txtPassAdmin"));
            try {
                dao.update(dto);
                mail.enviarCorreo("max.55@live.com.mx", "Actualización del administrador - aviso del sistema", "Los datos del actualizados del administrador son.\n ID: " + dto.getEntidad().getIdAdmin() + " \nContraseña: " + dto.getEntidad().getPassAdmin());
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
            request.setAttribute("admin", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaDeEstudiantes(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeEstudiantes", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/admins/listaEstudiante.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/admins/estudianteFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("id")));
        try {
            dao.delete(dto);
            mail.enviarCorreo(dto.getEntidad().getCorreo(), "Tu usuario ha sido eliminado", "Se ha eliminado el registro de tu usuariario, esperamos que hayas tenido la mejor experiencia en nuestro sistema.");
            mail.enviarCorreo("max.55@live.com.mx", "Eliminación de estudiante - aviso sistema", "Se ha realizado la eliminación de un registro de usuario, con estos datos, ID: " + dto.getEntidad().getIdEstudiante() + "\nCorrero: " + dto.getEntidad().getCorreo() + "\nContraseña: " + dto.getEntidad().getPassEstudiante());
            listaDeEstudiantes(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/admins/estudianteFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("estudiante", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        EnviarMail mail = new EnviarMail();
        if (Integer.parseInt(request.getParameter("modifcar")) == 0) {
            dto.getEntidad().setNombre(request.getParameter("txtNombreEstudiante"));
            dto.getEntidad().setApPatE(request.getParameter("txtApPatEstudiante"));
            dto.getEntidad().setApMatE(request.getParameter("txtApMatEstudiante"));
            dto.getEntidad().setTelefono(request.getParameter("txtTelEstudiante"));
            dto.getEntidad().setCorreo(request.getParameter("txtCorreoEstudiante"));
            dto.getEntidad().setPassEstudiante(request.getParameter("txtPassEstudiante"));
            dto.getEntidad().setFechaNacimiento(request.getParameter("txtFechaEstudiante"));
            try {
                dao.create(dto);
                mail.enviarCorreo(dto.getEntidad().getCorreo(), "Registro de creación satisfactorio", "Nuevo estudiante creado con exito.correo: "+dto.getEntidad().getCorreo()+"\t contraseña: "+dto.getEntidad().getPassEstudiante());
                mail.enviarCorreo("max.55@live.com.mx", "Creación de nuevo estudiante - aviso sistema", "Creación de nuevo estudiante correo: "+dto.getEntidad().getCorreo()+"\t contraseña: "+dto.getEntidad().getPassEstudiante()+"\t nombre: "+dto.getEntidad().getNombre()+" "+dto.getEntidad().getApPatE()+" "+dto.getEntidad().getApMatE());
                request.setAttribute("mensaje", "Creación de estudiante, ¡Exitoso!");
                listaDeEstudiantes(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            dto.getEntidad().setNombre(request.getParameter("txtNombreEstudiante"));
            dto.getEntidad().setApPatE(request.getParameter("txtApPatEstudiante"));
            dto.getEntidad().setApMatE(request.getParameter("txtApMatEstudiante"));
            dto.getEntidad().setTelefono(request.getParameter("txtTelEstudiante"));
            dto.getEntidad().setCorreo(request.getParameter("txtCorreoEstudiante"));
            dto.getEntidad().setPassEstudiante(request.getParameter("txtPassEstudiante"));
            dto.getEntidad().setFechaNacimiento(request.getParameter("txtFechaEstudiante"));
            dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("txtIdEstudiante")));
            try {
                dao.update(dto);
                mail.enviarCorreo(dto.getEntidad().getCorreo(), "Actualización de creación satisfactorio", "Actualización de estudiante con exito.correo: "+dto.getEntidad().getCorreo()+"\t contraseña: "+dto.getEntidad().getPassEstudiante());
                mail.enviarCorreo("max.55@live.com.mx", "Actualización de estudiante - aviso sistema", "Actualización de estudiante correo: "+dto.getEntidad().getCorreo()+"\t contraseña: "+dto.getEntidad().getPassEstudiante()+"\t nombre: "+dto.getEntidad().getNombre()+" "+dto.getEntidad().getApPatE()+" "+dto.getEntidad().getApMatE());
                request.setAttribute("mensaje", "Actualización del estudiante, ¡Exitosa!");
                listaDeEstudiantes(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/admins/datosEstudiante.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("estudiante", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaDeInstructores(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeInstructores", lista);
            
            RequestDispatcher rd = request.getRequestDispatcher("/admins/listaprofe.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void agregarInstructor(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/admins/profesoresFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void eliminarInstructor(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("idInstructor")));
        try {
            dao.delete(dto);
            listaDeInstructores(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void actualizarInstructor(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/admins/profesoresFormulario.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("instructor", dto);
            request.setAttribute("modificar", 1);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarInstructor(HttpServletRequest request, HttpServletResponse response) {
        EnviarMail mail = new EnviarMail();
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        if (Integer.parseInt(request.getParameter("modificar")) == 0) {
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
                dao.create(dto);
                mail.enviarCorreo(request.getParameter("txtCorreoInstructor"), "Registro de instructor satisfactorio", "Nuevo instructor creado con exito");
                mail.enviarCorreo("Correo del admin", "Creacion de Instructor - aviso sistema", "Creación de nuevo profesor correo:  " + request.getParameter("txtCorreoInstructor") + " contraseña: " + request.getParameter("txtPassInstructor"));
                request.setAttribute("mensaje", "Creación de instructor, ¡Exitosa!");
                listaDeInstructores(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
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
            dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("txtIdProfesor")));
            try {
                dao.update(dto);
                mail.enviarCorreo(request.getParameter("txtCorreoInstructor"), "Actualización de instructor satisfactorio", "Actualización de datos con exito");
                mail.enviarCorreo("Correo del admin", "Actualización de Instructor - aviso sistema", "Actualización del usuario-profesor con ID: " + request.getParameter("txtIdProfesor") + " correo:  " + request.getParameter("txtCorreoInstructor") + " contraseña: " + request.getParameter("txtPassInstructor"));
                request.setAttribute("mensaje", "Actualización del instructor, ¡Exitosa!");
                listaDeInstructores(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void mostrarInstructor(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        dto.getEntidad().setIdProfesor(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher vista = request.getRequestDispatcher("/admins/datosInstructor.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("instructor", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
