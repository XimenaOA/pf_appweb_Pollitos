/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import control.Fachada;
import control.IFachada;
import dominio.Comentario;
import dominio.Post;
import dominio.Usuario;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *
 * @author haloa
 */
@MultipartConfig // Habilitar la carga de archivos
public class CrearComentarioHijo extends HttpServlet {

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
            out.println("<title>Servlet CrearComentarioHijo</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearComentarioHijo at " + request.getContextPath() + "</h1>");
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
        System.out.println("Ya entro al Servlet de comentarios hijos");

        try {
            // Obtener el contenido del comentario

            int postId = Integer.parseInt(request.getParameter("postID")); // ID del post al que pertenece el comentario
            System.out.println("ID del POST: " + postId);

            int postHijojId = Integer.parseInt(request.getParameter("parentCommentId")); // ID del post al que pertenece el comentario
            System.out.println("ID del comentario hijo: " + postHijojId);

            String content = request.getParameter("comentario");
            System.out.println("Contenido de la respuesta: " + content);

            // Obtener la sesión y el usuario autenticado
            HttpSession objSesion = request.getSession(false);
            Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;

            System.out.println("hasta aqui todo bien");

            if (usuario == null) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false}");
                return;
            }

            // Obtener el post al que se le va a agregar el comentario
            Post post = fachada.consultarPost(postId);

            if (post == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false}");
                return;
            }

            Comentario comentarioPadre = fachada.consultarComentario(postHijojId);

            if (comentarioPadre == null) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.setContentType("application/json");
                response.getWriter().write("{\"success\": false}");
                return;
            }

            // Crear el objeto Comentario
            Comentario comentatio = new Comentario(new Date(), content, usuario, post, comentarioPadre);

            // Usar la fachada de comentarios para agregar el comentario
            fachada.agregarComentarioAComentario(comentatio, comentarioPadre);

            System.out.println("Se manda a la base de datos el comentario");

            fachada.consultarComentario(postHijojId).getComentariosHijos();

            // Responder con éxito
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": true}");
            System.out.println("Comentario agregado con éxito");

        } catch (Exception e) {
            // En caso de error, responder con un mensaje adecuado
            System.out.println("Error al crear el comentario: " + e.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.setContentType("application/json");
            response.getWriter().write("{\"success\": false}");
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
