package com.skrill.interns.Prison;

import java.util.LinkedList;
import java.util.Queue;

public class BedPool {
    private final Queue<Bed> pool = new LinkedList<Bed>();
    private final int size;

    public BedPool(int size) {
        this.size = size;
        Bed b;
        for (int i = 0; i < size; i++) {
            b = new Bed();
            this.pool.add(b);
        }
    }

    public Bed getBed(){
        if (this.pool.isEmpty()){
            return null;
        }
        return this.pool.remove();
    }

    public void addBed(Bed b){
        if(this.pool.size() < this.size){
            this.pool.add(b);
        }
        
    }

}
