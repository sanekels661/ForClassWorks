package sream.animals;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class main {

    enum foodName {
        CHICKEN,
        FRIES,
        CRANBERRY,
        GRASS,
        MEAT;
    }


     static final class Food implements Serializable {

        private String foodName;
        private double weight;

        Food(foodName foodName1, double weight1) {
            foodName = foodName1.toString();
            weight = weight1;
        }

         @Override
         public boolean equals(Object o) {
             if (this == o) return true;
             if (o == null || getClass() != o.getClass()) return false;
             Food food = (Food) o;
             return Double.compare(food.weight, weight) == 0 &&
                     Objects.equals(foodName, food.foodName);
         }

         @Override
         public int hashCode() {
             return Objects.hash(foodName, weight);
         }

         @Override
         public String toString() {
             return "Food{" +
                     "foodName='" + foodName + '\'' +
                     ", weight=" + weight +
                     '}';
         }
     }

    enum animalType {
        MAMMALS,
        BIRDS,
        REPTILES,
        FISHES,
        INSECTS;
    }

    static class Animal implements Serializable {

        List<Food> foodList;
        String type;
        String name;
        double age;

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


}
