package info.civa86.edgeservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //@formatter:off
		http
			.authorizeRequests()
			.antMatchers("/uuid/**").hasRole("USER")
			.anyRequest().permitAll()
			.and()
			.csrf().disable();
		//@formatter:on
    }

    @Primary
    @Bean
    public RemoteTokenServices tokenServices() {
        String clientId = env.getProperty("spring.checkToken.clientId");
        String clientSecret = env.getProperty("spring.checkToken.clientSecret");
        String remoteTokenUrl = env.getProperty("spring.checkToken.serviceUrl");
        final RemoteTokenServices tokenService = new RemoteTokenServices();

        tokenService.setCheckTokenEndpointUrl(remoteTokenUrl);
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(clientSecret);

        return tokenService;
    }

}