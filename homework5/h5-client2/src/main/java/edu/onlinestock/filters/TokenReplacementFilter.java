package edu.onlinestock.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet Filter implementation class TokenReplacementFilter
 */


@WebFilter(
        urlPatterns = "/Login",
        filterName = "TokenReplacementFilter",
        initParams = {
                @WebInitParam(name = "token.name", value = "version"),
                @WebInitParam(name = "token.value", value = "3.0")
        }
)
public class TokenReplacementFilter implements Filter {

    /**
     * 成员变量
     */
    private String replToken, replValue;

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        //获取配置信息
        replToken = fConfig.getInitParameter("token.name");
        replValue = fConfig.getInitParameter("token.value");
        if (null == replToken) {
            throw new ServletException("TokenReplacementFilter named " + fConfig.getFilterName()
                    + " missing token.name init parameter.");
        }
        if (null == replValue) {
            throw new ServletException("TokenReplacementFilter named " + fConfig.getFilterName()
                    + " missing token.value init parameter.");
        }
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        BufferedResponse resWrapper = new BufferedResponse((HttpServletResponse) response);
        //将请求转发给过滤器链上下一个对象"下一个filter，如果没有filter那就是请求的资源
        chain.doFilter(request, resWrapper);

        //获得原始response的属性
        String contentType = response.getContentType();
        System.out.println("contentType = " + contentType);

        short outputType = resWrapper.getOutputType();
        System.out.println("Token filter outputType " + outputType);
        //判断response的output类型
        if (outputType == BufferedResponse.OT_WRITER) {
            String resBody = new String(resWrapper.toByteArray(), resWrapper.getCharacterEncoding());

            if (contentType.equals("text/html;charset=utf-8")) {
                //对字节数组进行处理：用replValue替换@replToken@
                resBody = resBody.replaceAll("@" + replToken + "@", replValue);
                //调整响应的content-Length
                response.setContentLength(resBody.length());
            }
            PrintWriter writer = response.getWriter();

            //将数组写入实际响应对象中
            writer.println(resBody);

        } else if (outputType == BufferedResponse.OT_OUTPUT_STREAM) {
            //不替换
            ServletOutputStream out = response.getOutputStream();
            out.write(resWrapper.toByteArray());
        }
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {

    }

}
