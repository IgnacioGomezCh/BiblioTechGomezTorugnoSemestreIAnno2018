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
public class Audiovisual extends Asset{
    //Class atributes
    private int code;
    private String model;
    
    //blank constructor
    public Audiovisual(){}
    
    //simple consturctor
    public Audiovisual(int code, String model) {
        this.code = code;
        this.model = model;
    }
    
    //normal constructor
    public Audiovisual(int code, String model, int ID, String state, String lentDate, String returnDate) {
        super(ID, state, lentDate, returnDate);
        this.code = code;
        this.model = model;
    }

    
    
    //Getters & Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
}
