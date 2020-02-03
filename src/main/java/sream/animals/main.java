package sream.animals;

import java.io.Serializable;
import java.util.List;

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

    }

}
