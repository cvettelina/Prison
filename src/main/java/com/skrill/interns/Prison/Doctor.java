package com.skrill.interns.Prison;

import java.util.Random;

public class Doctor extends Person implements Observer {

    public Doctor(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Doctor() {
        super();
    }

    public void update(String status, Prisoner person) {
        System.out.println(this.getFirstName() + " is trying to handle the situation");
        Random rand = new Random();
        if ("Dead".equals(status)) {
            person.setStatus("Gone");
        } else {
            if (rand.nextInt(100) % 2 == 0) {
                person.setStatus("Gone");
            } else {
                System.out.println(person.getFirstName() + " is now normal human being");
                person.setStatus("OK");
            }
        }
    }
}
