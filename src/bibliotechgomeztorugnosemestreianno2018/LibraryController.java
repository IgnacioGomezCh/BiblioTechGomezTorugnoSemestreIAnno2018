/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018;

/**
 *
 * @author Nacho
 */
public class LibraryController {
    //class atributes
    private double lateFee;
    private int maxBookingDays;
    private String password;
    
    //blank constructor
    public LibraryController(){}
    
    //normal constructor
    public LibraryController(double lateFee, int maxBookingDays, String password) {
        this.lateFee = lateFee;
        this.maxBookingDays = maxBookingDays;
        this.password = password;
    }

    //Getter & Setters
    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    public int getMaxBookingDays() {
        return maxBookingDays;
    }

    public void setMaxBookingDays(int maxBookingDays) {
        this.maxBookingDays = maxBookingDays;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
