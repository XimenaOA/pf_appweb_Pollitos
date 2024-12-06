/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.1
 * Generated at: 2024-12-06 22:18:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import org.apache.commons.text.StringEscapeUtils;

public final class Registrar_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("org.apache.commons.text.StringEscapeUtils");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <title>Login y Registro</title>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap\" rel=\"stylesheet\" />\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../CSS/LogInstyle.css\" />\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <main>\r\n");
      out.write("            <div class=\"contenedor__todo\">\r\n");
      out.write("                <div class=\"caja__trasera\">\r\n");
      out.write("                    <div class=\"caja__trasera-login\">\r\n");
      out.write("                        <h3>¿Ya tienes una cuenta?</h3>\r\n");
      out.write("                        <p>Inicia sesión para hablar con la comunidad</p>\r\n");
      out.write("                        <button id=\"btn__iniciar-sesion\">Iniciar Sesión</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"caja__trasera-register\">\r\n");
      out.write("                        <h3>¿Aún no tienes una cuenta?</h3>\r\n");
      out.write("                        <p>Regístrate para que puedas unirte a la comunidad</p>\r\n");
      out.write("                        <button id=\"btn__registrarse\">Registrarse</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!--Formulario de Login y registro-->\r\n");
      out.write("                <div class=\"contenedor__login-register\">\r\n");
      out.write("                    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/IniciarSesion_Servlet\" method=\"GET\" class=\"formulario__login\">\r\n");
      out.write("                        <h2>Iniciar Sesión</h2>\r\n");
      out.write("                        <input type=\"text\" name=\"correo\" placeholder=\"Correo Electrónico\" \r\n");
      out.write("                               required \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" />\r\n");
      out.write("                        <br />\r\n");
      out.write("                        <input type=\"password\" name=\"contrasena\" placeholder=\"Contraseña\" required />\r\n");
      out.write("                        <br />\r\n");
      out.write("                        <button type=\"submit\">Entrar</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                    <!--Formulario de registro-->\r\n");
      out.write("                    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (jakarta.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Registrar_Servlet\" method=\"POST\" class=\"formulario__register\" enctype=\"multipart/form-data\">\r\n");
      out.write("                        <h2>Regístrate</h2>\r\n");
      out.write("                        <!-- Contenedor de alerta para mensajes de registro -->\r\n");
      out.write("                        <div id=\"registro_alerta\" style=\"display: none; text-align: center; font-weight: bold; margin-bottom: 20px;\"></div>\r\n");
      out.write("\r\n");
      out.write("                        <input type=\"text\" name=\"nombre\" placeholder=\"Nombre\" \r\n");
      out.write("                               required \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" /><br />\r\n");
      out.write("                        <input type=\"text\" name=\"apellidoPaterno\" placeholder=\"Apellido Paterno\" \r\n");
      out.write("                               required \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" /><br />\r\n");
      out.write("                        <input type=\"text\" name=\"apellidoMaterno\" placeholder=\"Apellido Materno\" \r\n");
      out.write("                               required \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" /><br />\r\n");
      out.write("                        <input type=\"email\" name=\"correo\" placeholder=\"Correo Electrónico\" required /><br />\r\n");
      out.write("                        <input type=\"password\" name=\"contrasena\" placeholder=\"Contraseña\" required /><br />\r\n");
      out.write("                        <input type=\"tel\" name=\"telefono\" placeholder=\"Teléfono\" \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" /><br />\r\n");
      out.write("                        <label for=\"avatar\">Avatar:</label>\r\n");
      out.write("                        <input type=\"file\" name=\"avatar\" id=\"avatar\" accept=\"image/*\" /><br />\r\n");
      out.write("                        <input type=\"text\" name=\"municipio\" placeholder=\"Municipio\" \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" /><br />\r\n");
      out.write("                        <input type=\"text\" name=\"estado\" placeholder=\"Estado\" \r\n");
      out.write("                               oninput=\"this.value = this.value.replace(/[<>'\\\"/&]/g, '')\" /><br />\r\n");
      out.write("                        <label for=\"fechaNacimiento\">Fecha de Nacimiento:</label>\r\n");
      out.write("                        <input type=\"date\" name=\"fechaNacimiento\" id=\"fechaNacimiento\" /><br />\r\n");
      out.write("                        <label for=\"genero\">Género:</label>\r\n");
      out.write("                        <select name=\"genero\" id=\"genero\">\r\n");
      out.write("                            <option value=\"masculino\">Masculino</option>\r\n");
      out.write("                            <option value=\"femenino\">Femenino</option>\r\n");
      out.write("                            <option value=\"otro\">No especificado</option>\r\n");
      out.write("                        </select><br />\r\n");
      out.write("                        <button type=\"submit\">Registrarse</button>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </main>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"../JS/LogIn.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
