/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import control.Fachada;
import control.IFachada;
import dominio.Estado;
import dominio.Municipio;
import dominio.Usuario;
import jakarta.servlet.ServletConfig;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haloa
 */
@MultipartConfig // Habilitar la carga de archivos
public class Registrar_Servlet extends HttpServlet {

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
            out.println("<title>Servlet Registrar_Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrar_Servlet at " + request.getContextPath() + "</h1>");
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
           Usuario usuario;

        // Obtener parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");
        String fechaNacimiento = request.getParameter("fechaNacimiento");

        // Procesar la fecha
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;
        try {
            fecha = formato.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Registrar_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Determinar el género
        Usuario.Genero gen = null;
        if (genero.equalsIgnoreCase("masculino")) {
            gen = Usuario.Genero.MASCULINO;
        } else if (genero.equalsIgnoreCase("femenino")) {
            gen = Usuario.Genero.FEMENINO;
        } else if (genero.equalsIgnoreCase("no especificado")) {
            gen = Usuario.Genero.NO_ESPECIFICADO;
        }

        // Establecer el rol
        Usuario.Rol rol = Usuario.Rol.NORMAL;

        // Procesar la imagen (archivo subido)
        Part filePart = request.getPart("avatar"); // Nombre del campo del formulario
        String avatar = "";  // Esto contendrá la imagen en formato Base64

        if (filePart != null && filePart.getSize() > 0) {
            // Leer los bytes del archivo
            InputStream inputStream = filePart.getInputStream();
            byte[] avatarBytes = inputStream.readAllBytes();

            // Convertir a Base64
            avatar = Base64.getEncoder().encodeToString(avatarBytes);
        }

        // Crear el objeto Usuario
        usuario = new Usuario(nombre, apellidoPaterno, apellidoMaterno, correo, contrasena, telefono, avatar, fecha, gen, rol,
                new Municipio(municipio, new Estado(estado)));

        // Registrar el usuario en la base de datos
        System.out.println("Se creo el usuario");
        fachada.agregarUsuario(usuario);

        // Redirigir a la página de registro
        response.sendRedirect("JSP/Registrar.jsp");
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
