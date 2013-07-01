package com.skrill.interns.Prison;

import java.util.ArrayList;
import java.util.List;

enum PrisonerType {
    Killer, Robber, Rapist
}

public class Prisoner extends Person {

    private List<Observer> observers = new ArrayList<Observer>();
    private static int codeNumber;
    private int years;
    private String status;
    private PrisonerType type;

    public Prisoner() {
        this.status = "Ok";
    }

    public Prisoner(String firstName, String lastName) {
        super(firstName, lastName);
        this.status = "Ok";
        codeNumber++;
    }

    public Prisoner(String firstName, String lastName, int years) {
        super(firstName, lastName);
        codeNumber++;
        this.years = years;
        this.status = "Normal";
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getStatus() {
        return status;
    }

    public PrisonerType getType() {
        return type;
    }

    public void setType(PrisonerType type) {
        this.type = type;
    }

    public void attack(Person person) {
        System.out.println(this.getFirstName() + " just attacked " + person.getFirstName());
        if (person instanceof Prisoner) {
            if (this.getFirstName().equals(person.getFirstName())) {
                this.setStatus("Suicide");
            } else {
                if (PrisonerType.Killer.equals(this.type)) {
                    ((Prisoner) person).setStatus("Dead");
                    System.out.println("TheKiller kills them all");
                } else {
                    ((Prisoner) person).setStatus("Injured");
                }
                this.setStatus("Guilty");
            }
        } else if (person instanceof Overseer) {
            this.setStatus("Dead");
        } else {
            this.setStatus("in detention room");
        }
    }

    public void escape() {
        System.out.println(this.getFirstName() + " escaped the prision");
        this.setStatus("Escaped");
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Observer> observers) {
        this.observers = observers;
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifyObservers() {

        for (Observer ob : observers) {
            ob.update(this.status, this);
        }
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        System.out.println(this.getFirstName() + " is " + this.status);
        if ("Hospital".equals(this.status) || "Dead".equals(this.status)) {
            notifyDoctors();
        } else {
            notifyOverseers();
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyOverseers() {
        for (Observer os : observers) {
            if (os instanceof Overseer) {
                os.update(this.status, this);
            }
        }
    }

    public void notifyDoctors() {
        for (Observer os : observers) {
            if (os instanceof Doctor) {
                os.update(this.status, this);
            }
        }
    }
}
