//is a book object used in booklist

public class book{
    String title;
    String isbn;
    int weight;
    book next;
    public book(String t, String i, int w){
        title = t;
        isbn = i;
        weight = w;
    }

    public void printBook(){
        System.out.println(isbn + " " + title+ " " + weight);
    }
}