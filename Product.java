package ООП;

import java.util.ArrayList;

abstract class Lesson_1 {
    private String name;
    private double cost;
    private int temperature;

    public Lesson_1(String name, double cost, int temperature) {
        this.name = name;
        this.cost = cost;
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Lesson_1{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}

class HotDrink extends Lesson_1 {
    public HotDrink(String name, double cost, int temperature) {
        super(name, cost, temperature);
    }
}

interface VendingMachine {
    Lesson_1 getLesson_1(String name, int temperature);
}

class VenMach implements VendingMachine {
    private ArrayList<Lesson_1> Lesson_1s;

    public void initLesson_1s(ArrayList<Lesson_1> Lesson_1s) {
        this.Lesson_1s = Lesson_1s;
    }

    @Override
    public Lesson_1 getLesson_1(String prodName, int temperature) {
        for (Lesson_1 p : Lesson_1s) {
            if (p.getName().equals(prodName) && p.getTemperature() == temperature) {
                return p;
            }
        }
        return null;
    }
}

public class Product {
    public static void main(String[] args) {
        ArrayList<Lesson_1> prods = new ArrayList<>();
        prods.add(new HotDrink("Чай", 50.0, 70));
        prods.add(new HotDrink("Кофе", 60.0, 80));
        prods.add(new HotDrink("Какао", 70.0, 65));

        VenMach vendingMachine = new VenMach();
        vendingMachine.initLesson_1s(prods);

        System.out.println(vendingMachine.getLesson_1("Кофе", 80));
    }
}