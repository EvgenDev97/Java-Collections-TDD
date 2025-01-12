package ArrayList.Car;

import java.util.Arrays;

public class CarArrayList implements CarList {

    private Car[] array = new Car[10];
    int size = 0;

    @Override
    public Car getCar(int index) {
        indexOutOfRange(index);
        return array[index];
    }

    @Override
    public boolean addCar(Car car) {
        increaseArray();
        array[size] = car;
        size++;
        return true;
    }

    @Override
    public boolean removeCar(Car car) {
       for(int i = 0; i < size; i++) {
           if(array[i].equals(car)) {
               return removeAtIndex(i);
           }
       }
       return false;
    }


    @Override
    public boolean contains(Car car) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(car)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeAtIndex(int index) {
        indexOutOfRange(index);
        increaseArray();
        System.arraycopy(array, index + 1, array, index, size - index - 1);
//        for(int i = 0; i < size - 1; i++) {
//            array[i] = array[i + 1];
//        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }



    @Override
    public void add(Car car, int index) {
        increaseArray();
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size - index >= 0) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
//        for(int i = size; i > index; i--) {
//            array[i] = array[i -1];
//        }
        array[index] = car;
        size++;
    }


    private void increaseArray(){
        if(size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void indexOutOfRange(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

}
