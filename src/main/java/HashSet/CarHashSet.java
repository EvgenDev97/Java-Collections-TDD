package HashSet;

import ArrayList.Car.Car;

public class CarHashSet implements CarSet {

    private static final int INITIAL_CAPACITY = 16;
    private Entry[] arrayCars = new Entry[INITIAL_CAPACITY];
    private int size = 0;
    private static final double LOAD_FACTOR = 0.75;



    @Override
    public boolean addCar(Car car) {
        if(size >= (arrayCars.length * LOAD_FACTOR)) {
            increaseArray();
        }
        boolean result = add(car, arrayCars);
        if(result) {
            size++;
        }
        return result;
    }


    private boolean add (Car car, Entry[] dst) {
        int position = getElementPosition(car, dst.length);
        if(dst[position] == null) {
            Entry entry = new Entry(car, null);
            dst[position] = entry;
            return true;
        }else{
            //check cell
            Entry existedElement = dst[position];
            while(true){
                //check dublicate
                if(existedElement.value.equals(car)) {
                    return false;
                    //adding element
                }else if(existedElement.next == null){
                    existedElement.next = new Entry(car, null);
                    return true;
                }else {
                    existedElement = existedElement.next;
                }
            }
        }
    }

    @Override
    public boolean removeCar(Car car) {
        int position = getElementPosition(car, arrayCars.length);
        if(arrayCars[position] == null) {
            return false;
        }
        Entry secondLast = arrayCars[position];
        Entry last = secondLast.next;
        if(secondLast.value.equals(car)) {
            arrayCars[position] = last;
            size--;
            return true;
        }
        while(last != null){
            if(last.value.equals(car)) {
                secondLast.next = last.next;
                size--;
                return true;
            }else {
                secondLast = last;
                last = last.next;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        arrayCars = new Entry[INITIAL_CAPACITY];
    }

    @Override
    public boolean contains(Car car) {
            int position = getElementPosition(car, arrayCars.length);
        Entry currentElement = arrayCars[position];
        while(currentElement != null){
            if(currentElement.value.equals(car)) {
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }


    private void increaseArray(){
        Entry[] newArray = new Entry[arrayCars.length * 2];
        for(Entry entry : arrayCars){
            Entry existedElement = entry;
            while(existedElement != null){
                add(existedElement.value, newArray);
                existedElement = existedElement.next;
            }
        }
        arrayCars = newArray;
    }

    private int getElementPosition(Car car, int arrayLength) {
        return Math.abs(car.hashCode() % arrayLength);
    }


    private static class Entry{
        private Car value;
        private Entry next;

        public Entry(Car value, Entry next) {
            this.value = value;
            this.next = next;
        }
    }
}
