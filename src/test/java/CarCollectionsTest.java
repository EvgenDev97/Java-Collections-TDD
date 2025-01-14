import ArrayList.Car.Car;
import ArrayList.Car.CarArrayList;
import CarCollection.CarCollections;
import HashSet.CarHashSet;
import LinkedList.CarLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public  void testForEach(){
        int index = 0;
//        while(carCollections.iterator().hasNext()){
//            Car car = carCollections.iterator().next();
//        }
        for(Car car : carCollections){
            index++;
        }
        assertEquals(100, index);
    }
}