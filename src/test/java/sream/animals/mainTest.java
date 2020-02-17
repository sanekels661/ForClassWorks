package sream.animals;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class mainTest {

    @Test
    public void tester1() throws IOException, ClassNotFoundException {
        main.Food chicken = new main.Food(main.foodName.CHICKEN, 0.15);
        main.Food fries = new main.Food(main.foodName.FRIES, 0.2);
        List<main.Food> list1 = new ArrayList<>();
        list1.add(chicken);
        list1.add(fries);
        main.Animal human = new main.Animal(main.animalType.MAMMALS, "Wasya", 20, list1);


        File file = new File("C:/JavaProgs./human.ser");
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(human);
        outStream.close();
        fileOut.close();

        main.Animal desirializedHuman = null;
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        desirializedHuman = (main.Animal) objectIn.readObject();
        fileIn.close();
        objectIn.close();
        file.delete();

        assertEquals(human, desirializedHuman);

    }
    @Test
    public void tester2() throws IOException, ClassNotFoundException {
        main.Food chicken = new main.Food(main.foodName.CHICKEN, 0.15);
        main.Food fries = new main.Food(main.foodName.FRIES, 0.2);
        List<main.Food> list1 = new ArrayList<>();
        list1.add(chicken);
        list1.add(fries);
        main.Animal human = new main.Animal(main.animalType.MAMMALS, "Wasya", 20, list1);


        File file = new File("C:/JavaProgs./human.ser");
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
        outStream.writeObject(human);
        outStream.close();
        fileOut.close();

        main.Animal desirializedHuman = null;
        FileInputStream fileIn = new FileInputStream(file);
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        desirializedHuman = (main.Animal) objectIn.readObject();
        fileIn.close();
        objectIn.close();
        file.delete();

        assertEquals(human, desirializedHuman);

    }




}