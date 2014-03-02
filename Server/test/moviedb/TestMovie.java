package moviedb;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMovie {

    @Test
    public void testGetTitle() {
        System.out.println("Starting test: getTitle");
        String expected = "A new Hope";
        Movie testM = new Movie(expected, 1000, GenreEnum.SF);

        String result = testM.getTitle();

        assertEquals(expected, result);
    }

    @Test
    public void testGetYear() {
        System.out.println("Starting test: getYear");
        int expected = 2023;
        Movie testM = new Movie("title", expected, GenreEnum.SF);

        int result = testM.getYear();

        assertEquals(expected, result);
    }

    @Test
    public void testGetGenre() {
        System.out.println("Starting test: getGenre");
        GenreEnum expected = GenreEnum.SF;
        Movie testM = new Movie("title", 1000, expected);

        GenreEnum result = testM.getGenre();

        assertEquals(expected, result);
    }
}
