package moviedb;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;;

@Controller
public class GreetingController {
    
    private ArrayList<Movie> list;

    public GreetingController() {
        list = new ArrayList<Movie>();

        Movie m1 = new Movie("Speeder", 2000, GenreEnum.DRAMA);
        Movie m2 = new Movie("Die Hard", 2005, GenreEnum.ACTION);
        Movie m3 = new Movie("Stars out there", 1980, GenreEnum.SF);

        list.add(m1);
        list.add(m2);
        list.add(m3);
    }

    @RequestMapping("/greeting")
    public @ResponseBody Movie greeting(@RequestParam(value="title", required=false,
                                                         defaultValue="a movie")
                                           String title,
                                           @RequestParam(value="year", required=false,
                                                         defaultValue="1990")
                                           int year) {
        return new Movie(title, year, GenreEnum.SF);
    }

    @RequestMapping("/movies")
    public @ResponseBody ArrayList<Movie> movies() {
        return list;
    }
}
