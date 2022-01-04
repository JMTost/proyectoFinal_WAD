/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CalificacionesFinalDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.EstudianteDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InscripcionCursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesFinalDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CursoDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.EstudianteDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InscripcionCursoDTO;
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
@WebServlet(name = "EstudianteServlet", urlPatterns = {"/EstudianteServlet"})
public class EstudianteServlet extends HttpServlet {

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
            boolean var;
            String accion = request.getParameter("accion");
            if (request.getSession().getAttribute("type") == null) {
                var = true;
            } else {
                var = false;
            }

            if (var) {
                RequestDispatcher vista = request.getRequestDispatcher("/signin/login.jsp");
                vista.forward(request, response);
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
                                    if (accion.equals("mostrarReporteEstudiante")) {
                                        mostrarReporteEstudiante(request, response);
                                    } else {
                                        if (accion.equals("mostrarGraficaEstudiante")) {
                                            mostrarGraficaEstudiante(request, response);
                                        } else {
                                            if (accion.equals("mostrarBienvenida")) {
                                                mostrarBienvenida(request, response);
                                            } else {
                                                if (accion.equals("inscribirseCurso")) {
                                                    //creaar metodo de inscribirse
                                                    inscribirseAcurso(request, response);
                                                }else{
                                                    if(accion.equals("listaDeCursos")){
                                                        //crear metodo de listas de cursos
                                                        listaDeCursosEstudiante(request, response);
                                                    }else{
                                                        if(accion.equals("guardarInsripcion")){
                                                            almacenarInscripcionEstudiante(request, response);
                                                        }else{
                                                            if(accion.equals("eliminarInscripcion")){
                                                                eliminarInscripcionEstudiante(request, response);
                                                            }else{
                                                                if(accion.equals("mostrarCalFinal")){
                                                                    mostrarCalFinal(request, response);
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

    private void listaDeEstudiantes(HttpServletRequest request, HttpServletResponse response) {
        EstudianteDAO dao = new EstudianteDAO();
        EstudianteDTO dto = new EstudianteDTO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeEstudiantes", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/estudiante/listaEstudiante.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarBienvenida(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/estudiante/dashboardEstudiante.jsp");
        try {
            EstudianteDTO dto = (EstudianteDTO) request.getSession().getAttribute("dto1");

            request.setAttribute("ID", dto.getEntidad().getIdEstudiante());
            request.setAttribute("Nombre", dto.getEntidad().getNombre());
            request.setAttribute("Paterno", dto.getEntidad().getApPatE());

            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarEstudiante(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/estudiante/estudianteFormulario.jsp");
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
        RequestDispatcher vista = request.getRequestDispatcher("/estudiante/estudianteFormulario.jsp");
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
                mail.enviarCorreo(dto.getEntidad().getCorreo(), "Registro de creación satisfactorio", "Nuevo estudiante creado con exito.correo: " + dto.getEntidad().getCorreo() + "\t contraseña: " + dto.getEntidad().getPassEstudiante());
                mail.enviarCorreo("max.55@live.com.mx", "Creación de nuevo estudiante - aviso sistema", "Creación de nuevo estudiante correo: " + dto.getEntidad().getCorreo() + "\t contraseña: " + dto.getEntidad().getPassEstudiante() + "\t nombre: " + dto.getEntidad().getNombre() + " " + dto.getEntidad().getApPatE() + " " + dto.getEntidad().getApMatE());
                request.setAttribute("mensaje", "Creación de estudiante, ¡Exitoso!");
                listaDeEstudiantes(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
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
                mail.enviarCorreo(dto.getEntidad().getCorreo(), "Actualización de creación satisfactorio", "Actualización de estudiante con exito.correo: " + dto.getEntidad().getCorreo() + "\t contraseña: " + dto.getEntidad().getPassEstudiante());
                mail.enviarCorreo("max.55@live.com.mx", "Actualización de estudiante - aviso sistema", "Actualización de estudiante correo: " + dto.getEntidad().getCorreo() + "\t contraseña: " + dto.getEntidad().getPassEstudiante() + "\t nombre: " + dto.getEntidad().getNombre() + " " + dto.getEntidad().getApPatE() + " " + dto.getEntidad().getApMatE());
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
        RequestDispatcher vista = request.getRequestDispatcher("/estudiante/datosEstudiante.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("estudiante", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarReporteEstudiante(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarGraficaEstudiante(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void inscribirseAcurso(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/estudiante/inscripcionCursoFormulario.jsp");
        try {
            request.setAttribute("modificar", 0);
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void listaDeCursosEstudiante(HttpServletRequest request, HttpServletResponse response) {
        InscripcionCursoDAO dao = new InscripcionCursoDAO();
        InscripcionCursoDTO dto = new InscripcionCursoDTO();
        Collection lista;
        try {
            dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("id")));
            lista = dao.readAlInscripcionporEstudiante(dto);
            request.setAttribute("listaCursos", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/estudiante/listaCursos.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarInscripcionEstudiante(HttpServletRequest request, HttpServletResponse response) {
        InscripcionCursoDAO dao = new InscripcionCursoDAO();
        InscripcionCursoDTO dto = new InscripcionCursoDTO();
        EstudianteDTO estDTO = new EstudianteDTO();
        EstudianteDAO estDAO = new EstudianteDAO();
        CursoDAO cursoDao = new CursoDAO();
        CursoDTO cursoDto = new CursoDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdCurso(request.getParameter("idCurso"));
        dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("IdEstudiante")));
        if(Integer.parseInt(request.getParameter("modificar"))==0){
            dto.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
            dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("txtIdEstudiante")));
            estDTO.getEntidad().setIdEstudiante(dto.getEntidad().getIdEstudiante());
            cursoDto.getEntidad().setIdCurso(dto.getEntidad().getIdCurso());
            try {
                CalificacionesFinalDAO dao2 = new CalificacionesFinalDAO();
                CalificacionesFinalDTO dto2 = new CalificacionesFinalDTO();
                dto2.getEntidad().setIdCurso(request.getParameter("txtIdCurso"));
                dto2.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("txtIdEstudiante")));
                dto2.getEntidad().setCalF(0);
                dao2.create(dto2);
                dao.create(dto);
                estDTO = estDAO.read(estDTO);
                cursoDto = cursoDao.read(cursoDto);
                //confirmación de creación
                mail.enviarCorreo(estDTO.getEntidad().getCorreo(), "Creación de inscripción", "Se ha realizado la inscripción de forma correcta al curso: "+dto.getEntidad().getIdCurso()+", con nombre: "+cursoDto.getEntidad().getNombreCurso());
                mail.enviarCorreo("max.55@live.com.mx", "Creación de inserción de inscripción a curso - aviso sistema", "Se ha realizado la inserción de la inscripción de curso, el estudiante con id: "+estDTO.getEntidad().getIdEstudiante()+", al curso: "+dto.getEntidad().getIdCurso());
                request.setAttribute("mensaje", "Creación de inscripción a curso, ¡Exitosa!");
                mostrarBienvenida(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void eliminarInscripcionEstudiante(HttpServletRequest request, HttpServletResponse response) {
        InscripcionCursoDAO dao = new InscripcionCursoDAO();
        InscripcionCursoDTO dto = new InscripcionCursoDTO();
        EstudianteDTO estDTO = new EstudianteDTO();
        EstudianteDAO estDAO = new EstudianteDAO();
        CursoDAO cursoDao = new CursoDAO();
        CursoDTO cursoDto = new CursoDTO();
        EnviarMail mail = new EnviarMail();
        dto.getEntidad().setIdCurso(request.getParameter("id"));
        try {
            dao.delete(dto);
            listaDeCursosEstudiante(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarCalFinal(HttpServletRequest request, HttpServletResponse response) {
        CalificacionesFinalDAO dao = new CalificacionesFinalDAO();
        CalificacionesFinalDTO dto = new CalificacionesFinalDTO();
        Collection lista;
        dto.getEntidad().setIdEstudiante(Integer.parseInt(request.getParameter("id")));
        //System.out.println(dto);
        try {
            lista = dao.readALLxEstudiantes(dto);
            request.setAttribute("listaCalificacionesFinal", lista);
            RequestDispatcher rd = request.getRequestDispatcher("/estudiante/listaCalFinales.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(EstudianteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

