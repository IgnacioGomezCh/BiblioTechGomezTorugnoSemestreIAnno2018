/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bibliotechgomeztorugnosemestreianno2018;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Nacho
 */
public class FileIO {
    //class atributes
    
    File fileBook = new File("./Books.dat");
    File fileAV = new File("./Audiovisual.dat");
    File fileStudent = new File("./Students.dat");
    BookFile bookFile;
    AudiovisualFile avFile;
    StudentFile studentFile;
    
    public FileIO() throws IOException{
        bookFile = new BookFile(fileBook);
        avFile = new AudiovisualFile(fileAV);
        studentFile = new StudentFile(fileStudent);
    }

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
    
    //Methods Books
    public boolean addBook(Book book){
        try{
            bookFile.addEndRecord(book);
            return true;
        }catch(IOException e){
            return false;
        }
    }
    
    
}
