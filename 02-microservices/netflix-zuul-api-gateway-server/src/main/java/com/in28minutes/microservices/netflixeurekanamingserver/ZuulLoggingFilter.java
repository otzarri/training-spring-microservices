package com.in28minutes.microservices.netflixeurekanamingserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
     * Decide if execute the filter or not.
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /* 
     * Business logic of the filter
     */
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("request -> {} request uri -> {}", request, request.getRequestURI());
        
        return null;
    }

    /*
     * When to run the filter:
     *   - pre: Before request is processed
     *   - post: After request is processed
     *   - error: When an exception happens
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /*
     * Priority order
     */
    @Override
    public int filterOrder() {
        return 1;
    }

}
