/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class AudiovisualFile {
    //atributos
    /**
     * 
     */
    public java.io.RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;
    
    //constructor
    /**
     * 
     * @param file
     * @throws IOException
     */
    public AudiovisualFile(File file) throws IOException{
        start(file);
    }
    
    /**
     * instancia el random access file y coloca el valor
     * de mis variables privadas
     * @param file
     * @throws IOException
     */
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
    
    /**
     * cierra la conexion de mi programa con el archivo que
     * estoy manipulando
     * @throws IOException
     */
    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    /**
     * indica la cantidad de registros del archivo actual
     * @return cantidad de registros
     */
    public int fileSize(){
        return regsQuantity;
    }
    
    /**
     * inserta un nuevo registro pero en una posicion existente
     * @param position
     * @param myAV
     * @return
     * @throws IOException
     */
    public boolean putValue(int position, Audiovisual myAV) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(myAV.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeInt(myAV.getCode());
                randomAccessFile.writeUTF(myAV.getModel());
                randomAccessFile.writeInt(myAV.getID());
                randomAccessFile.writeUTF(myAV.getFK_student());
                randomAccessFile.writeUTF(myAV.getState());
                randomAccessFile.writeUTF(myAV.getLentDate());
                randomAccessFile.writeUTF(myAV.getReturnDate());
                
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }//fin metodo
    
    /**
     * agrega un registro nuevo pero al final del archivo, por esa razon
     * se incrementa la cantidad de registros
     * @param person
     * @return
     * @throws IOException
     */
    public boolean addEndRecord(Audiovisual myAV) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, myAV);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    
    /**
     * obtiene un registro de una persona en la posicion indicada
     * @param position
     * @return objeto de tipo Person con los datos del registro de esa persona
     * @throws IOException
     */
    public Audiovisual getAudiovisual(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Audiovisual myAV = new Audiovisual();
            
            //llevamos a cabo las lecturas
            myAV.setCode(randomAccessFile.readInt());
            myAV.setModel(randomAccessFile.readUTF());
            myAV.setID(randomAccessFile.readInt());
            myAV.setFK_student(randomAccessFile.readUTF());
            myAV.setState(randomAccessFile.readUTF());
            myAV.setLentDate(randomAccessFile.readUTF());
            myAV.setReturnDate(randomAccessFile.readUTF());
            
            //si es delete no retorno
            if(myAV.getModel().equalsIgnoreCase("delete")){
                return null;
            }
            else{
                return myAV;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }//fin de metodo
    
    /**
     * consulta todos los registros de mi archivo
     * @return una lista de objetos tipo Person
     * @throws IOException
     */
    public ArrayList<Audiovisual> getAllAudiovisuals() throws IOException{
        
        //variables a retornar
        ArrayList<Audiovisual> audiovisuals = new ArrayList<Audiovisual>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Audiovisual avTemp = this.getAudiovisual(i);
            
            if(avTemp != null){
                audiovisuals.add(avTemp);
            }
        }
        
        return audiovisuals;
    }//fin metodo
    
    
    public boolean deleteRecord(String title) throws IOException{
        Audiovisual myAV;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la persona de esa posicion
            myAV = this.getAudiovisual(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myAV.getModel().equalsIgnoreCase(title)){

                //marcar esta persona como eliminada
                myAV.setModel("deleted");

                return this.putValue(i, myAV);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }
}
