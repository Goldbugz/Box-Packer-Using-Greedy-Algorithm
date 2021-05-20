//is a box object used in boxlist

public class box{
    int space;
    int originalSpace;
    String name;
    int cost;
    box next;
    int useCount = 0;
    float dollarCost;
    BookList bList = new BookList();
    public box(int s,String n, int c){
        space = s;
        name = n;
        cost = c;
        originalSpace = s;
        dollarCost = (float)cost/100;
    }
}