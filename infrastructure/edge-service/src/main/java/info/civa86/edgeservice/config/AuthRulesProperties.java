package info.civa86.edgeservice.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "zuul.auth")
public class AuthRulesProperties {

    private List<Map<String, Object>> list;

    AuthRulesProperties() {
        this.list = new ArrayList<>();
    }

    public List<Map<String, Object>> getRules() {
        return this.list;
    }

    public int getSize() {
        return this.list.size();
    }

}