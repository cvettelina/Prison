package com.skrill.interns.Prison;

public class PersonFactory {

    public Person getPerson(String personType, String firstName, String lastName) {
        if ("overseer".equals(personType)) {
            return new Overseer(firstName, lastName);
        } else if ("doctor".equals(personType)) {
            return new Doctor(firstName, lastName);
        } else {
            Prisoner prisoner = new Prisoner(firstName, lastName);
            if ("killer".equals(personType)) {
                prisoner.setType(PrisonerType.Killer);
            return prisoner;
            } else if ("robber".equals(personType)) {
                prisoner.setType(PrisonerType.Robber);
                return prisoner;
            } else if ("rapist".equals(personType)) {
                prisoner.setType(PrisonerType.Rapist);
                return prisoner;
            }
            return null;
        }
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
