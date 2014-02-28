/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moviedb;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Colin
 */
public class UI {

    private final Scanner input;

    /**
     * constructs the scanner that will be used to get user input
     */
    public UI() {
        input = new Scanner(System.in).useDelimiter(System.lineSeparator());
    }

    /**
     *
     * @return the users selection on the main menu
     */
    public MenuEnum mainMenu() {
        int choice;
        while (true) {
            System.out.println("Please choose what to do");
            System.out.println("(1) Add movies");
            System.out.println("(2) Delete Movies");
            System.out.println("(3) View Movies");
            System.out.println("(0) Exit");
            System.out.print(">");
            
            choice = getInt();
            
            switch (choice) {
                case 1:
                    return MenuEnum.ADD_MOVIE;
                case 2:
                    return MenuEnum.DELETE_MOVIE;
                case 3:
                    return MenuEnum.LIST_MOVIE;
                case 0:
                    return MenuEnum.EXIT;
                default:
                    System.out.println("Please enter a number from 0 - 3");
                    System.out.println();
            }
        }
    }

    /**
     *
     * @return the new Movie with user provided title year and Genre
     */
    public Movie addMovie() {
        String title;
        int year;
        int iGenre;
        boolean invalidG = true;
        GenreEnum genre = GenreEnum.SF; //initialize but will never not be changed

        System.out.println("Title: ");
        title = input.next();

        System.out.println("Year: ");
        year   = getInt();
        
        while (invalidG) {
            System.out.println("Genre: ");
            System.out.println("(0) Action");
            System.out.println("(1) Drama");
            System.out.println("(2) Comedy");
            System.out.println("(3) Sci-Fi");
            System.out.println("(4) Horror");
            System.out.println("(5) Adventure");
            System.out.println("(6) Western");
            iGenre = getInt();
            //convert iGenre to GenreEnum
            invalidG = false;
            switch(iGenre) {
                case 0:
                    genre = GenreEnum.ACTION;
                    break;
                case 1:
                    genre = GenreEnum.DRAMA;
                    break;
                case 2:
                    genre = GenreEnum.COMEDY;
                    break;
                case 3:
                    genre = GenreEnum.SF;
                    break;
                case 4:
                    genre = GenreEnum.HORROR;
                    break;
                case 5:
                    genre = GenreEnum.ADVENTURE;
                    break;
                case 6:
                    genre = GenreEnum.WESTERN;
                    break;
                default:
                    invalidG = true;
                    System.out.println("Invalid choice,");
                    System.out.println("Please choose a number from 0 - 6");
                    System.out.println();
            }
        }

        return new Movie(title, year, genre);
    }

    /**
     * gets the number of movies to add/delete from the user
     * @param action ActionEnum.ADD|ActionEnum.DELETE specifies what text to 
     * present to the user
     * @return an int marking the number of movies to add/delete
     */
    public int getNumMovies(ActionEnum action) {
        int num;
        String actionString = "";
        //choose the appropriate string to present
        switch (action) {
            case ADD:
                actionString = "add";
                break;
            case DELETE:
                actionString = "delete";
                break;
        }
        System.out.println("How many movies do you want to "
                + actionString + "?");
        
        num = getInt();

        return num;
    }

    /**
     * Gets the title of a movie the user wishes to delete
     * @return the title of the movie to be deleted
     */
    public String deleteMovie() {
        System.out.println("Title of movie to delete:");
        String str = input.next();
        return str;
    }

    /**
     *Prints the given Movie onto the command line for the user
     * @param movie the movie to be printed to the console
     */
    public void showMovie(Movie movie) {
        System.out.println(movie);
    }
    
    /**
     * Function to handle the error checking and validation that goes into 
     * getting an int from the user
     * @return integer that the user has entered
     */
    private int getInt() {
        int i;
        
        //continue to prompt the user for input until a valid integer is provided
        while (true) {
            try {
                i = input.nextInt();
                break;  //exits the loop if there was no error in the input
            } catch (InputMismatchException e) {
                System.out.println("Invalid input,");
                System.out.println("Please enter a valid number");
                System.out.println();
            }
        }
        
        return i;
    }
}
