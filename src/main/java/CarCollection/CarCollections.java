package CarCollection;

import ArrayList.Car.Car;

public interface CarCollections {

    boolean addCar(Car car);

    boolean removeCar(Car car);

    int size();

    void clear();

    boolean contains(Car car);
}
