package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Komponent;

@NoArgsConstructor
@Data
public abstract class Podvozok extends Komponent {
    private double nosnost;
    private double rychlostotacania;
    private double maximalnarychlost;

    public Podvozok(long idKomponentu, String nazov, double nosnost, double rychlostotacania, double maximalnarychlost) {
        super(idKomponentu, nazov);
        this.nosnost = nosnost;
        this.rychlostotacania = rychlostotacania;
        this.maximalnarychlost = maximalnarychlost;
    }

    @Override
    public String toString() {
        return "Podvozok{" +
                "nosnost=" + nosnost +
                ", rychlostotacania=" + rychlostotacania +
                ", maximalnarychlost=" + maximalnarychlost +
                "} " + super.toString();
    }
}
