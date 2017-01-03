package edu.nju.onlinestock.filters;

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
     * ��Ա����
     */
    private String replToken, replValue;

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        //��ȡ������Ϣ
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
        //������ת����������������һ������"��һ��filter�����û��filter�Ǿ����������Դ
        chain.doFilter(request, resWrapper);

        System.out.println("Token filter "+resWrapper.getOutputType()+BufferedResponse.OT_WRITER);
        //�Է��ص�response���д���
        short outputType = resWrapper.getOutputType();
        //�ж�response��output����
        if (outputType == BufferedResponse.OT_WRITER) {
            String resBody = new String(resWrapper.toByteArray(), resWrapper.getCharacterEncoding());

            if (resWrapper.getContentType().equals("text/html;charset=utf-8")) {
                //���ֽ�������д�����replValue�滻@replToken@
                resBody = resBody.replaceAll("@" + replToken + "@", replValue);
                //������Ӧ��content-Length
                response.setContentLength(resBody.length());
            }
            PrintWriter writer = response.getWriter();

            //������д��ʵ����Ӧ������
            writer.println(resBody);

        } else if (outputType == BufferedResponse.OT_OUTPUT_STREAM) {
            //���滻
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
