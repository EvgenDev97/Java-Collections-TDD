import ArrayList.Car.Car;
import HashMap.CarHashMap;
import HashMap.CarOwner;
import HashMap.CarOwnerList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarOwnerListTest {
    private CarOwnerList carOwnerListMap;
    @BeforeEach

    void setUp() {
        carOwnerListMap = new CarHashMap();

    }
    @Test
    void ifAdd100ElemetnsTheSizeMustBe100(){
        for(int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner(
                    i,
                    "Brand" + i,
                    "lastName" + i
            );
            Car car = new Car("Brand" + i, i);
            carOwnerListMap.put(carOwner, car);
        }
        assertEquals(100, carOwnerListMap.size());
    }


    @Test
    void removeReturnTrueElseFalse(){
        for(int i = 0; i < 10; i++){
            CarOwner carOwner = new CarOwner(
                    i,
                    "Name" + i,
                    "lastName" + i
            );
            Car car = new Car("Brand" + i, i);
            carOwnerListMap.put(carOwner, car);
        }
        assertEquals(10, carOwnerListMap.size());
        CarOwner carOwnerForDeleting = new CarOwner(5, "Name5", "lastName5");
        assertTrue(carOwnerListMap.remove(carOwnerForDeleting));
        assertEquals(9, carOwnerListMap.size());
        assertFalse(carOwnerListMap.remove(carOwnerForDeleting));
    }

    @Test
    void get(){
        for(int i = 0; i < 100; i++){
            CarOwner carOwner = new CarOwner(
                    i,
                    "Brand" + i,
                    "lastName" + i
            );
            Car car = new Car("Brand" + i, i);
            carOwnerListMap.put(carOwner, car);
    }
        CarOwner key = new CarOwner(5, "Brand5", "lastName5");
        Car value = carOwnerListMap.get(key);
        String expected = "Brand5";
        assertEquals(expected, value.getBrand());
    }


    @Test
    void clear(){
        carOwnerListMap.clear();
        assertEquals(0, carOwnerListMap.size());
    }
}