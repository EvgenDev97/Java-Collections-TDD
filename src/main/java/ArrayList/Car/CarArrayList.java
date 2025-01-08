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
    public void addCar(Car car) {
        if(size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = car;
        size++;
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
    public boolean removeAtIndex(int index) {
        indexOutOfRange(index);
        for(int i = 0; i < size - 1; i++) {
            array[i] = array[i + 1];
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
        array = new Car[10];
        size = 0;
    }

    private void indexOutOfRange(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
