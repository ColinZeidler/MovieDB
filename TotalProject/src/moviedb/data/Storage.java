/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviedb.data;

import java.util.ArrayList;

/**
 *
 * @author Colin
 */
public class Storage {
    private final ArrayList<Movie> movieArr;
    
    /**
     * Acts as a middle man for the ArrayList of movies that we have,
     * allowing for a simpler interface between the rest of the program and the
     * list of movies
     */
    public Storage() {
        movieArr = new ArrayList<>();
    }
    
    /**
     * Performs the given action on the list of movies with the provided movies
     * @param action ActionEnum.ADD|ActionEnum.DELETE, the update action to 
     * perform either deleting Movies from the database or adding movie to it
     * @param inArr The array of movies to modify the database with
     */
    public void update(ActionEnum action, ArrayList<Movie> inArr) {
        switch (action) {
            case ADD:
                movieArr.addAll(inArr);
                break;
            case DELETE:
                movieArr.removeAll(inArr);
                break;
        }
    }
    
    /**
     * 
     * @return the database of movies that we have
     */
    public ArrayList<Movie> retrieve() {
        return movieArr;
    }
            
}
