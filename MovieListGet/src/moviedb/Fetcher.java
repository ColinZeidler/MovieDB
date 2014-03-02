package moviedb;

import java.util.ArrayList;
import org.springframework.web.client.RestTemplate;

public class Fetcher {

    public void run() {
        RestTemplate restTemp = new RestTemplate();

        ArrayList<Movie> list = restTemp.getForObject("http://127.0.0.1:8080/movies", ArrayList.class);
        for (Movie m: list) {
            System.out.println(m);
        }
    }
}
