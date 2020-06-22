package sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Types;

import sk.stuba.fei.oop.xdurinaa.zadanie.Plagues.Plague;

public class Covid  implements Plague {
    public double getBeta() {
        return 0.8;
    }

    public double getGamma() {
        return 0.9;
    }
}
