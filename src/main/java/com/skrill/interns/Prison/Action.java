package com.skrill.interns.Prison;


public class Action {
    private static ThePrison prison;

    private static void fillThePrison() {
        prison = new ThePrison();
        PersonFactory factory = new PersonFactory();
        prison.addPerson(factory.getPerson("robber", "Ivan", "Ivanov"));
        prison.addPerson(factory.getPerson("robber", "Pesho", "Petrov"));
        prison.addPerson(factory.getPerson("rapist", "Gosho", "Georgiev"));
        prison.addPerson(factory.getPerson("rapist", "Dragan", "Draganov"));
        prison.addPerson(factory.getPerson("robber", "Petko", "Petkov"));
        prison.addPerson(factory.getPerson("robber", "Jack", "Ivanov"));
        prison.addPerson(factory.getPerson("overseer", "Ricky", "Ivanov"));
        prison.addPerson(factory.getPerson("overseer", "Daniel", "Ivanov"));
        prison.addPerson(factory.getPerson("overseer", "Don", "Ivanov"));
        prison.addPerson(factory.getPerson("doctor", "Mustafa", "Ivanov"));
        prison.addPerson(factory.getPerson("overseer", "Bu", "Ivanov"));
        ((Prisoner) prison.getPerson("Ivan")).addObserver((Overseer) prison.getPerson("Don"));
        ((Prisoner) prison.getPerson("Pesho")).addObserver((Overseer) prison.getPerson("Don"));
        ((Prisoner) prison.getPerson("Gosho")).addObserver((Overseer) prison.getPerson("Daniel"));
        ((Prisoner) prison.getPerson("Dragan")).addObserver((Overseer) prison.getPerson("Don"));
        ((Prisoner) prison.getPerson("Petko")).addObserver((Overseer) prison.getPerson("Ricky"));
        ((Prisoner) prison.getPerson("Jack")).addObserver((Overseer) prison.getPerson("Don"));
        Prisoner killer = new Prisoner("TheKiller", "lastName");
        killer.setType(PrisonerType.Killer);
        killer.addObserver((Overseer) prison.getPerson("Ricky"));
        prison.addPerson(killer);
        prison.addObserverToAll((Doctor) prison.getPerson("Mustafa"));

    }
    public static void main(String[] args) {
        fillThePrison();
        prison.getAlivePrisoner().attack(prison.getAlivePrisoner());
        System.out.println("* * *");
        prison.getAlivePrisoner().attack(prison.getAlivePrisoner());
        System.out.println("* * *");
        prison.getAlivePrisoner().attack(prison.getAlivePrisoner());
        System.out.println("* * *");
        prison.getAlivePrisoner().escape();
    }

}
