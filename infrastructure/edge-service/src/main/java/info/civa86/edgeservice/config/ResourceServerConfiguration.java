package info.civa86.edgeservice.config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
@EnableConfigurationProperties
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private AuthRulesProperties authenticationRules;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http.authorizeRequests()
                .antMatchers("/uaa/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**/actuator/health").permitAll()
                .antMatchers(HttpMethod.GET, "/**/actuator/info").permitAll();


        try {
            if (this.authenticationRules.getSize() > 0) {
                this.authenticationRules.getRules().forEach(service -> {
                    service.keySet().forEach(ruleKey -> {
                        Map<?, ?> rule = (Map<?, ?>) service.get(ruleKey);
                        String rulePath = (String) rule.get("path");
                        String ruleRole = (String) rule.get("role");

                        try {
                            http.authorizeRequests().antMatchers(rulePath).hasRole(ruleRole);
                        }  catch(Exception e) {
                            ;
                        }

                    });
                });
            }
        } catch(Exception e) {
            ;
        }

        System.out.println("DARIO");

        http.authorizeRequests().anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//@formatter:on
    }

    @Primary
    @Bean
    public RemoteTokenServices tokenServices() {
        String remoteTokenUrl = env.getProperty("authorizationServer.oauthToken.checkUrl");
        String clientId = env.getProperty("authorizationServer.oauthToken.client.id");
        String clientSecret = env.getProperty("authorizationServer.oauthToken.client.secret");
        final RemoteTokenServices tokenService = new RemoteTokenServices();

        tokenService.setCheckTokenEndpointUrl(remoteTokenUrl);
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(clientSecret);

        return tokenService;
    }

}