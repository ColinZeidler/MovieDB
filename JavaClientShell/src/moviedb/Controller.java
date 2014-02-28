/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviedb;

import java.util.ArrayList;

/**
 *
 * @author Colin
 */
public class Controller {
    private final Storage db;
    private final UI      ui;
    
    public Controller() {
        db = new Storage();
        ui = new UI();
    }
    
    /**
     * Runs the program loop until the user decides to exit.
     */
    public void controlLoop() {
        MenuEnum response;
        do {
            response = ui.mainMenu();
            switch (response) {
                case ADD_MOVIE:
                    addMovie();
                    break;
                case DELETE_MOVIE:
                    deleteMovie();
                    break;
                case LIST_MOVIE:
                    listMovies();
                    break;
            }
        }while (response != MenuEnum.EXIT);
    }
    
    /**
     * gets the number of movies to add from the UI, then gets each movie one at
     * a time adding them to a temp array.
     * 
     * Once all movies are gathered, calls updated un the database passing the 
     * temp array of new movies
     */
    private void addMovie() {
        ArrayList<Movie> tempArr = new ArrayList<>();
        int num = ui.getNumMovies(ActionEnum.ADD);
        for (int i = 0; i < num; i++) {
            tempArr.add(ui.addMovie());
        }
        
        db.update(ActionEnum.ADD, tempArr);
        
    }
    
    /**
     * uses the ui to get the number of movies to delete, then loops that number
     * of times prompting the user for the title of each movie, adding it to a 
     * title array
     * 
     * then loops through all movies stored in the database, looping through all 
     * the titles on each movie, if a title matches adding the matching movie to
     * a temp array of movies
     * 
     * Once all movies are gathered, calls update on the database passing the
     * temp array of movies to delete
     */
    private void deleteMovie() {
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<Movie> delArr = new ArrayList<>();
        
        int num = ui.getNumMovies(ActionEnum.DELETE);
        
        for (int i = 0; i < num; i++) {
            titles.add(ui.deleteMovie());
        }
        for (Movie movie : db.retrieve()) {
            for (String str : titles) {
                if (str.equals(movie.getTitle())) {
                    delArr.add(movie);
                }
            }
        }
        db.update(ActionEnum.DELETE, delArr);
        
    }
    
    /**
     * loops through all of the movies that are contained in the database, and 
     * calls ui.showMovie for each one, displaying the movies for the user.
     */
    private void listMovies() {
        ArrayList<Movie> list = db.retrieve();
        for (Movie movie : list) {
            ui.showMovie(movie);
        }
        
    }
    
}
