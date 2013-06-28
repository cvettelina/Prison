package com.skrill.interns.Prison;

public class PersonFactory {

    public Person getPerson(String personType, String firstName, String lastName) {
        if ("overseer".equals(personType)) {
            return new Overseer(firstName, lastName);
        } else if ("doctor".equals(personType)) {
            return new Doctor(firstName, lastName);
        } else if ("prisoner".equals(personType)) {
            Prisoner prisoner = new Prisoner(firstName, lastName);
            prisoner.setType(PrisonerType.Robber);
            return prisoner;
        }
        return null;
    }

    public Person getPerson(String personType) {
        if ("overseer".equals(personType)) {
            return new Overseer();
        } else if ("doctor".equals(personType)) {
            return new Doctor();
        } else if ("prisoner".equals(personType)) {
            return new Prisoner();
        }
        return null;
    }
}
