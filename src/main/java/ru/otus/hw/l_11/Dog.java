package ru.otus.hw.l_11;

public class Dog extends Animal implements Swimmable {
    private static final int ENDURANCE_CONSUMPTION_SWIM = 2;
    private int swimSpeed;

    public Dog(String name, int endurance, int runSpeed, int swimSpeed, AnimalState state) {
        super(name, endurance, runSpeed, state);
        this.swimSpeed = swimSpeed;
    }

    @Override
    public int swim(int distance) {
        return move(distance, "swim", swimSpeed, ENDURANCE_CONSUMPTION_SWIM);
    }
}
