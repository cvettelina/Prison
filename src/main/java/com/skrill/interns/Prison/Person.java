package com.skrill.interns.Prison;


public abstract class Person {
    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Person) {
            if (this.firstName.equals(((Person) o).getFirstName())) {
                return true;
            }
        }
        return false;
    }
}
