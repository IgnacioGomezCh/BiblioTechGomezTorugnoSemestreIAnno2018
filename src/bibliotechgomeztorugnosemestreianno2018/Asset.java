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
public class Asset {
    //Class atributes
    private final int ID;
    private String state, lentDate, returnDate;
    
    //blank constructor
    public Asset(){this.ID = -1;}

    //Normal constructor
    public Asset(int ID, String state, String lentDate, String returnDate) {
        this.ID = ID;
        this.state = state;
        this.lentDate = lentDate;
        this.returnDate = returnDate;
    }
    
    //Getters & Setters
    public int getID() {
        return ID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLentDate() {
        return lentDate;
    }

    public void setLentDate(String lentDate) {
        this.lentDate = lentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
