package HashSet;

import ArrayList.Car.Car;

public interface CarSet {

    boolean addCar(Car car);

    boolean removeCar(Car car);

    int size();

    void clear();
}
