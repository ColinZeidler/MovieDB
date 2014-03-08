/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moviedb;

/**
 *
 * @author Colin Zeidler
 */
public class MovieDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create a Controller instance and start the control loop
        Controller control = new Controller();
        control.controlLoop();
    }
    
}
