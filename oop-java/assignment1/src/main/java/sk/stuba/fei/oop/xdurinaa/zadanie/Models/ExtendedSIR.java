package sk.stuba.fei.oop.xdurinaa.zadanie.Models;

import sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Plague;
import sk.stuba.fei.oop.xdurinaa.zadanie.Population.People;

public class ExtendedSIR extends ModelSIR {
    private double removed;

    public ExtendedSIR(People people, Plague plague) {
        super(people, plague);
        this.setExRemoved(people);
    }

    public void setExRemoved(People people) {
        if ( removed > 1 || removed < 0 ) throw  new IllegalArgumentException("Number must be inbetween 0 and 1");
        this.removed = (people.getSuspectible()/100)*removed;
        people.setSuspectible(people.getSuspectible()- this.removed);
    }

    /*@Override
    public void calculateMethod()
    {

    }*/

}
