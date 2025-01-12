import ArrayList.Car.Car;
import ArrayList.Car.CarArrayList;
import ArrayList.Car.CarList;
import LinkedList.CarLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class   CarListTest    {

    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList();
        for(int i =0; i<100; i++){
            carList.addCar(new Car("Brand" + i, i));
        }
    }

    @Test
    public void  testGetCar(){
        Car car = carList.getCar(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void testSizeWhenAdd100TheSizeMustBe100(){
        assertEquals(100, carList.size());
    }

    @Test
    public void removeAtIndexTheSizeMustBeDecreased(){
        assertTrue(carList.removeAtIndex(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void removeByCarTheSizeMustBeDecreased(){
        Car car = new Car("Brand1", 1);
        carList.addCar(car);
        assertEquals(101, carList.size());
        assertTrue(carList.removeCar(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void removeByNonExistingCar(){
        Car car = new Car("BMW", 12);
        assertFalse(carList.removeCar(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void clearTheSizeMustBeZero(){
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenOutOfRange(){
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carList.getCar(100);
        });
    }

    @Test
    public void insertIntoMiddle(){
        Car car = new Car("BMW", 1);
        carList.add(car, 50);
        Car carFromList = carList.getCar(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLast(){
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        Car carFromList = carList.getCar(100);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirst(){
        Car car = new Car("BMW", 1);
        carList.add(car, 0);
        Car carFromList = carList.getCar(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void IfCarContainReturnTrueElseFalse(){
        Car car = new Car("BMW", 1);
        carList.add(car, 100);
        assertTrue(carList.contains(car));
        carList.removeCar(car);
        assertFalse(carList.contains(car));
    }
}