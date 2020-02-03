package sream.animals;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class mainTest {

    @Test
    void tester() throws FileNotFoundException {
        main.Food chicken = new main.Food(main.foodName.CHICKEN, 0.15);
        main.Food fries = new main.Food(main.foodName.FRIES, 0.2);
        List<main.Food> list1 = new ArrayList<>();
        list1.add(chicken);
        list1.add(fries);
        main.Animal human = new main.Animal(main.animalType.MAMMALS, "Wasya", 20, list1);


    }
}