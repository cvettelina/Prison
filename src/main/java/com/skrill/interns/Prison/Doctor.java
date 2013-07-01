package com.skrill.interns.Prison;


public class Doctor extends Person implements Observer {
    Hospital hospital;

    public Doctor(String firstName, String lastName) {
        super(firstName, lastName);
        hospital = new Hospital();
    }

    public Doctor() {
        super();
        hospital = new Hospital();
    }

    public void update(String status, Prisoner person) {
        System.out.println(this.getFirstName() + " is trying to handle the situation");
        if ("Dead".equals(status)) {
            person.setStatus("Gone");
        } else {
            hospital.addPrisoner(person);
        }
    }
}
