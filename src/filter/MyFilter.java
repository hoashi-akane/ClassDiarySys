package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class MyFillter
 */
@WebFilter("/*")
public class MyFilter implements Filter {
	private String encoding = "UTF-8";
    /**
     * Default constructor.
     */
    public MyFilter() {
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
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset=" + encoding);


		String name = ((HttpServletRequest)request).getServletPath();
		if( name.equals("/LoginServlet") || name.equals("/AuthServlet")) {
			chain.doFilter(request, response);

		}else {
			HttpSession session = ((HttpServletRequest)request).getSession(false);
			if(session == null) {
				((HttpServletResponse)response).sendRedirect("LoginServlet");
			}else if(session.getAttribute("loginInfo") == null){//pass the request along the filter chain
				((HttpServletResponse)response).sendRedirect("LoginServlet");
			}else {
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}