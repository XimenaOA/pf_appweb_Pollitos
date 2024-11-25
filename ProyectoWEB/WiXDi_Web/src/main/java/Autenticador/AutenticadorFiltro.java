/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Autenticador;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AutenticadorFiltro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización si es necesaria
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // URL de la página de registro/inicio de sesión
        String registrarURI = httpRequest.getContextPath() + "/JSP/Registrar.jsp";

        // Permitir acceso a Registrar.jsp sin verificación
        if (httpRequest.getRequestURI().equals(registrarURI)) {
            chain.doFilter(request, response);
            return;
        }

        // Verificar la sesión del usuario
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("usuario") == null) {
            // Redirigir a Registrar.jsp si no hay sesión activa
            httpResponse.sendRedirect(registrarURI);
            return;
        }

        // Continuar con el flujo normal
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Liberar recursos si es necesario
    }
}
