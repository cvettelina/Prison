package com.skrill.interns.Prison;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThePrison {
    private List<Person> personsInPrison = new ArrayList<Person>();

    public void addPerson(Person person) {
        personsInPrison.add(person);
    }

    public Prisoner getRandomPrisoner() {
        Random rand = new Random();
        int index = rand.nextInt(personsInPrison.size());
        while (!(personsInPrison.get(index) instanceof Prisoner)) {
            index = rand.nextInt(personsInPrison.size());

        }
        return (Prisoner) personsInPrison.get(index);
    }

    public Person getPerson(String username) {
        for (int i = 0; i < personsInPrison.size(); i++) {
            if (personsInPrison.get(i).getFirstName().equals(username)) {
                return personsInPrison.get(i);
            }
        }
        return null;
    }

    public void addObserverToAll(Observer observer) {
        for (int i = 0; i < personsInPrison.size(); i++) {
            if (personsInPrison.get(i) instanceof Prisoner) {
                ((Prisoner) personsInPrison.get(i)).addObserver(observer);
            }
        }
    }

    public Prisoner getAlivePrisoner() {
        Prisoner prisoner = getRandomPrisoner();
        while ("Hospital".equals(prisoner.getStatus()) || "Gone".equals(prisoner.getStatus())) {
            prisoner = getRandomPrisoner();
        }
        return prisoner;
    }

}
