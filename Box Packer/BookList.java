public class BookList {
    book head;

    void insert(String t, String i, int w){
        book c = head;
        book n = new book(t,i,w);
        if(c != null) {
            while (c.next != null) {
                c = c.next;
            }
            c.next = n;
        }
        else
            head = n;

    }

    void insert(book n){
        book c = head;
       // book n = new book(t,i,w);
        if(c != null) {
            while (c.next != null) {
                c = c.next;
                //System.out.println("loop");
            }
            c.next = n;
        }
        else
            head = n;

    }

}


