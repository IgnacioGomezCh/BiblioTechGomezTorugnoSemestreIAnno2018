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
    private int ID;
    private String state, lentDate, returnDate, FK_student;
    
    //blank constructor
    public Asset(){this.ID = -1;}

    //Normal constructor
    public Asset(int ID, String FK_student, String state, String lentDate, String returnDate) {
        this.ID = ID;
        this.FK_student = FK_student;
        this.state = state;
        this.lentDate = lentDate;
        this.returnDate = returnDate;
    }
    
    //Getters & Setters
    public int getID(){
        return ID;  
    }
    
    public String getFK_student() {
        return FK_student;
    }

    public void setFK_student(String FK_student) {
        this.FK_student = FK_student;
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
    
    public void setID(int ID){
        this.ID = ID;
    }
    
}
