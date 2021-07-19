package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MakeQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/quiz.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/makequiz.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Navbar.jsp", out, false);
      out.write("\n");
      out.write("                <div class=\"content\">\n");
      out.write("                    <form name=\"form\" action=\"../Quiz/makequiz\" onsubmit=\"return validateForm()\" method=\"post\">\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("                                Question: \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <textarea class=\"medium-textarea\" id=\"w3review\" name=\"question\" required=\"true\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("                                Option 1:\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <textarea id=\"ans_1\" name=\"option\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("                                Option 2:\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <textarea id=\"ans_2\" name=\"option\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("                                Option 3:\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <textarea id=\"ans_3\" name=\"option\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("                                Option 4:\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <textarea id=\"ans_4\" name=\"option\"></textarea>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("                                Answer(s): \n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <input type=\"checkbox\" id=\"option_1\" name=\"answer\" value=\"1\" disabled=\"true\">\n");
      out.write("                                <label for=\"option_1\"> Option 1 </label>\n");
      out.write("                                <input type=\"checkbox\" id=\"option_2\" name=\"answer\" value=\"2\" disabled=\"true\">\n");
      out.write("                                <label for=\"option_2\"> Option 2 </label>\n");
      out.write("                                <input type=\"checkbox\" id=\"option_3\" name=\"answer\" value=\"3\" disabled=\"true\">\n");
      out.write("                                <label for=\"option_3\"> Option 3 </label>\n");
      out.write("                                <input type=\"checkbox\" id=\"option_4\" name=\"answer\" value=\"4\" disabled=\"true\">\n");
      out.write("                                <label for=\"option_4\"> Option 4 </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"lif\">\n");
      out.write("                            <div class=\"label\">\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"data-input\">\n");
      out.write("                                <input type=\"submit\" value=\"Save\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"../Quiz/js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
