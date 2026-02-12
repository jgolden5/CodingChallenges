package Codewars;

import java.util.ArrayList;
public class LinkedListPairs {
    public static Node swapPairs(Node head) {
        ArrayList<Node> nodeArr = new ArrayList<Node>();
        System.out.println(head.printList());
        Node tempHead = head.next;
        //swap each pair and put it into an arraylist
        while(head.next != null) {
            tempHead = new Node(head.next.getValue()); //we don't want the whole linked list from head--we just want values switched
            tempHead.next = new Node(head.getValue());
            head = head.next.next != null ? new Node(head.next.next) : null;
            nodeArr.add(tempHead); //nodeArr will be converted to the resulting linked list, so add the entire node
            nodeArr.add(tempHead.next);
            if(head == null) { break; }
        }
        //add last node to array list if there's an odd number of nodes in linked list
        if(head != null) {
            nodeArr.add(head); //this adds last node to nodeArray if there's an odd number of nodes in head
        }
        //move array list to final linked list accessed through result node
        Node result = new Node(tempHead.getValue());
        for(int i = 0; i < nodeArr.size(); i++) {
            if(tempHead.next != null) {
                tempHead = tempHead.next;
            }
        }
        System.out.println(result.printList());
        return result;
    }
}
