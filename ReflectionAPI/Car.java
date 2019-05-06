package reflectionAPI;

public class Car {

    @Writable
    String model;

    private int maxSpeed;

    public Car(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
}
