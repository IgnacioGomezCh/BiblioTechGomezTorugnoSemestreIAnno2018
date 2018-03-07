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
public class Book extends Asset{
    //Class atributes
    private String title, edition, ISBN;
    
    //blank constructor
    public Book(){}

    //simple constructor
    public Book(String title, String edition, String ISBN) {
        this.title = title;
        this.edition = edition;
        this.ISBN = ISBN;
    }
    
    //normal constructor
    public Book(String title, String edition, String ISBN, int ID, String state, String lentDate, String returnDate) {
        super(ID, "-1", state, lentDate, returnDate);
        this.title = title;
        this.edition = edition;
        this.ISBN = ISBN;
    }
    
    //Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    public String toString(){
        return "Name: " + this.title + " - ID: " +
                this.getID();
    }
    
    /**
     * metodo que me retorna el tamanno en bytes del objeto
     * actual
     * @return
     */
    public int size(){
        //tamanno de las variables en bytes
        //LONG: necesita dos bytes
        //String: cada caracter necesita dos bytes de espacio,
        //esto si se utiliza UTF
        return this.getTitle().length() * 2 
                + this.getEdition().length() * 2
                + this.getState().length() * 2 
                + this.getLentDate().length() * 2
                + this.getReturnDate().length() * 2 
                + this.getISBN().length() * 2 + 4 + 4 ;
    }
    
}
