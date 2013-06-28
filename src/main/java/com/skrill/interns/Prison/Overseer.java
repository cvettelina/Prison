package com.skrill.interns.Prison;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class Overseer extends Person implements Observer {

    public Overseer() {
    }
    public Overseer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public void update(String prisonerStatus, Prisoner person) {
        if ("Injured".equals(prisonerStatus)) {
            System.out.println(this.getFirstName() + " sent " + person.getFirstName() + "  to hospital");
            person.setStatus("Hospital");
        } else if ("Guilty".equals(prisonerStatus)) {
            System.out.println(this.getFirstName() + " sent " + person.getFirstName() + " to detention room");
            person.setStatus("in detention room");
        } else if ("Suicide".equals(prisonerStatus)) {
            System.out.println(person.getFirstName() + " killed himself");
            person.setStatus("in detention room");
        } else if ("Escaped".equals(prisonerStatus)) {
            System.out.println(this.getFirstName() + " is trying to find " + person.getFirstName());
            Random rand = new Random();
            if (rand.nextInt(100) % 2 == 0) {
                System.out.println("Couldn't find him");
                person.setStatus("is free");
            } else {
                System.out.println("Found");
                person.setStatus("in detention room");
            }
        }
    }

}
