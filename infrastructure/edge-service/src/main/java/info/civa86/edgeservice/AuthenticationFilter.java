package info.civa86.edgeservice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends ZuulFilter {
    @Autowired
    private Environment env;

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
        BearerTokenExtractor tokenExtractor = new BearerTokenExtractor();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            Authentication extractedTokenAuth = tokenExtractor.extract(ctx.getRequest());

            if (extractedTokenAuth != null) {
                String accessToken = extractedTokenAuth.getName();
                String endpoint = env.getProperty("authorizationServer.userInfoUrl");
                UserInfo userInfo = new UserInfo(endpoint);
                try {
                    HashMap<?, ?> userInformations = userInfo.get(accessToken);

                    ctx.addZuulRequestHeader("X-FORWARDED-USER-ID", userInformations.get("id").toString());
                } catch (MalformedURLException malformedURLException) {
                    return ctx;
                } catch (IOException ioException) {
                    return ctx;
                }
            }
        }
        return ctx;
    }

}