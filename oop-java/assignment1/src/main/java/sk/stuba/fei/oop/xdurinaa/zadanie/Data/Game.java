package sk.stuba.fei.oop.xdurinaa.zadanie.Data;

import sk.stuba.fei.oop.xdurinaa.zadanie.Models.ModelSIR;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Game {

    private ModelSIR model;
    private Engine engine;


    public Game(ModelSIR model) {
        this.model = model;
    }

    public void launchGame(int days)
    {   engine = new Engine(model);
         for( int i = 0 ; i < days ; i++)
        engine.isEnd();
    }
    public void saveGame()
    {
        throw new NotImplementedException();
    }
    public void loadGame()
    {
        throw new NotImplementedException();
    }

}
