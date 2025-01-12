import ArrayList.Car.Car;
import CarCollection.CarCollections;
import HashSet.CarHashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarCollectionsTest {

    private CarCollections carCollections;
    @BeforeEach
    void setUp() {
        carCollections = new CarHashSet();
        for(int i = 0; i < 100; i++){
            carCollections.addCar(new Car("Brand"+ i, i));
        }
    }

    @Test
    public  void contains(){
        assertTrue(carCollections.contains(new Car("Brand10", 10)));
        assertFalse(carCollections.contains(new Car("Brand550", 20)));
    }
}