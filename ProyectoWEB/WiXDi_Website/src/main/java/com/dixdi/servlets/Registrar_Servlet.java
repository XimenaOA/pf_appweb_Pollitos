/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dixdi.servlets;

import control.Fachada;
import control.IFachada;
import dominio.Estado;
import dominio.Municipio;
import dominio.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author haloa
 */
public class Registrar_Servlet extends HttpServlet {
 IFachada fachada;
    
    @Override
    public void init() throws ServletException {
        super.init();
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
      String action = request.getParameter("action");
        System.out.println("si cayu");
//        if (action == null) {
//            response.sendRedirect("error.jsp");
//        } else {
                    registrarUsuario(request, response);    
                    response.sendRedirect("registrar.jsp");
    }
    

    
    private void registrarUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = contruirUsuario(request, response);
        
        fachada.agregarUsuario(usuario);
        System.out.println("SE MANDO EL USUARIO");
    }

    public Usuario contruirUsuario(HttpServletRequest request, HttpServletResponse response) {
        Usuario usuario;

        String nombre = request.getParameter("nombre");
        String apellidoPaterno = request.getParameter("apellidoPaterno");
        String apellidoMaterno = request.getParameter("apellidoMaterno");
        String estado = request.getParameter("estado");
        String municipio = request.getParameter("municipio");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        String telefono = request.getParameter("telefono");
        String genero = request.getParameter("genero");

        String avatar = "";
        String fechaNacimiento = request.getParameter("fechaNacimiento");
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = null;

        try {
            fecha = formato.parse(fechaNacimiento);
        } catch (ParseException ex) {
            Logger.getLogger(Registrar_Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario.Genero gen = null;
        if(genero.equalsIgnoreCase("masculino")){
            gen = Usuario.Genero.MASCULINO;
        } else if(genero.equalsIgnoreCase("femenino")){
            gen = Usuario.Genero.FEMENINO;
        } else if (genero.equalsIgnoreCase("no especificado")){
            gen = Usuario.Genero.NO_ESPECIFICADO;
        }
        
        Usuario.Rol rol = Usuario.Rol.NORMAL;
        
        usuario = new Usuario(nombre,apellidoPaterno,apellidoMaterno,correo,contrasena,telefono,avatar,fecha,gen,rol,
                new Municipio(municipio, new Estado(estado)));
        System.out.println("Se creo el usuario");
        return usuario; 
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

}
