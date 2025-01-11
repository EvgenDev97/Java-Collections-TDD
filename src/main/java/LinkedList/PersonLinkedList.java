package LinkedList;

import ArrayList.Person.Person;
import ArrayList.Person.PersonInterface;

public class PersonLinkedList implements PersonInterface {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Person getPerson(int index) {
        return getNode(index).value ;
    }

    @Override
    public void addPerson(Person p) {
        if(size == 0){
            Node node = new Node(null, p, null);
            first = node;
            last = node;
        }else{
            Node secondLast = last;
            last = new Node(secondLast, p, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public boolean removePerson(Person p) {
        Node node = first;
        for(int i = 0; i < size; i++){
            if(node.value.equals(p)){
                return removeAtIndex(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAtIndex(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrev = node.prev;
        if(nodeNext != null){
            nodeNext.prev = nodePrev;
        }else{
            last = nodePrev;
        }
        if(nodePrev != null){
            nodePrev.next = nodeNext;
        }else{
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void addPersonIndex(Person p, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            addPerson(p);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrev = nodeNext.prev;
        Node newNode = new Node(nodePrev, p, nodeNext);
        nodeNext.prev = newNode;
        newNode.next = nodeNext;
        if (nodePrev != null) {
            nodePrev.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }


    private Node getNode(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    private  static class Node {
        private Node prev;
        private Person value;
        private Node next;

        public Node(Node next, Person value, Node prev) {
            this.next = next;
            this.value = value;
            this.prev = prev;
        }
    }
}
