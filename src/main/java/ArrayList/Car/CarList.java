package ArrayList.Car;

public interface CarList {
    Car getCar(int index);
    void addCar(Car car);
    boolean removeCar(Car car);
    boolean removeAtIndex(int index);
    int size();
    void clear();
    void add(Car car, int index);
}
