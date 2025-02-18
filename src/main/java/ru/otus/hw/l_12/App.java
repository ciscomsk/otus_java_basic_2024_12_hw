package ru.otus.hw.l_12;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Plate plate = new Plate(30);

        Cat[] cats = {
                new Cat("cat1", 10),
                new Cat("cat2", 12),
                new Cat("cat3", 14)
        };

//        for (int i = 0; i < cats.length; i++) {
//            cats[i].eat(plate);
//        }
        // =
//        for (Cat cat : cats) {
//            cat.eat(plate);
//        }
        // =
        Arrays.stream(cats).forEach(cat -> {
            cat.eat(plate);
            cat.showFullness();
            System.out.println(plate.getCurrentAmount());
        });

//        for (int i = 0; i < cats.length; i++) {
//            cats[i].showFullness();
//        }
        // =
//        for (Cat cat : cats) {
//            cat.showFullness();
//        }
        // =
        System.out.println();

        System.out.println(plate.getCurrentAmount());
        plate.fill(10);
        System.out.println(plate.getCurrentAmount());
        plate.fill(50);
        System.out.println(plate.getCurrentAmount());
    }
}
