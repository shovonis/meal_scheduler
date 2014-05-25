package net.therap.mealScheduler.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);
        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if ((session == null || session.getAttribute("authenticatedUser") == null) && (requestedUri.contains("home")
                || requestedUri.contains("logout"))) {
            ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath());

        } else if (session != null && session.getAttribute("authenticatedUser") != null
                && (requestedUri.contains("login"))) {
            ((HttpServletResponse) servletResponse).sendRedirect(((HttpServletRequest) servletRequest).getContextPath()
                    + "/home");

        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {
    }
}
