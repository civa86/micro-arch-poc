package info.civa86.edgeservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
 public class AuthenticationFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 6;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal().toString());
        ctx.addZuulRequestHeader("auth-principal", auth.getPrincipal().toString());
        return ctx;
    }

 }