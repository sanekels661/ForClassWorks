package sream.animals;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
    public static void serializer(List<Animal> animalList, String fileName) throws IOException {

        Path path = Paths.get(fileName);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            outputStream.writeObject(animalList);
        }
    }

    public static List<Animal> deserializer(String filename) throws IOException, ClassNotFoundException {
        Path path = Paths.get(filename);
        List<Animal> animalList = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(path))) {
            animalList = (List<Animal>) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return animalList;
    }

    public static void hardSerializer(List<Animal> animalList, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (DataOutputStream outputStream = new DataOutputStream(Files.newOutputStream(path))) {
            outputStream.writeInt(animalList.size());
            for (Animal animal : animalList) {
                outputStream.writeUTF(animal.getName());
                outputStream.writeUTF(animal.getType());
                outputStream.writeDouble(animal.getAge());
                outputStream.writeInt(animal.getFoodList().size());
                for (Food food : animal.getFoodList()) {
                    outputStream.writeUTF(food.getFoodName());
                    outputStream.writeDouble(food.getWeight());
                }
            }
        }
    }

    public static List<Animal> hardDeserializer(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<Animal> animalList = new ArrayList<>();

        String name;
        Animal.animalType type;
        Double age;

        try (DataInputStream inputStream = new DataInputStream(Files.newInputStream(path))) {
            int countAnimal = inputStream.readInt();
            for (int i = 0; i < countAnimal; i++) {
                name = inputStream.readUTF();
                type = Animal.animalType.valueOf(inputStream.readUTF());
                age = inputStream.readDouble();
                List<Food> foodList = new ArrayList<>();
                int countFood = inputStream.readInt();
                for (int j = 0; j < countFood; j++) {
                    Food.foodName foodName = Food.foodName.valueOf(inputStream.readUTF());
                    Double foodWeight = inputStream.readDouble();
                    foodList.add(new Food(foodName, foodWeight));
                }
                animalList.add(new Animal(type, name, age, foodList));
            }
        }
        return animalList;
    }

}
