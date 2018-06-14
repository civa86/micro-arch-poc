package info.civa86.authservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "/actuator/health").permitAll()
                .antMatchers(HttpMethod.GET, "/actuator/info").permitAll()
                .antMatchers(HttpMethod.POST, "/user").permitAll()
                .antMatchers(HttpMethod.GET, "/crypt").permitAll()
                .and()
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        // @formatter:on
    }

}