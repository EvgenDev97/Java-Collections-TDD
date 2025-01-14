package ArrayList;

import ArrayList.Car.Car;
import ArrayList.Car.CarArrayList;
import ArrayList.Car.CarList;
import CarCollection.CarCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CarCollections  list = new CarArrayList();
        for (int i = 0; i < 10; i++) {
            list.addCar(new Car("Brand" + i, i));
        }
        for(Car car : list) {
            System.out.println(car.getBrand() + " " + car.getNumber());
        }
    }
}
