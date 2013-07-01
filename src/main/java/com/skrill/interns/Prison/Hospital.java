package com.skrill.interns.Prison;

import java.util.HashMap;
import java.util.Map;

public class Hospital {
    private Map<Bed, Prisoner> inHospital = new HashMap<Bed, Prisoner>();
    BedPool pool;

    public Hospital() {
        pool = new BedPool(1);
    }

    public void addPrisoner(Prisoner person) {
        for (Bed b : inHospital.keySet()) {
            b.duringStay(inHospital.get(b));
            removePrisoner();
        }
        Bed bed = pool.getBed();
        if (bed != null) {
            inHospital.put(bed, person);
            System.out.println(person.getFirstName() + " is using the bed");
        } else {
            System.out.println("No free beds, the prisoner is dead");
            person.setStatus("Gone");
        }
    }

    public void removePrisoner() {
        System.out.println("free bed");
        for (Bed bed : inHospital.keySet()) {
            if (inHospital.get(bed).getStatus().equals("Gone") || inHospital.get(bed).getStatus().equals("OK")) {
                inHospital.remove(bed);
                pool.addBed(bed);
            }
        }
    }
}
