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
 * @author Jtoru1
 */
public class Library {
    //Class atributes
    private String name;
    private final int ID;
    private ArrayList<Asset> assetList = new ArrayList();
    private ArrayList<Student> studentList = new ArrayList();
    
     File fileBook = new File("./Books.dat");
    File fileAV = new File("./Audiovisual.dat");
    File fileStudent = new File("./Students.dat");
    BookFile bookFile;
    AudiovisualFile avFile;
    StudentFile studentFile;

    
    
    //blank constructor
    public Library() throws IOException{
        this.ID = -1;
        bookFile = new BookFile(fileBook);
        avFile = new AudiovisualFile(fileAV);
        studentFile = new StudentFile(fileStudent);
    }

    //simple constructor
    public Library(String name, int ID) throws IOException {
        bookFile = new BookFile(fileBook);
        avFile = new AudiovisualFile(fileAV);
        studentFile = new StudentFile(fileStudent);
        this.name = name;
        this.ID = ID;
    }
    
    //normal constructor
    public Library(String name, int ID, ArrayList<Asset> assetList, ArrayList<Student> studentList) throws IOException{
        bookFile = new BookFile(fileBook);
        avFile = new AudiovisualFile(fileAV);
        studentFile = new StudentFile(fileStudent);
        this.name = name;
        this.ID = ID;
        this.assetList = assetList;
        this.studentList = studentList;
    }
    
    //Getter & Setter
    
    public File getFileBook() {
        return fileBook;
    }

    public void setFileBook(File fileBook) {
        this.fileBook = fileBook;
    }

    public File getFileAV() {
        return fileAV;
    }

    public void setFileAV(File fileAV) {
        this.fileAV = fileAV;
    }

    public File getFileStudent() {
        return fileStudent;
    }

    public void setFileStudent(File fileStudent) {
        this.fileStudent = fileStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Carga la lista de assets de el archivo de memoria.
    //Hace una union entre libros y audiovisual
    public ArrayList<Asset> getAssetList() throws IOException {
        ArrayList<Asset> myList = new ArrayList();
        ArrayList<Audiovisual> myAV = new ArrayList();
        ArrayList<Book> myBooks = new ArrayList();
        
        //Carga ambas listas de memoria
        myBooks = bookFile.getAllBooks();
        myAV = avFile.getAllAudiovisuals();
        
        for(Book temp: myBooks)
            myList.add(temp);
        for(Audiovisual temp: myAV)
            myList.add(temp);
        
        return myList;
    }

    public void setAssetList(ArrayList<Asset> assetList){
        this.assetList = assetList;
    }
    
    //Carga la lista de estudiantes de el archivo de memoria.
    public ArrayList<Student> getStudentList() throws IOException {
        ArrayList<Student> myList = new ArrayList();
        myList = studentFile.getAllStudents();
        return myList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    //Annade un asset al final del archivo 
    public boolean addAsset(Asset myAsset){
        try{
            //primero busca que tipo de asset 
            assetList.add(myAsset);
            if(myAsset instanceof Book){
                bookFile.addEndRecord((Book) myAsset);
            }
            else{
                avFile.addEndRecord((Audiovisual) myAsset);
            }
            
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    //Annade un estudiante al final del archivo 
    public boolean addStudent(Student myStudent){
        try{
            studentList.add(myStudent);
            studentFile.addEndRecord(myStudent);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    //Retorna cantidad de registros en el archivo de libros
    public int maxBooks(){
        return bookFile.fileSize();
    }
    
    //Retorna cantidad de registros en el archivo de audiovisual
    public int maxAV(){
        return avFile.fileSize();
    }
    
    //Metodo que actualiza informacion de los assets
    public boolean updateAsset(Asset myAsset){
        try{
            //El instanceof se usa para ver si es libro o audiovisual
            if(myAsset instanceof Book){
                bookFile.putValue(myAsset.getID()-1, (Book) myAsset);
            }
            else{
                avFile.putValue(myAsset.getID()-1, (Audiovisual) myAsset);
            }
            return true;
        }catch(IOException e){
            return false;
        }
    }
}
