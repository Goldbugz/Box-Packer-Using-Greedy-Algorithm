//written by Damien King
//takes in a book order file and creates new book objects

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bookReader {
    int totalWeight;
    public boolean read(PriorityQueue<book> bl, String fn){
        try{
            File file = new File(fn);
            Scanner f = new Scanner(file);
            String temp;
            String [] ls;

            while(f.hasNextLine()){
                //System.out.println("loop");
                temp = f.nextLine();
                ls = temp.split("/");

                //test this with errors

                book n = new book(ls[1],ls[0],Integer.parseInt(ls[2]));
                bl.insert(n.weight, n);
                totalWeight = totalWeight + n.weight;
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
