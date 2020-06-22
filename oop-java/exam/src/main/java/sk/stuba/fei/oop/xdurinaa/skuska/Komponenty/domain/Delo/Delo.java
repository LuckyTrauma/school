package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Vyzbroj;

@NoArgsConstructor
@Data
public abstract class Delo extends Vyzbroj {
    private double kaliber;
    private int kadencia;
    private double rozptyl100m;

    public Delo(long idKomponentu, String nazov, double kaliber, int kadencia, double rozptyl100m) {
        super(idKomponentu, nazov);
        this.kaliber = kaliber;
        this.kadencia = kadencia;
        this.rozptyl100m = rozptyl100m;
    }

    @Override
    public String toString() {
        return "Delo{" +
                "kaliber=" + kaliber +
                ", kadencia=" + kadencia +
                ", rozptyl100m=" + rozptyl100m +
                "} " + super.toString();
    }
}
