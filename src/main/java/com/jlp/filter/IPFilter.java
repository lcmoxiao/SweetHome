package com.jlp.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.jlp.utils.IPUtils.getRemoteIP;

@WebFilter(urlPatterns = "/*", filterName = "IPFilter")
public class IPFilter implements Filter {
    private final Logger logger = LoggerFactory.getLogger(IPFilter.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String remoteIP = getRemoteIP((HttpServletRequest) servletRequest);
        logger.debug(remoteIP + "=======进入过滤器===========");

        filterChain.doFilter(servletRequest, servletResponse);
    }

}