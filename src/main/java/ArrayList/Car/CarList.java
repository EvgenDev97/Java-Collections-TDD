package ArrayList.Car;


import CarCollection.CarCollections;

public interface CarList extends CarCollections {
    Car getCar(int index);
    boolean removeAtIndex(int index);
    void add(Car car, int index);
}
