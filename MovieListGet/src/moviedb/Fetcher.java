package moviedb;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;

public class Fetcher {

    public void run() {
        RestTemplate restTemp = new RestTemplate();
        List<Movie> arr = new ArrayList<>();

        try {
            Movie[] movies = restTemp.getForObject("http://127.0.0.1:8080/movies", Movie[].class);
            arr = Arrays.asList(movies);
            
        } catch (ResourceAccessException e) {
            System.out.println("server not running: " + e);
        }
    

        for (Movie m: arr) {
            System.out.println(m);
        }
    }
}
