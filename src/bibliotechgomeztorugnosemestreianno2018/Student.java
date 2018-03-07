/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018;

import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class Student {
    //Class attributes
    private String name, ID, password;
    private double pedingFine;
    
    //blank constructor
    public Student(){}    
    
    //normal constructor
    public Student(String name, String ID, String password, double pedingFine) {
        this.name = name;
        this.ID = ID;
        this.password = password;
        this.pedingFine = pedingFine;
    }
    
    //Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPedingFine() {
        return pedingFine;
    }

    public void setPedingFine(double pedingFine) {
        this.pedingFine = pedingFine;
    }
    
        //Class methods
    public boolean bookAsset(Asset myAsset){
        try{
            //assets.add(myAsset);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean returnAsset(Asset myAsset){
        try{
            //assets.remove(myAsset);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public int size(){
        //tamanno de las variables en bytes
        //LONG: necesita dos bytes
        //String: cada caracter necesita dos bytes de espacio,
        //esto si se utiliza UTF
        return this.getName().length() * 2 
                + this.getID().length() * 2
                + this.getPassword().length() * 2 + 8;
    }
}
