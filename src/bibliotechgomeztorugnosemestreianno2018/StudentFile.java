package bibliotechgomeztorugnosemestreianno2018;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class StudentFile {
    public java.io.RandomAccessFile randomAccessFile;
    private int regsQuantity;//me indica la cantidad de registros
    private int regSize;
    private String myFilePath;
    
    //constructor
    public StudentFile(File file) throws IOException{
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
    }
    
    //cierra la conexion de mi programa con el archivo que estaba abierto
     
    public void close() throws IOException{
        randomAccessFile.close();
    }
    
    //indica la cantidad de registros del archivo actual

    public int fileSize(){
        return regsQuantity;
    }
    
    //inserta un nuevo registro pero en una posicion existente
    public boolean putValue(int position, Student myStudent) throws IOException{
        //una pequenna validacion antes de insertar
        if(position >= 0 && position <= regsQuantity){
            if(myStudent.size() > regSize){
                System.err.print("7001 record size is out of bounds");
                return false;
            }
            else{
                //escribimos en archivo
                randomAccessFile.seek(position * regSize);
                randomAccessFile.writeUTF(myStudent.getName());
                randomAccessFile.writeUTF(myStudent.getID());
                randomAccessFile.writeUTF(myStudent.getPassword());
                randomAccessFile.writeDouble(myStudent.getPedingFine());
                return true;
            }
        }
        else{
            System.err.print("7002 position is "
                    + "out of bounds of this file");
                return false;
        }
        
    }
    
    //agrega un registro nuevo pero al final del archivo, por esa razon se incrementa la cantidad de registros

    public boolean addEndRecord(Student myStudent) throws IOException{
        //insertar al final del archivo
        boolean success = putValue(regsQuantity, myStudent);
        
        if(success){
            ++regsQuantity;
        }
        return success;
    }
    
    
    //obtiene un registro de una persona en la posicion indicada

    public Student getStudent(int position) throws IOException{
        //validacion de la posicion
        if(position >= 0 && position <= regsQuantity){
            //colocamos el puntero en el lugar 
            randomAccessFile.seek(position * regSize);
            
            //instancia de person
            Student myStudent = new Student();
            
            //llevamos a cabo las lecturas
            myStudent.setName(randomAccessFile.readUTF());
            myStudent.setID(randomAccessFile.readUTF());
            myStudent.setPassword(randomAccessFile.readUTF());
            myStudent.setPedingFine(randomAccessFile.readDouble());
            
            //si es delete no retorno
            if(myStudent.getName().equalsIgnoreCase("delete")){
                return null;
            }
            else{
                return myStudent;
            }
            
        }
        else{
            System.err.println("6001 position is out of bounds");
            return null;
        }
    }
    
    //consulta todos los registros de mi archivo
    public ArrayList<Student> getAllStudents() throws IOException{
        
        //variables a retornar
        ArrayList<Student> students = new ArrayList<Student>();
        
        //recorro todos mis registros y los inserto en la lista
        for(int i = 0; i < regsQuantity; i++){
            Student studentTemp = this.getStudent(i);
            
            if(studentTemp != null){
                students.add(studentTemp);
            }
        }
        
        return students;
    }
    
    
    public boolean deleteRecord(String title) throws IOException{
        Student myStudent;
        
        //buscar el registro para la eliminacion
        for(int i = 0; i < regsQuantity; i++){
            
            //obtengo a la persona de esa posicion
            myStudent = this.getStudent(i);
                
            //pregunto si es la persona que quiero eliminar
            if(myStudent.getName().equalsIgnoreCase(title)){

                //marcar esta persona como eliminada
                myStudent.setName("deleted");

                return this.putValue(i, myStudent);
            }
        }
        
        //si llega a este punto no encontro a la persona
        return false;
    }
}
