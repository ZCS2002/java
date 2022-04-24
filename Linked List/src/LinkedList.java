public class LinkedList {
    Node head;   // beginning of the list

    static class Node {
        int info;
        Node next;

    Node (int in) {     // constructor
        info = in;
        next = null;
        }
    }

    public static LinkedList insertion(LinkedList list, int datum) {
        Node newNode = new Node(datum);
        newNode.next = null;

        if (list.head == null) {    // put a new Node as the head if empty
            list.head = newNode;
        }
        else {
            Node endEl = list.head;   // insert the Node at the end of the list
            while (endEl.next != null) {
                endEl = endEl.next;
            }
            endEl.next = newNode;
        }
        return list;
    }

    public static LinkedList deletion(LinkedList list, int keyLoc) {
         // Store head node
         Node currNode = list.head;
         Node prev = null;
  
         if (currNode.info == keyLoc && currNode != null) {
             list.head = currNode.next;
             System.out.println("Deleted: " + keyLoc);
             return list;
         }
         while (currNode.info != keyLoc && currNode != null) {
             prev = currNode;
             currNode = currNode.next;
         }
         if (currNode != null) {
             prev.next = currNode.next;
             System.out.println("Deleted: " + keyLoc);
         }
         return list;
     }

    public static void listPrinter(LinkedList list) {
        Node currNode = list.head;
        System.out.println();
        System.out.print("Current Linked List: ");

        while (currNode != null) {
            System.out.print(currNode.info + " ");
            currNode = currNode.next;
        }
        System.out.println("\n");
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        //TESTING INSERT METHOD
        list = insertion(list, 5);
        list = insertion(list, 10);
        list = insertion(list, 15);
        list = insertion(list, 20);
        list = insertion(list, 25);
        list = insertion(list, 30);
        listPrinter(list);  // should be 5, 10, 15, 20, 25, 30

        //TESTING DELETE METHOD
        deletion(list, 10);
        deletion(list, 5);
        deletion(list, 25);
        listPrinter(list);  // should be 15, 20, 30
    }
}