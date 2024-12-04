/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import control.Fachada;
import control.IFachada;
import dominio.Post;
import enums.Categoria;
import io.gsonfire.GsonFireBuilder;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author haloa
 */
public class ObtenerPostsServlet_Valorant extends HttpServlet {

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
            out.println("<title>Servlet ObtenerPostsServlet_Valorant</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ObtenerPostsServlet_Valorant at " + request.getContextPath() + "</h1>");
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

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String categoria = request.getParameter("categoria");

        Categoria juego = null;
        if (categoria.equalsIgnoreCase("Valorant")) {
            juego = Categoria.Valorant;
        } else if (categoria.equalsIgnoreCase("Genshin")){
            juego = Categoria.Genshin;
        } else if (categoria.equalsIgnoreCase("Overwatch")) {
            juego = Categoria.Overwatch;
        } else if (categoria.equalsIgnoreCase("LOL")) {
            juego = Categoria.LOL;
        }

        try {
            // Obtén los posts de la fachada
            List<Post> posts = fachada.consultarPostsCategoria(juego);
            Collections.reverse(posts);
            // Configura Jackson ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.findAndRegisterModules(); // Para manejar tipos como java.util.Date
            objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            // Serializa la lista de posts a JSON
            String jsonPosts = objectMapper.writeValueAsString(posts);

            // Escribe la respuesta JSON
            response.getWriter().write(jsonPosts);

        } catch (Exception e) {
            e.printStackTrace();

            // Maneja errores y responde con un código de error
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\":\"Error al obtener los posts\"}");
        }
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

}
