/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import control.Fachada;
import control.IFachada;
import dominio.Post;
import dominio.Usuario;
import enums.Categoria;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Date;
import javax.imageio.ImageIO;

/**
 *
 * @author haloa
 */
public class CrearPostServlet extends HttpServlet {

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
            out.println("<title>Servlet CrearPostServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CrearPostServlet at " + request.getContextPath() + "</h1>");
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
        System.out.println("Ya entro al Ssrvlet de publicaciones");
        String content = request.getParameter("content");

        // Obtener el archivo de la imagen
        Part filePart = request.getPart("image"); // Esto es el archivo enviado
        InputStream fileContent = filePart.getInputStream();

        // Llamar a tus métodos para comprimir la imagen y convertirla a Base64
        BufferedImage image = ImageIO.read(fileContent);
        BufferedImage compressedImage = compressImage(image, 800, 600); // Ajusta el tamaño de la imagen
        String base64Image = convertToBase64(compressedImage, "JPEG");

        HttpSession objSesion = request.getSession(false);
        Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;

        // Crear el objeto Post y agregarlo a la base de datos
        Post newPost = new Post(
                new Date(),
                content,
                false,
                base64Image,
                Categoria.Valorant,
                usuario // Asegúrate de obtener el usuario desde la sesión
        );

        // Agregar el post a la base de datos
        fachada.agregarPost(newPost);

        // Responder al cliente
        response.setContentType("application/json");
        response.getWriter().write("{\"message\": \"Post creado exitosamente.\"}");
    }
    // Método para comprimir la imagen (ajustar tamaño)

    private BufferedImage compressImage(BufferedImage originalImage, int width, int height) {
        BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, width, height, null);
        g2d.dispose();
        return resizedImage;
    }

    // Método para convertir la imagen comprimida a Base64
    private String convertToBase64(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, format, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
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
