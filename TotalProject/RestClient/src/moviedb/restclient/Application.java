package moviedb.restclient;

import moviedb.data.*;

public class Application {
    public static void main(String[] args) {
        Fetcher fetch = new Fetcher();
        fetch.run();
    }
}
