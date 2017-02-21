package edu.nju.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * Created by kylin on 16/12/2016.
 * All rights reserved.
 */
@WebFilter(
        urlPatterns = "/*",
        filterName = "CharacterEncodingFilter",
        initParams = {
                @WebInitParam(name = "encoding", value = "utf-8")
        }
)
public class CharacterEncodingFilter implements Filter {

    /**
     * 编码格式
     */
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取配置信息
        this.encoding = filterConfig.getInitParameter("encoding");
        if(this.encoding == null){
            throw new ServletException("CharacterEncodingFilter missing init param named encoding");
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //1 设置编码格式
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+this.encoding);
        System.out.println("CharacterEncodingFilter setType :" + response.getCharacterEncoding());

        //2 传递请求
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
