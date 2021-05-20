//written by damien king
//takes in a shipping settings file and iterates through and creates box options

import com.sun.jdi.InvalidTypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class shippingReader {
    public boolean read(BoxList bo, String fn){
        try{
            File file = new File(fn);
           Scanner f = new Scanner(file);
            String temp;
            String [] ls;

            while(f.hasNextLine()){
               // System.out.println("loop");
               temp = f.nextLine();
               ls = temp.split("/");

               //test this with errors
               //box n = new box(Integer.parseInt(ls[1]),ls[0], Integer.parseInt(ls[2]));
               bo.insert(Integer.parseInt(ls[1]),ls[0], Integer.parseInt(ls[2]));

           }

            return true;
        }
        catch(FileNotFoundException E){
            System.out.println("File not found please input a valid shipping options file");
        }

        catch(NumberFormatException ne){
            System.out.println("There was an error in reading the file. Please check its contents and retry.");
        }

        return false;
    }
}
