package HashMap;

import ArrayList.Car.Car;

import java.util.List;
import java.util.Set;

public interface CarOwnerList {
    void put(CarOwner key, Car value);

    Car get(CarOwner key);

    Set<CarOwner> keySet();

    List<Car> values();

    boolean remove(CarOwner key);

    int size();

    void clear();
}
