/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/11.0.1
 * Generated at: 2024-12-05 03:36:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.JSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import dominio.Usuario;
import org.apache.commons.text.StringEscapeUtils;

public final class Valorant_005fJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("dominio.Usuario");
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

    HttpSession objSesion = request.getSession(false);
    Usuario usuario = objSesion != null ? (Usuario) objSesion.getAttribute("usuario") : null;
    String currentGame = "Valorant";

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>WiXDi - Valorant</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../CSS/Comunidades.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"logo\">WiXDi Games</div>\r\n");
      out.write("            <nav>\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"window.location.href = 'MenuPrincipal.jsp';\">Perfil</a></li>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"window.location.href = 'Genshin_JSP.jsp';\" >Genshin Impact</a></li>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"window.location.href = 'Valorant_JSP.jsp';\" class=\"active\">Valorant</a></li>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"window.location.href = 'LeagueOfLegends_JSP.jsp';\">League of Legends</a></li>\r\n");
      out.write("                    <li><a href=\"#\" onclick=\"window.location.href = 'Overwatch_JSP.jsp';\">Overwatch</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("            <div class=\"user-actions\">\r\n");
      out.write("                <a href=\"#\" class=\"icon-button profile\">👤</a>\r\n");
      out.write("                <a href=\"#\" class=\"icon-button settings\">⚙️</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </header>\r\n");
      out.write("\r\n");
      out.write("        <main>\r\n");
      out.write("            <section class=\"feed\">\r\n");
      out.write("                <div class=\"post-creator\">\r\n");
      out.write("                    ");
 if (usuario != null) {
                            String avatar = (usuario.getImagen() != null && !usuario.getImagen().isEmpty())
                                    ? "data:image/png;base64," + StringEscapeUtils.escapeHtml4(usuario.getImagen())
                                    : "../imagenes/icon.png";
                    
      out.write("\r\n");
      out.write("                    <img src=\"");
      out.print( avatar);
      out.write("\" alt=\"Avatar\" class=\"avatar\">\r\n");
      out.write("                    <input type=\"text\" placeholder=\"Escribe una publicación en WiXDi Games\" class=\"post-input\">\r\n");
      out.write("                    <button type=\"button\" class=\"post-button\">📷</button>\r\n");
      out.write("                    ");
 }
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Contenedor de posts vacío -->\r\n");
      out.write("                <div class=\"posts\"></div>\r\n");
      out.write("            </section>\r\n");
      out.write("        </main>\r\n");
      out.write("\r\n");
      out.write("        <!-- Archivos de JavaScript -->\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("        <script src=\"../JS/CrearPost.js\"></script>\r\n");
      out.write("        <script src=\"../JS/ObtenerPosts.js\"></script>\r\n");
      out.write("        <script src=\"../JS/script.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Variable global que contiene el nombre del juego -->\r\n");
      out.write("        <script>\r\n");
      out.write("                        var currentGame = \"");
      out.print( currentGame);
      out.write("\"; // Esta variable estará disponible en todos tus archivos JS\r\n");
      out.write("                        console.log(currentGame); // Puedes verificar que se asignó correctamente\r\n");
      out.write("        </script>\r\n");
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
