/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviedb;


/**
 *
 * @author Colin
 */
public class Movie {
    private final String title;
    private final int year;
    private final GenreEnum genre;
    
    /**
     * Movie constructor, creates a new Movie object with the given title, year,
     * and Genre
     * @param title: the title of the movie being created
     * @param year: the year of the movie
     * @param genre: the genre for the movie
     */
    public Movie(String title, int year, GenreEnum genre) {
        this.title = title;
        this.year = year;
        this.genre = genre;
    }
    
    /*
    Getters
    */
    
    public String     getTitle() { return title; }
    public int        getYear()  { return year;  }
    public GenreEnum  getGenre() { return genre; }
    
    /*
    Overrides
    */
    
    @Override
    public String toString() {
        String str = "";
        str += "----\n";
        str += "--Title: " + title + "\n";
        str += "--Year:  " + year + "\n";
        str += "--Genre: " + genre.toString().toLowerCase();
        return str;
    }
}
