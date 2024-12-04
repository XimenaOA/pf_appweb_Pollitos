/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import control.Fachada;
import control.IFachada;
import dominio.Comentario;
import dominio.Post;
import dominio.Usuario;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author haloa
 */
public class CrearComentarioServlet extends HttpServlet {

    IFachada fachada;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        fachada = new Fachada();
    }

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CrearComentarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearComentarioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        // Obtener los parámetros del formulario
        System.out.println("Ya entro al Servlet de comentarios");

        try {
            // Obtener el contenido del comentario
            String content = request.getParameter("contenido");
            int postId = Integer.parseInt(request.getParameter("postId")); // ID del post al que pertenece el comentario

            // Obtener la sesión y el usuario autenticado
            HttpSession objSesion = request.getSession(false);
            Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;

            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false, \"error\": \"Usuario no autenticado\"}");
                return;
            }

            // Obtener el post al que se le va a agregar el comentario
            Post post = fachada.consultarPost(postId);

            if (post == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false, \"error\": \"Post no encontrado\"}");
                return;
            }

            // Crear el objeto Comentario
            Comentario newComentario = new Comentario();
            newComentario.setContenido(content);
            newComentario.setPost(post);
            newComentario.setUsuario(usuario);

            Comentario comentatio = new Comentario(new Date(), content, usuario, post, null);

            // Usar la fachada de comentarios para agregar el comentario
            fachada.agregarComentario(comentatio, post);

            // Responder con éxito
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": true}");
            System.out.println("Comentario agregado con éxito");

        } catch (Exception e) {
            // En caso de error, responder con un mensaje adecuado
            System.out.println("Error al crear el comentario: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": false, \"error\": \"Hubo un problema al crear el comentario.\"}");
        }
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

}
