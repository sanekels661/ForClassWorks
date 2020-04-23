package sream.animals;

import org.junit.Test;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.*;

import static org.junit.Assert.*;

public class AnimalTest {
    List<Animal> animalList = Arrays.asList(
            new Animal(Animal.animalType.REPTILES, "MortalCombatReptile", 30,
                    Arrays.asList(new Food(Food.foodName.FRIES, 0.5))),
            new Animal(Animal.animalType.MAMMALS, "Johny", 31,
                    Arrays.asList(new Food(Food.foodName.MEAT, 0.3)))
    );

    @Test
    public void serializer() throws IOException, ClassNotFoundException {
        Serializer.serializer(animalList, "AnimalFile");
        assertEquals(animalList, Serializer.deserializer("AnimalFile"));
    }

    @Test
    public void serializerEmpty() throws IOException, ClassNotFoundException {
        Serializer.serializer(Collections.emptyList(), "EmptyFile");
        assertEquals(Collections.emptyList(), Serializer.deserializer("EmptyFile"));
    }

    @Test
    public void serializerNotEquals() throws IOException, ClassNotFoundException {
        List<Animal> testAnimalList = Arrays.asList(
                new Animal(Animal.animalType.FISHES, "Nemo", 1,
                        Arrays.asList(new Food(Food.foodName.GRASS, 0.1))),
                new Animal(Animal.animalType.INSECTS, "Kuzya", 31,
                        Arrays.asList(new Food(Food.foodName.CRANBERRY, 0.1)))
        );
        Serializer.serializer(animalList, "AnimalFile");
        Serializer.serializer(testAnimalList, "TestAnimalFile");

        assertEquals(animalList, Serializer.deserializer("AnimalFile"));
        assertNotEquals(animalList, Serializer.deserializer("TestAnimalFile"));

        assertEquals(testAnimalList, Serializer.deserializer("TestAnimalFile"));
        assertNotEquals(testAnimalList, Serializer.deserializer("AnimalFile"));
    }

    @Test
    public void serialezerException() throws ClassNotFoundException {

        try {
            Serializer.deserializer("FileNotExists");
            fail();
        } catch (NoSuchFileException e) {

        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }


}