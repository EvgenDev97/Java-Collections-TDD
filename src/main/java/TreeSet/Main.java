package TreeSet;

import ArrayList.Car.Car;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> IntSet = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return -o1.compareTo(o2);
//                if(o1 > o2){
//                    return -1;
//                }else if(o1 < o2){
//                    return 1;
//                }else {
//                    return 0;
//                }
            }

        });
        for (int i = 0; i < 100; i++) {
            IntSet.add((int)(Math.random()*10));
        }
        for(Integer i : IntSet){
            System.out.println(i);
        }

        Set <Car> cars = new TreeSet<Car>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getBrand().compareTo(o2.getBrand());
            }

        });
        for(int i = 0; i < 100; i++){
            cars.add(new Car("Brand" + i, i));
        }

//        for(Car car : cars){
//            System.out.println(car);
//        }
    }
}
