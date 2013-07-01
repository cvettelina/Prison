package com.skrill.interns.Prison;

import java.util.Random;

public class Bed {
    private static int number;
    private int day;

    public Bed() {
        number++;
        day = 1;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Bed.number = number;
    }

    public void duringStay(Prisoner person) {
        Random rand = new Random();
        if (day == 2) {
            if (rand.nextInt(100) % 2 == 0) {
                person.setStatus("Gone");
            } else {
                System.out.println(person.getFirstName() + " is now normal human being");
                person.setStatus("OK");
            }
        }
        else {
            System.out.println(person.getFirstName() + "'s future is not decided yet");
            day++;
        }
    }
}
