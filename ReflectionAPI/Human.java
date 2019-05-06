package reflectionAPI;

public class Human {

    @Writable
    private String name;

    private int age;

    @Writable
    int height;

    public Human(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
}
