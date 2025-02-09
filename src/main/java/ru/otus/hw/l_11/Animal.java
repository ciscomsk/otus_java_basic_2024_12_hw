package ru.otus.hw.l_11;

// можно сделать класс abstract
public class Animal {
    private static final int ENDURANCE_CONSUMPTION_RUN = 1;

    protected String name;
    protected int endurance;
    protected int runSpeed;
    protected AnimalState state;

    public Animal(String name, int endurance, int runSpeed, AnimalState state) {
        this.name = name;
        this.endurance = endurance;
        this.runSpeed = runSpeed;
        this.state = state;
    }

    // moveType можно сделать enum
    protected int move(int distance, String moveType, int moveSpeed, int enduranceConsumption) {
        int time = -1;
        if (endurance == 0) {
            printTiredState(name);
            return time;
        }

        int enduranceLoss = distance * enduranceConsumption;

        if (enduranceLoss > endurance) {
            float distanceBeforeTired = (float) endurance / enduranceConsumption;
            float timeBeforeTired = distanceBeforeTired / moveSpeed;
            endurance = 0;
            System.out.println(name + " " + moveType + " " + distanceBeforeTired + "m out of " + distance + "m in " + timeBeforeTired + "s");
            state = AnimalState.TIRED;
            printTiredState(name);
            return time;
        }

        endurance -= enduranceLoss;
        time = distance / moveSpeed;
        System.out.println(name + " " + moveType + " " + distance + "m in " + time + "s");
        if (endurance == 0) {
            state = AnimalState.TIRED;
            printTiredState(name);
        }

        return time;
    }

    public int run(int distance) {
        return move(distance, "run", runSpeed, ENDURANCE_CONSUMPTION_RUN);
    }

    protected void printTiredState(String name) {
        System.out.println(name + " is " + AnimalState.TIRED);
    }

    public void info() {
        System.out.println(name + ": endurance = " + endurance + ", state = " + state);
    }
}
