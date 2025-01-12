import ArrayList.Car.Car;
import HashSet.CarHashSet;
import HashSet.CarSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CarSetTest {

    private CarSet carSet;

    @BeforeEach
    void setUp() {
        carSet = new CarHashSet();
        for(int i = 0; i < 100; i++){
            carSet.addCar(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAddThreeSimilarObjectsThanSizeIncreaseByOne() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.addCar(new Car("CAR", 10)));;
        assertFalse(carSet.addCar(new Car("CAR", 10)));
        assertFalse(carSet.addCar(new Car("CAR", 10)));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenSetClearTheSizeMustBeZero() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenElementRemovedTheSizeMustBeDecreased(){
        assertTrue(carSet.removeCar(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.removeCar(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }

    @Test
    public void whenSizeTheMustBe100(){
        carSet.size();
        assertEquals(100, carSet.size());
    }

    @Test
    public void ifSetContainsCarReturnTrueElseFalse() {
        Car car = new Car("BMW", 10);
        carSet.addCar(car);
        assertTrue(carSet.contains(car));
        carSet.removeCar(car);
        assertFalse(carSet.contains(car));
    }
}