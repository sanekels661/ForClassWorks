package sream.animals;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


class Animal implements Serializable {

    public enum animalType {
        MAMMALS,
        BIRDS,
        REPTILES,
        FISHES,
        INSECTS;
    }

    static List<Food> foodList;
    static String type;
    static String name;
    static double age;

    Animal(animalType type1, String name1, double age1, List<Food> food1) {
        foodList = food1;
        name = name1;
        age = age1;
        type = type1.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.age, age) == 0 &&
                Objects.equals(foodList, animal.foodList) &&
                Objects.equals(type, animal.type) &&
                Objects.equals(name, animal.name);
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodList, type, name, age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "foodList=" + foodList +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

