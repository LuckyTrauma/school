package sk.stuba.fei.oop.xdurinaa.zadanie.Data;

import sk.stuba.fei.oop.xdurinaa.zadanie.Models.ModelSIR;

public class Engine {

    private ModelSIR model;
    private double Ro;

    public Engine(ModelSIR model) {
        this.model = model;
    }

    public void isEnd(){
        if(model.calculateMethod() == 0)
        {
            System.out.println("Game development in progress.");
            System.exit(0);
        }
    }





}
