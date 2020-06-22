package sk.stuba.fei.oop.xdurinaa.zadanie;

import sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Types.Covid;
import sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Plague;
import sk.stuba.fei.oop.xdurinaa.zadanie.UserInput.KeyboardIn;
import sk.stuba.fei.oop.xdurinaa.zadanie.Data.Game;
import sk.stuba.fei.oop.xdurinaa.zadanie.Models.ExtendedSIR;
import sk.stuba.fei.oop.xdurinaa.zadanie.Models.ModelSIR;
import sk.stuba.fei.oop.xdurinaa.zadanie.Models.SimpleSIR;
import sk.stuba.fei.oop.xdurinaa.zadanie.Population.People;
import sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Types.Measles;


public class Main {
    public static void main(String[] args) {

        System.out.println("Chooose virus");
        System.out.println("0 Stands for COVID19");
        System.out.println("1 Stands for Measles");

        int type = KeyboardIn.readInt(" ");

        Plague plague = null;
        ModelSIR model = null;

        if(type == 0) plague = new Covid();
        if(type == 1) plague = new Measles();

        System.out.println("Chooose model for spreading");
        System.out.println("0 Stands for ExtendedSIR");
        System.out.println("1 Stands for SimpleSIR");

        int modeltype = KeyboardIn.readInt(" ");

          if (modeltype == 0) {
            double suspectible = KeyboardIn.readDouble("Set Suspectible :");
            double infectious = KeyboardIn.readDouble("Set Infectious : ");
            double removed = KeyboardIn.readDouble("Set Removed <0,1> :");
            People people = new People(suspectible,infectious,removed);
            int days = KeyboardIn.readInt("Set number of days :");
            //double population = suspectible + infectious + removed;
            model = new ExtendedSIR(people,plague);
        }
        if (modeltype == 1){
            double suspectible = KeyboardIn.readDouble("Set Suspectible :");
            double infectious = KeyboardIn.readDouble("Set Infectious : ");
            int days = KeyboardIn.readInt("Set number of days :");
            People people = new People(suspectible,infectious);
            //double population = suspectible + infectious;
            model = new SimpleSIR(people,plague);
        }

        Game game = new Game(model);
        game.launchGame(10); // Vypis S: , I: , R: , beta, gamma
    }
}
