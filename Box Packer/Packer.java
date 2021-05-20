//Written By Damien King
//Packs boxes using the greedy album
//Uses a PriorityQueue to load book objects and places them int linked list box objects
//Then prints out statistics about the boxes packed


public class Packer {
    public static void main(String[] args) {
        //creates all lists and variables
    BoxList bl = new BoxList();
    PriorityQueue<book> books = new PriorityQueue<book>(1000);
    //box [] boxOptions = new box[100];
    BoxList boxOptions = new BoxList();

    shippingReader sr = new shippingReader();
    bookReader br = new bookReader();

    //weight of all remaining books
    int totalWeight;
    boolean readCheck = false;
    boolean readCheck2 = false;

    //keeps going if there enough command line arguments
    if(args.length == 2) {
       readCheck = sr.read(boxOptions, args[0]);
       readCheck2 = br.read(books, args[1]);
    }
        totalWeight = br.totalWeight;


    //ensures that both of the files were read successfully
        if(readCheck&& readCheck2){


        book temp;
        //loops until there are no more books left
        while(!books.isEmpty()){
            //System.out.println("loop");
            temp = books.remove();


            totalWeight = totalWeight -temp.weight;
            box c = bl.head;
            boolean insertCheck = false;


            //loops through boxes seeing if any of them can fit the current book
            if(c != null) {
                while (c.next != null && !insertCheck) {

                    //checks if the book can fit in the current box
                    if (c.space >= temp.weight) {
                        c.bList.insert(temp);
                        c.space = c.space - temp.weight;
                       // totalWeight = totalWeight - temp.weight;
                        insertCheck = true;
                       // c = null;
                        //break;
                    }
                    else
                        c = c.next;
                }
            }

            //if none of the boxes fit the current book, this will grab a new book and place the book into it
            if(!insertCheck){
                box bestBox;

                box current = boxOptions.head;
                System.out.println(totalWeight+ current.name+ current.space);
                System.out.println(temp.title);
                while(true){
                   // System.out.println("loop");
                    if(current.next == null){
                        bestBox = current;
                        bestBox.useCount = bestBox.useCount +1;
                        //bestBox.next = null;
                        break;
                    }
                    else if(totalWeight < current.space/2 || totalWeight < current.space){
                       // System.out.println("reaches here");
                        bestBox = current;
                        // bestBox.next = null;
                        break;
                    }
                  else if(totalWeight > current.space/2){
                       current = current.next;
                   }

                }

                box nb = new box(bestBox.space, bestBox.name, bestBox.cost);
                nb.bList.insert(temp);
                nb.space = bestBox.space - temp.weight;
                nb.next = null;
                bl.insert(nb);
                //System.out.println("reaches best box insert");
            }
        }
    //prints out additional statistics
        int totalBoxes = 0;
        bl.printList();
        box fc = boxOptions.head;
        while(fc != null){
            totalBoxes = totalBoxes + fc.useCount;
            System.out.println(fc.name + " boxes= " + fc.useCount);
            fc = fc.next;
        }
        System.out.println("----------------------");
        System.out.println("Total Boxes: " + totalBoxes);
    }
    else
        System.out.println("Please enter valid command line arguments");


    }
}
