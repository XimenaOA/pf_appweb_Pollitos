package Autenticador;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author haloa
 */
//@WebFilter("/JSP/*")
//public class AutenticacionFiltro implements Filter {
//
//    public void init(FilterConfig fConfig) throws ServletException {
//        // Inicialización
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        
//        // Excluir register.jsp del filtro
//        String requestURI = httpRequest.getRequestURI();
//        if (requestURI.endsWith("JPP/Registrar.jsp")) {
//            chain.doFilter(request, response); // Deja pasar la solicitud sin filtrar
//            return;
//        }
//
//        // Verifica si el usuario está autenticado
//        HttpSession session = httpRequest.getSession(false); 
//        if (session == null || session.getAttribute("usuario") == null) {
//            // Si no está autenticado, redirige al login
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/JSP/Registrar.jsp");
//        } else {
//            // Si está autenticado, permite el acceso
//            chain.doFilter(request, response);
//        }
//    }
//
//    public void destroy() {
//        // Limpieza si es necesario
//    }
//}


