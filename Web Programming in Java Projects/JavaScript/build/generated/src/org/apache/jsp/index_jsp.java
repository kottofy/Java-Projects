package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            BODY {font-family:sans-serif}\n");
      out.write("            .quote {padding:20px 20px 20px 20px; border:medium solid green;\n");
      out.write("            font-family:cursive}\n");
      out.write("            .quote2 {padding:20px 20px 20px 20px; border:medium solid purple;\n");
      out.write("            font-family:cursive}\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <title>JavaScript Practice</title>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("\n");
      out.write("            /*JQUERY...FADE TECHNIQUE TO MAKE IT LESS PRIMITIVE*/\n");
      out.write("            /*ADD <QUOTES> <QUOTE0>...</QUOTE4></QUOTES> IN XML*/\n");
      out.write("\n");
      out.write("            //missing something here\n");
      out.write("            //can also replace beginRoll... with rollQuote so it only calls once\n");
      out.write("            $(document).ready(beginRollingQuote);\n");
      out.write("\n");
      out.write("            var ROLLING_INTERVAL=4000; //same as 4 seconds\n");
      out.write("            var N_QUOTES=5;\n");
      out.write("            var currentQuote=0;\n");
      out.write("\n");
      out.write("            /*CHANGE THE QUOTE EVERY ROLLING_INTERVAL MS*/\n");
      out.write("            function beginRollingQuote()\n");
      out.write("            {\n");
      out.write("                //make sure to not have alert boxes in calling function\n");
      out.write("                setInterval(rollQuote, ROLLING_INTERVAL);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*CHANGE TO THE NEXT QUOTE, ROLLING BACK TO START IF\n");
      out.write("             *CURRENTQUOTE IS N_QUOTES=1*/\n");
      out.write("            function rollQuote()\n");
      out.write("            {\n");
      out.write("                //BLAH BLAH BLAH\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            /*INSERT AJAX RESPONSE INTO DOCUMENT*/\n");
      out.write("            function handleAjaxResponse(data)\n");
      out.write("            {\n");
      out.write("                currentQuote = (++currentQuote)%N_QUOTES;\n");
      out.write("                selector = \"quote\"+currentQuote;\n");
      out.write("                theQuote = $(data).find(selector).text();\n");
      out.write("                spanObj = document.getElementById(\"quote\");\n");
      out.write("                textNode = spanObj.firstChild;\n");
      out.write("                textNode.data=theQuote;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function changeStyle()\n");
      out.write("            {\n");
      out.write("                spanObj = document.getElementById(\"quote\");\n");
      out.write("                spanObj.className = \"quote2\";\n");
      out.write("\n");
      out.write("                //ANYTHING INSIDE AN IF STMT IN JS WILL\n");
      out.write("                //RETURN TRUE AS LONG AS NOT NULL OR \"0\"\n");
      out.write("                if (spanObj) \n");
      out.write("                    alert(\"found the span Obj\" + spanObj.className + \", Node Type: \" + spanObj.nodeType);\n");
      out.write("            }\n");
      out.write("            function changeContent()\n");
      out.write("            {\n");
      out.write("                spanObj = document.getElementById(\"quote\");\n");
      out.write("                child = spanObj.firstChild;\n");
      out.write("                var text = document.createTextNode(\"Blah Blah Blah\");\n");
      out.write("\n");
      out.write("                if (child)  //if (child) checks to see if the child is null\n");
      out.write("                    {\n");
      out.write("                        child.data=\"BLAAAAAAHHHHH\";\n");
      out.write("\n");
      out.write("                        //verify that child node is 3 bc it's a text node\n");
      out.write("                        alert(\"found child \" + child.nodeType);\n");
      out.write("\n");
      out.write("                        /* ???????? */\n");
      out.write("\n");
      out.write("                    }\n");
      out.write("                if (spanObj)\n");
      out.write("                    alert(\"found the spanObj, node type is \" + spanObj.nodeType);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>JavaScript Practice</h1>\n");
      out.write("        <p>Click the buttons to change the style or substance of our\n");
      out.write("        daily  quote.</p>\n");
      out.write("        <h3>Daily Quote</h3>\n");
      out.write("        <div id=\"quote_div\" style=\"padding-top:20px\">\n");
      out.write("            <span id=\"quote\" class=\"quote1\">She got her looks from her father.\n");
      out.write("                He's a plastic surgeon. -- Groucho Marx.</span>\n");
      out.write("            <p>\n");
      out.write("                <input type=\"button\" onclick=\"changeStyle()\" value=\"Change Style\">\n");
      out.write("                <input type=\"button\" onclick=\"changeContent()\" value=\"Change Content\">\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
