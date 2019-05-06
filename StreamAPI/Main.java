package streamAPI;

import javax.rmi.CORBA.Util;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    private static final String PATH_TO_FILE = "/Users/test/Downloads/Data USA Cart.csv";

    public static void main(String[] args) {

        ArrayList<Country> countries = Utils.createCountriesList(Objects.requireNonNull(Utils.readFile(PATH_TO_FILE)));
        ArrayList<Country> topCountries = Utils.peekTopCountries(countries);
        topCountries.forEach(System.out::println);


        System.out.println("\nPrediction to next year:\n");
        for (Country country : topCountries) {
            System.out.println(country.getName() + "\n" +
                    "population in next year: " + Utils.predict(country) + "\n");
        }

        Utils.deleteFile();
        System.out.println(Utils.count);
    }
}
