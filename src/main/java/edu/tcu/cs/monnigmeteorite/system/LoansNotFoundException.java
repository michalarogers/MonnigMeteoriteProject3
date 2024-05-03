package edu.tcu.cs.monnigmeteorite.system;

public class LoansNotFoundException extends RuntimeException {

    public LoansNotFoundException(Integer id) {
        super("Could not find loan with id " + id + " :(");
    }

}