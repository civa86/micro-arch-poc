package info.civa86.edgeservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.codehaus.jackson.map.ObjectMapper;

public class UserInfo {
    private String endpoint;

    public UserInfo(String endpoint) {
        this.endpoint = endpoint;
    }

    public HashMap<?, ?> get(String accessToken) throws MalformedURLException, IOException {
        HashMap<?, ?> result = null;
        URL url = new URL(this.endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", "Bearer " + accessToken);

        if (con.getResponseCode() == 200) {
            result = new HashMap<String, Object>();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            result = new ObjectMapper().readValue(content.toString(), HashMap.class);
        }

        con.disconnect();
        return result;
    }
}