/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018;

import java.util.ArrayList;

/**
 *
 * @author Jtoru1
 */
public class Library {
    //Class atributes
    private String name;
    private final int ID;
    private ArrayList<Asset> assetList = new ArrayList();
    private ArrayList<Student> studentList = new ArrayList();
    
    //blank constructor
    public Library(){this.ID = -1;}

    //simple constructor
    public Library(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }
    
    //normal constructor
    public Library(String name, int ID, ArrayList<Asset> assetList, ArrayList<Student> studentList){
        this.name = name;
        this.ID = ID;
        this.assetList = assetList;
        this.studentList = studentList;
    }
    
    //Getter & Setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Asset> getAssetList() {
        return assetList;
    }

    public void setAssetList(ArrayList<Asset> assetList) {
        this.assetList = assetList;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    //Methods
    
    
}
