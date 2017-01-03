package edu.nju.onlinestock.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class OnlyDsFilter
 */
@WebFilter("/ShowMyStockServlet")
public class OnlyDsFilter implements Filter {

    /**
     * Default constructor. 
     */
    public OnlyDsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
			HttpServletRequest httpReq = (HttpServletRequest)request;
			HttpServletResponse httpRes = (HttpServletResponse)response;
			String user = httpReq.getParameter("login");
			if(null != user && !user.startsWith("D")) {
				httpRes.sendError(HttpServletResponse.SC_FORBIDDEN, "Only D users allowed");
				return;
			} 
		}//在servlet处理请求之前截获
		chain.doFilter(request, response);
	//	return;
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
