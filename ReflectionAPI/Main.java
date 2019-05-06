package reflectionAPI;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<>();
        Car car1 = new Car("BMW", 100);
        Human human1 = new Human("Dima", 18, 188);
        list.add(car1);
        list.add(human1);

        writeInFile(list);
    }

    private static void writeInFile(ArrayList<Object> list) {
        try {
            PrintWriter writer = new PrintWriter(new File("output.txt"));
            list.stream().map(Main::getWritableFields).forEach(writer::println);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Что-то пошло не так!");
        }
    }

    private static String getWritableFields(Object object) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = object.getClass().getDeclaredFields();
        sb.append("Class: ")
                .append(object.getClass().getName())
                .append("\t-\tFields: ");
        Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(Writable.class))
                .forEach(field -> {
                    field.setAccessible(true);
                    try {
                        sb.append(field.getName()).append(" = ").append(field.get(object)).append(", ");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
        return sb.toString();
    }
}
