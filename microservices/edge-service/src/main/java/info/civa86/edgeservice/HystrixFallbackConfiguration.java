package info.civa86.edgeservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.MediaType;

//https://thepracticaldeveloper.com/2017/06/27/hystrix-fallback-with-zuul-and-spring-boot/

public class HystrixFallbackConfiguration {

    @Bean
    public FallbackProvider fallbackProvider() {
        return new FallbackProvider() {

            @Override
            public String getRoute() {
                // Might be confusing: it's the serviceId property and not the route
                return "*";
            }

            @Override
            public ClientHttpResponse fallbackResponse(String s, Throwable t) {
                return new ClientHttpResponse() {
                    @Override
                    public HttpStatus getStatusCode() throws IOException {
                        return HttpStatus.OK;
                    }

                    @Override
                    public int getRawStatusCode() throws IOException {
                        return HttpStatus.OK.value();
                    }

                    @Override
                    public String getStatusText() throws IOException {
                        return HttpStatus.OK.toString();
                    }

                    @Override
                    public void close() {
                    }

                    @Override
                    public InputStream getBody() throws IOException {
                        return new ByteArrayInputStream(
                                "{\"factorA\":\"Sorry, Service is Down!\",\"factorB\":\"?\",\"id\":null}".getBytes());
                    }

                    @Override
                    public HttpHeaders getHeaders() {
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        return headers;
                    }
                };
            }
        };
    }

}