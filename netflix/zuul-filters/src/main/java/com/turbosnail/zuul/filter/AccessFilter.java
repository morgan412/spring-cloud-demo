package com.turbosnail.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zouxq
 * @date 2019/5/17
 */
@Log4j2
public class AccessFilter extends ZuulFilter {

    @Override
    public int filterOrder() {
        // run before PreDecoration
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        // a filter has already forwarded
        // a filter has already determined serviceId
        return !ctx.containsKey(FilterConstants.FORWARD_TO_KEY)
                && !ctx.containsKey(FilterConstants.SERVICE_ID_KEY);
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("accessToken");
        if(StringUtils.isBlank(token)) {
            log.warn("access token is empty");
            // 过滤该请求，不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
}
