/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.92
 * Generated at: 2019-05-10 15:08:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.assemble;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class left_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
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

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<title>Frame left</title>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/js/jquery.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/js/page_common.js\"></script>\r\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/css/common_style_blue.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t// 显示或隐藏二级菜单 \r\n");
      out.write("\t\tfunction menuClick( menuDiv ){\r\n");
      out.write("\t\t\t$(\".MenuLevel2\").not( $(menuDiv).next() ).hide();\r\n");
      out.write("\t\t\t$(menuDiv).next().toggle();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t// 默认只显示第1个二级菜单\r\n");
      out.write("\t\t\t$(\".MenuLevel2\").hide();\r\n");
      out.write("\t\t\t$(\".MenuLevel2:first\").show();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<!-- 内容总宽度为 3px边框 * 2 + 155px内容 = 161px; -->\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write("html{\r\n");
      out.write("height: 100%;\r\n");
      out.write("}\r\n");
      out.write("body {\r\n");
      out.write("\tbackground: none repeat scroll 0 0 #D8EDFC;\r\n");
      out.write("\tmargin: 0;\r\n");
      out.write("\tpadding: 0;\r\n");
      out.write("}\r\n");
      out.write("#Menu {\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    width: 155px;\r\n");
      out.write("\tbackground: none repeat scroll 0 0 #D8EBF7;\r\n");
      out.write("    list-style: none outside none;\r\n");
      out.write("\t\r\n");
      out.write("\tmargin-left: 3px;\r\n");
      out.write("\tborder-top: 3px solid #4891C6;\r\n");
      out.write("}\r\n");
      out.write("#Menu .level1 {\r\n");
      out.write(" color: #005790;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    padding-bottom: 1px;\r\n");
      out.write("\t  cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("#Menu .level1 .level1Style {\r\n");
      out.write("  background: url(\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/img/menu_btn_bg.gif\") no-repeat scroll 0 0 transparent;\r\n");
      out.write("    height: 23px;\r\n");
      out.write("    padding-left: 20px;\r\n");
      out.write("    padding-top: 5px;\r\n");
      out.write("    width: 135px;\r\n");
      out.write("\tmargin-bottom: -4px\r\n");
      out.write("}\r\n");
      out.write("#Menu .level1 .level1Style .Icon {\r\n");
      out.write("\tmargin-top: -2px;\r\n");
      out.write("}\r\n");
      out.write("#Menu .level1 .MenuLevel2 {\r\n");
      out.write(" background: none repeat scroll 0 0 #D8EBF7;\r\n");
      out.write("    list-style: none outside none;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write("#Menu .level1 .MenuLevel2 .level2Style{\r\n");
      out.write("\tcolor: #005790;\r\n");
      out.write("    font-weight: normal;\r\n");
      out.write("\tborder-top: 1px solid #EFF6FB;\r\n");
      out.write("\theight: 18px;\r\n");
      out.write("\tpadding-left: 43px;\r\n");
      out.write("\tpadding-top: 5px;\r\n");
      out.write("\twidth: 112px;\r\n");
      out.write("\tbackground-image:url(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/img/menu_arrow_single.gif);\r\n");
      out.write("\tbackground-color: #8EC4E9;\r\n");
      out.write("\tbackground-repeat: no-repeat;\r\n");
      out.write("\tbackground-position: 29px center;\r\n");
      out.write("}\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("    <ul id=\"Menu\">\r\n");
      out.write("\t    <li class=\"level1\">\r\n");
      out.write("            <div onClick=\"menuClick(this);\" class=\"level1Style\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/func20001.gif\" class=\"Icon\" /> \r\n");
      out.write("\t\t\t\t个人信息\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            <ul class=\"MenuLevel2\">\r\n");
      out.write("            \t<li class=\"level2 level2Style\">\r\n");
      out.write("                    <a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/selectinformation.action\">查看个人信息</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("                <li class=\"level2 level2Style\">\r\n");
      out.write("                \t<a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/updateinformation.action\">修改个人信息</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("           \t\t<li class=\"level2 level2Style\">\r\n");
      out.write("                \t<a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/toresetpage.action\">修改密码</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"level1\">\r\n");
      out.write("            <div onClick=\"menuClick(this);\" class=\"level1Style\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/func20001.gif\" class=\"Icon\" /> \r\n");
      out.write("\t\t\t\t班级信息\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            <ul class=\"MenuLevel2\">\r\n");
      out.write("            \t<li class=\"level2 level2Style\">\r\n");
      out.write("                    <a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/clinformation.action\">班级基本信息</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("                <li class=\"level2 level2Style\">\r\n");
      out.write("                \t<a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/classmember.action\">班级成员</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("                <li class=\"level2 level2Style\">\r\n");
      out.write("                \t<a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/subject.action\">科目</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"level1\">\r\n");
      out.write("            <div onClick=\"menuClick(this);\" class=\"level1Style\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/func20001.gif\" class=\"Icon\" /> \r\n");
      out.write("\t\t\t\t<a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/alloperation.action\">任务管理</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            <ul class=\"MenuLevel2\">\r\n");
      out.write("            \t<li class=\"level2 level2Style\">\r\n");
      out.write("                    <a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/showsubject.action\">已完成任务</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("                <li class=\"level2 level2Style\">\r\n");
      out.write("                \t<a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/unsubject.action\">未完成任务</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("        <li class=\"level1\">\r\n");
      out.write("            <div onClick=\"menuClick(this);\" class=\"level1Style\">\r\n");
      out.write("\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/style/images/func20001.gif\" class=\"Icon\" /> \r\n");
      out.write("\t\t\t\t成绩管理\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("            <ul class=\"MenuLevel2\">\r\n");
      out.write("            \t<li class=\"level2 level2Style\">\r\n");
      out.write("                    <a target=\"right\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/showscore.action\">查看成绩</a>\r\n");
      out.write("\t\t\t\t</li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
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
