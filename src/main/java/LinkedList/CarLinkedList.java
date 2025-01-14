package LinkedList;

import ArrayList.Car.Car;
import ArrayList.Car.CarList;

import java.util.Iterator;

public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car getCar(int index) {
        return getNode(index).value;
    }

    @Override
    public boolean addCar(Car car) {
        if(size == 0){
            Node node = new Node(null, car, null);
            first = node;
            last = node;
        }else{
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }


    @Override
    public boolean contains(Car car) {
        Node node = first;
        for(int i = 0; i < size; i++){
            if(node.value.equals(car)){
                return true;
            }
            node = node.next;
        }
        return false;
    }


    @Override
    public boolean removeCar(Car car) {
        Node node = first;
        for(int i = 0; i < size; i++){
            if(node.value.equals(car)){
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
        Node nodePrev = node.previous;
        if(nodeNext != null){
            nodeNext.previous = nodePrev;
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
    public void add(Car car, int index) {
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == size){
            addCar(car);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrev = nodeNext.previous;
        Node newNode = new Node(nodePrev, car, nodeNext);
        nodeNext.previous = newNode;
        if(nodePrev != null){
            nodePrev.next = newNode;
        }else{
            first = newNode;
        }
        size++;
    }



    private Node getNode(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public Iterator<Car> iterator() {
        return new Iterator<Car>() {
            private Node node = first;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Car next() {
                Car car = node.value;
                node = node.next;
                return car ;
            }
        };
    }


    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
