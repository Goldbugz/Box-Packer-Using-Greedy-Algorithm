//Written By Damien King
//creates a linked list of box objects
public class BoxList {

    //inserts a box object into the linked list
    box head;
    void insert(int s, String na, int co){
        box c = head;
        box n = new box(s, na, co);
        if(c != null) {
            while (c.next != null) {
                //System.out.println("loop");
                c = c.next;
            }


            c.next = n;
        }
        else
            head = n;


    }

    //inserts a box using another input box
    void insert(box n){
        box c = head;
       // box n = new box(s, na, co);
        if(c != null) {
            while (c.next != null) {
                //System.out.println("loop");
                c = c.next;
            }


            c.next = n;
        }
        else
            head = n;


    }

    //loops through list and prints out boxes and statistics about the box list and its shipping contents
    void printList(){
        System.out.println("Packing List");

        box c = head;
        int counter = 0;
        int boxWeight = 0;

        int totalWeight = 0;
        int totalSpace = 0;
        float totalCost = 0;
        while(c != null){
            //System.out.println("loop");
            counter ++;
            boxWeight = 0;
            System.out.println("Box " + counter + " use a "+ c.name + " box");

            book cb = c.bList.head;
            while(cb != null){
                //System.out.println("loop");
                boxWeight = boxWeight + cb.weight;
                cb.printBook();
                cb = cb.next;
            }
            totalWeight = totalWeight + boxWeight;
            totalCost = totalCost +c.dollarCost;
            totalSpace = totalSpace + c.originalSpace;
            System.out.println("-------------------------------------");
            System.out.println("Box weight " + boxWeight+ " Box Cost $" + c.dollarCost);
            System.out.println("Space unused: " + (c.originalSpace - boxWeight));
            System.out.println();
            System.out.println();
            System.out.println("Total weight: " +  totalWeight);
            System.out.println("Total unused: " +  (totalSpace - totalWeight));
            System.out.println("Total Cost $"+ totalCost);
            c = c.next;
        }
    }

}
