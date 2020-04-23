package sream.animals;

import java.io.Serializable;
import java.util.Objects;

public final class Food implements Serializable {
    public enum foodName {
        CHICKEN,
        FRIES,
        CRANBERRY,
        GRASS,
        MEAT;
    }


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

    public String getFoodName() {
        return foodName;
    }

    public double getWeight() {
        return weight;
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
