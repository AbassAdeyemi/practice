package com.example.practicejava;

public class LinkedList {

    Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data) {
        Node newNode = new Node(data);

        if(list.head == null) {
            list.head = newNode;
        }
        else {
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }

        return list;
    }

    public static LinkedList delete(LinkedList list, int data) {
        Node currentNode = list.head; Node prev;

        if(currentNode != null && currentNode.data == data) {
            list.head = currentNode.next;
        }

        else {
            while(currentNode != null) {
                prev = currentNode;
                currentNode = currentNode.next;
                if(currentNode.data == data) {
                    prev.next = currentNode.next;
                    break;
                }
            }
        }
        return list;
    }

    public static LinkedList deleteAtPosition(LinkedList list, int position) {
        Node currentNode = list.head; Node prev = null;

        if(currentNode != null && position == 0) {
            list.head = currentNode.next;
        }
        else {
            int count = 0;
            while(currentNode != null) {
                 if(count == position) {
                     prev.next = currentNode.next;
                     break;
                 }
                 prev = currentNode;
                 currentNode = currentNode.next;

                 count++;
            }
        }

        return list;
    }

    public static void printList(LinkedList list) {
        Node currentNode = list.head;

        while(currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static  void main(String ... args) {
        LinkedList list = new LinkedList();
         list = insert(list, 2);
         list = insert(list, 5);
         list = insert(list, 7);

    //     delete(list, 7);
        deleteAtPosition(list, 2);
         printList(list);
      //  System.out.println(retrieveAtPosition(list, 3));
    }
}
