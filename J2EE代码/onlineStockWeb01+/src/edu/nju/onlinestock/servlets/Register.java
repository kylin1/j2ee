package edu.nju.onlinestock.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register.user")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //Retrieve an output stream from the response
        //Fill in the response headers.
        //Write any body content to the output stream.
        PrintWriter pw = response.getWriter();

        //invoke a resource available on the server
        //ServletRequest.getRequestDispatcher(String url)中的url可以使用相对路径
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/user/register.html");

        //RequestDispatcher对象从客户端获取请求request，并把它们传递给服务器上的servlet,html或jsp。它有两个方法:
        //用来记录保留request和response，以后不能再修改response里表示状态的信息。
        if (dispatcher != null)
            //程序执行到include()方法的时候,把servlet B的代码直接包含进了servlet A中,
            //send the request to the included web component, execute the web component,
            // and then include the result of the execution in the response
            dispatcher.include(request, response);

        //调用forward()方法,会失去response对象的传递
        //执行forward()方法是可以传递request对象设置的属性或者方法的,但是写在forward()方法后面的代码,将不会被执行
        //used to give another resource responsibility for replying to the user.
            /* dispatcher.forward(request,response);*/


        //response.sendRedirect(request.getContextPath() + "/user/register.html");


        //getSession method of a request object
        //if the request does not have a session, it creates one.
        HttpSession session = request.getSession(true);
        pw.println("<h1>SessionServlet Output</h1>");

        Integer ival = (Integer) session.getAttribute("sessiontest.counter");
        if (ival == null)
            ival = new Integer(1);
        else
            ival = new Integer(ival.intValue() + 1);
        session.setAttribute("sessiontest.counter", ival);

        
        pw.println("You have hit this page <b>" + ival + "</b> times.<p>");
        pw.println("Click <a href=" + response.encodeURL("/onlineStockWeb01/register.user") + ">here</a>");
        pw.println(" to ensure that session tracking is working even if cookies aren't supported. ");
        pw.println("<h3>Session Data:</h3>");
        pw.println("Session ID in Request: " + request.getRequestedSessionId());
        pw.println("<br>Session ID in Request from Cookie: " + request.isRequestedSessionIdFromCookie());
        pw.println("<br>Session ID in Request from URL: " + request.isRequestedSessionIdFromURL());
        pw.println("New Session: " + session.isNew());
        pw.println("<br>Session ID: " + session.getId());
        pw.println("<br>Creation Time: " + session.getCreationTime());
        pw.println("<br>Last Accessed Time: " + session.getLastAccessedTime());

        pw.println("</body></html>");


    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = request.getParameter("userid");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        if (id == null)
            id = "unknown";
        if (name == null)
            name = "unknown";
        if (phone == null)
            phone = "unknown";
        if (email == null)
            email = "unknown";
        //Indicate the content type (for example, text/html) being returned by the response
        //must be called before the response is committed
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>register user</title>");
        pw.println("</head>");
        pw.println("<body>");
        pw.println("<table width='650' border='0' >");
        pw.println("<tr>");
        pw.println(
                "<td width='650' height='80' background='" + request.getContextPath() + "/image/top.jpg'>&nbsp;</td>");
        pw.println("</tr>");
        pw.println("</table>");
        pw.println("user with Userid " + id + " name " + name + " Phone " + phone + " Email " + email + " was added.");
        pw.println("</p>");

        HttpSession session = request.getSession(true);
        pw.println("<h1>SessionServlet Output</h1>");
        Integer ival = (Integer) session.getAttribute("sessiontest.counter");
        if (ival == null)
            ival = new Integer(1);
        else
            ival = new Integer(ival.intValue() + 1);
        session.setAttribute("sessiontest.counter", ival);
        pw.println("You have hit this page <b>" + ival + "</b> times.<p>");
        //. This method includes the session ID in the URL only if cookies are disabled;
        // otherwise, it returns the URL unchanged.
        pw.println("Click <a href=" + response.encodeURL("/onlineStockWeb01/register.user") + ">here</a>");
        pw.println(" to ensure that session tracking is working even if cookies aren't supported. ");
        pw.println("<h3>Session Data:</h3>");
        pw.println("Session ID in Request: " + request.getRequestedSessionId());
        pw.println("<br>Session ID in Request from Cookie: " + request.isRequestedSessionIdFromCookie());
        pw.println("<br>Session ID in Request from URL: " + request.isRequestedSessionIdFromURL());
        pw.println("New Session: " + session.isNew());
        pw.println("<br>Session ID: " + session.getId());
        pw.println("<br>Creation Time: " + session.getCreationTime());
        pw.println("<br>Last Accessed Time: " + session.getLastAccessedTime());

        pw.println("</body></html>");
    }

}
