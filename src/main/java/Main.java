import ArrayList.Car.Car;

public class Main {
    public static void main(String[] args) {
        Car carOne = new Car("BMW", 1);
        Car carTwo = new Car("BMW", 1);
//        Car carThree = carOne;
//        System.out.println(carOne == carTwo);
//        System.out.println(carOne == carThree);
        System.out.println(carOne.equals(carTwo));
        System.out.println(carOne.hashCode());
        System.out.println(carTwo.hashCode());
    }
}