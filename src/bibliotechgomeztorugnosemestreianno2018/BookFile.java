/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nacho
 */
public class BookFile {
    //atributos
    public java.io.RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;
    
    //constructor
    public BookFile(File file) throws IOException{
        start(file);
    }
    
    //instancia el random access file y coloca el valor de mis variables privadas
    private void start(File file) throws IOException{
        //almaceno la ruta
        myFilePath = file.getPath();
        
        //tamanno maximo de los registros dentro de esta 
        //clase
        this.regSize = 140;
        
        //una validacion basica
        if(file.exists() && !file.isFile()){
            throw new IOException(file.getName() 
                    + " is an invalid file");
        }
        else{
            //crear la nueva instancia de randomAccessFile
            randomAccessFile = new java.io.RandomAccessFile(file, "rw");
            
            //necesitamos indicar cuantos registros tiene el archivo
            this.regsQuantity = (int)Math.ceil((double)randomAccessFile.length() / (double)regSize);
        }
    }//fin start
    
    //cierra la conexion de mi programa con el archivo que estoy manipulando

    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    //indica la cantidad de registros del archivo actual

    public int fileSize(){
        return regsQuantity;
    }
    
    //inserta un nuevo registro pero en una posicion existente

    public boolean putValue(int position, Book myBook) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(myBook.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeUTF(myBook.getTitle());
                randomAccessFile.writeUTF(myBook.getEdition());
                randomAccessFile.writeUTF(myBook.getISBN());
                randomAccessFile.writeInt(myBook.getID());
                randomAccessFile.writeUTF(myBook.getFK_student());
                randomAccessFile.writeUTF(myBook.getState());
                randomAccessFile.writeUTF(myBook.getLentDate());
                randomAccessFile.writeUTF(myBook.getReturnDate());
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }//fin metodo
    
    //agrega un registro nuevo pero al final del archivo, por esa razon se incrementa la cantidad de registros

    public boolean addEndRecord(Book myBook) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, myBook);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    
    //obtiene un registro de una persona en la posicion indicada

    public Book getBook(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Book myBook = new Book();
            
            //llevamos a cabo las lecturas
            myBook.setTitle(randomAccessFile.readUTF());
            myBook.setEdition(randomAccessFile.readUTF());
            myBook.setISBN(randomAccessFile.readUTF());
            myBook.setID(randomAccessFile.readInt());
            myBook.setFK_student(randomAccessFile.readUTF());
            myBook.setState(randomAccessFile.readUTF());
            myBook.setLentDate(randomAccessFile.readUTF());
            myBook.setReturnDate(randomAccessFile.readUTF());
            
            //si es delete no retorno
            if(myBook.getTitle().equalsIgnoreCase("delete")){
                return null;
            }
            else{
                return myBook;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }
    
    //consulta todos los registros de mi archivo

    public ArrayList<Book> getAllBooks() throws IOException{
        
        //variables a retornar
        ArrayList<Book> books = new ArrayList<Book>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Book bookTemp = this.getBook(i);
            
            if(bookTemp != null){
                books.add(bookTemp);
            }
        }
        
        return books;
    }//fin metodo
    
    
    public boolean deleteRecord(String title) throws IOException{
        Book myBook;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la persona de esa posicion
            myBook = this.getBook(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myBook.getTitle().equalsIgnoreCase(title)){

                //marcar esta persona como eliminada
                myBook.setTitle("deleted");

                return this.putValue(i, myBook);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }
}
