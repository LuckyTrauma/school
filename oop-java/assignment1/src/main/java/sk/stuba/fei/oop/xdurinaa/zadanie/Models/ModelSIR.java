package sk.stuba.fei.oop.xdurinaa.zadanie.Models;

import sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Plague;
import sk.stuba.fei.oop.xdurinaa.zadanie.Population.People;
import sk.stuba.fei.oop.xdurinaa.zadanie.Modificators.BetaModifier;
import sk.stuba.fei.oop.xdurinaa.zadanie.Modificators.GammaModifier;

import java.util.ArrayList;
import java.util.List;

public abstract class ModelSIR {


    private People people;
    private Plague plague;
    private List<BetaModifier> betaModifiers = new ArrayList<BetaModifier>();
    private List<GammaModifier> gammaModifiers = new ArrayList<GammaModifier>();

    public ModelSIR(People people,Plague plague) {
        this.people = people;
        this.plague = plague;
    }

    public double getBeta() {
        double beta = plague.getBeta();
        for (BetaModifier b : betaModifiers) {
            beta *= b.getBetaModifier();
        }
        return beta;
    }
    public double getGamma() {
        double gamma = plague.getGamma();
        for (GammaModifier g : gammaModifiers) {
            gamma *= g.getGammaModifier();
        }
        return gamma;
    }

    public double calculateMethod()
    {
        System.out.println(people.getSuspectible()+ " " +people.getInfectious() + " " + people.getRemoved()+ " " +plague.getGamma()+ " " +plague.getBeta());
        return 0;// pevno dany koniec hry ...
        /*
        return getBeta()/getGamma();
        * */
    }


}
