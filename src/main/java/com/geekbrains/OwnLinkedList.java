package com.geekbrains;

public class OwnLinkedList<T> {
    private long size;
    private Node head;
    private Node tail;

    public OwnLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addNode(T data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }


    public void addIndex(int index, T data){
        if (index < 0|| index>size) {
            System.out.println("Не верно уккзан индекс");
          return;
        }

        Node current = head;
        if (index==0){
            // создаем новый элемент и передаем в него згачение
            Node addHead = new Node(data);
            // значение их головного элемента передаем в следующий елемент
            addHead.next = head;

            head = addHead;

            size++;
        return;}

        else if (index >0 & index < size) {

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node indexAdd = new Node(data);
            indexAdd.next = current.next;
            current.next = indexAdd;
            size++;
            return;
        }
        else
           addNode(data);
    }

    public void remove (int index){
        if (index<0||index>=size){
            System.out.println("Не верно указан индекс");
            return;
        }
        if (index==0){

            head = head.next;
            size--;
            return;
        }
        if (index!= 0 & index < size) {
            Node current = head;
            Node remove = head;
            for (int i = 0; i < index-1; i++) {
                current = current.next;
            }
            // равен текущему элементу
            remove = current;
            // берем следующий элемент
            current = current.next;
            // текущий элемент равен следущему
            remove.next = current.next;
            size--;

        }

        }




    public void display() {
        Node current = head;

        if (head == null) {
            System.out.println("Односвязный список пуст");
            return;
        }

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void display(int index) {
        if (index > size) {
            System.out.println("Размер списка больше чем заданный индекс");
            return;
        }

        Node current = head;

        for (int i = 1; i <= index; i++) {
            current = current.next;
        }

        System.out.println(current.data);
    }


    private class Node {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
