package pl.vrajani.iex.request;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.vrajani.iex.model.Version;

public abstract class Request<T> {
    private static final String BASE_URL = "https://cloud.iexapis.com";
    final String token;
    String url;
    RestTemplate restTemplate;

    Request(Version version, String token) {
        this.url = BASE_URL + "/" + version.getVersion() + getPath();
        this.token = token;
        this.restTemplate = new RestTemplate();
    }

    public abstract T execute();
    public abstract String getPath();

    T handleResponse(ResponseEntity<T> response) {
        if(response.getStatusCode().is2xxSuccessful()){
            System.out.println("Received Response " + this.getClass().getName());
            return response.getBody();
        }
        System.out.println("Error Occured with request:: " + this.getClass().getName());
        return null;
    }
}
