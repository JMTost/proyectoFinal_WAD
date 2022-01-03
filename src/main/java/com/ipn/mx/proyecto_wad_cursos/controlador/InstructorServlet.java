/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.proyecto_wad_cursos.controlador;

import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CalificacionesFinalDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CalificacionesPacrialesDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.CursoDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.EstudianteDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DAO.InstructorDAO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesFinalDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CalificacionesParcialesDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.CursoDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.EstudianteDTO;
import com.ipn.mx.proyecto_wad_cursos.modelo.DTO.InstructorDTO;
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
@WebServlet(name = "InstructorServlet", urlPatterns = {"/InstructorServlet"})
public class InstructorServlet extends HttpServlet {

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
                                    } else {
                                        if (accion.equals("mostrarReporteInstr")) {
                                            mostrarReporteInstructor(request, response);
                                        } else {
                                            if (accion.equals("mostrarGraficaInstr")) {
                                                //mostrarGraficaInstructor(request, response);
                                            } else {
                                                if (accion.equals("mostrarBienvenida")) {
                                                    mostrarBienvenida(request, response);
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
                                                                    } else {
                                                                        if (accion.equals("nuevaCalP")) {
                                                                            agregarCalPar(request, response);
                                                                        } else {
                                                                            if (accion.equals("eliminarCalP")) {
                                                                                eliminarCalPar(request, response);
                                                                            } else {
                                                                                if (accion.equals("actualizarCalP")) {
                                                                                    actualizarCalPar(request, response);
                                                                                } else {
                                                                                    if (accion.equals("guardarCalP")) {
                                                                                        almacenarCalPar(request, response);
                                                                                    } else {
                                                                                        if (accion.equals("mostrarCalP")) {
                                                                                            mostrarCalPar(request, response);
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

    private void listaDeInstructores(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        Collection lista;
        try {
            lista = dao.readAll();
            request.setAttribute("listaDeInstructores", lista);
            
            RequestDispatcher rd = request.getRequestDispatcher("/instructores/listaprofe.jsp");
            rd.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void mostrarBienvenida(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/instructores/bienvenida.jsp");
        try {                      
            InstructorDTO dto = (InstructorDTO)request.getSession().getAttribute("dto1");
            
            request.setAttribute("ID",dto.getEntidad().getIdProfesor());
            request.setAttribute("Nombre",dto.getEntidad().getNombre());
            request.setAttribute("Paterno",dto.getEntidad().getApPat());
           
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(SesionesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarInstructor(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/instructores/profesoresFormulario.jsp");
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
        RequestDispatcher vista = request.getRequestDispatcher("/instructores/profesoresFormulario.jsp");
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
        RequestDispatcher vista = request.getRequestDispatcher("/instructores/datosInstructor.jsp");
        try {
            dto = dao.read(dto);
            request.setAttribute("instructor", dto);
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarReporteInstructor(HttpServletRequest request, HttpServletResponse response) {
        InstructorDAO dao = new InstructorDAO();
        InstructorDTO dto = new InstructorDTO();
        if (Integer.parseInt(request.getParameter("individual")) == 0) {

            ServletOutputStream sos;
            try {
                sos = response.getOutputStream();
                File reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/ReporteGeneralInstructor.jasper"));
                byte[] b = JasperRunManager.runReportToPdf(reporte.getPath(), null, dao.conectar());
                response.setContentType("application/pdf");
                response.setContentLength(b.length);

                sos.write(b, 0, b.length);
                sos.flush();
                sos.close();
            } catch (IOException | JRException ex) {
                Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            //Quiere ver el reporte de un instructor
            try {
                ServletOutputStream sos = response.getOutputStream();
                File reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/ReporteInstructoresxID.jasper"));
                HashMap parametros = new HashMap();
                parametros.put("idBuscarUsuarios", Integer.parseInt(request.getParameter("id")));
                byte[] b = JasperRunManager.runReportToPdf(reporte.getPath(), parametros, dao.conectar());
                response.setContentType("application/pdf");
                response.setContentLength(b.length);

                sos.write(b, 0, b.length);
                sos.flush();//flush, aztualización, 
                sos.close();

            } catch (IOException | JRException ex) {
                Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /*
    private void mostrarGraficaInstructor(HttpServletRequest request, HttpServletResponse response) {
        JFreeChart grafica = ChartFactory.createPieChart("Cursos por Instructor", obtenerCursosPorInstructor(), true, true, Locale.getDefault());
        //Declaración de donde se guardara el archivo
        String archivo = getServletConfig().getServletContext().getRealPath("/grafica_Instr.png");
        try {
            request.setAttribute("grafica", 2);
            ChartUtils.saveChartAsPNG(new File(archivo), grafica, 500, 500);
            RequestDispatcher vistas = request.getRequestDispatcher("grafica.jsp");
            vistas.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PieDataset obtenerCursosPorInstructor() {
        DefaultPieDataset dsPie = new DefaultPieDataset();
        InstructorDAO dao = new InstructorDAO();
        try {
            List datos = dao.graficarInstructorPorCurso();
            for (int i = 0; i < datos.size(); i++) {
                GraficaDTO dto = (GraficaDTO) datos.get(i);
                dsPie.setValue(dto.getNombreCategoria(), dto.getCantidad());
            }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dsPie;
    }*/
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
            mostrarBienvenida(request, response);
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
                mostrarBienvenida(request, response);
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
                mostrarBienvenida(request, response);
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
            mostrarBienvenida(request, response);
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
                mostrarBienvenida(request, response);
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
                mostrarBienvenida(request, response);
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
}

