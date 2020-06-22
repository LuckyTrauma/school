package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Pasovy extends Podvozok {
    private double sirkapasu;

    public Pasovy(long idKomponentu, String nazov, double nosnost, double rychlostotacania, double maximalnarychlost, double sirkapasu) {
        super(idKomponentu, nazov, nosnost, rychlostotacania, maximalnarychlost);
        this.sirkapasu = sirkapasu;
    }

    @Override
    public String toString() {
        return "Pasovy{" +
                "sirkapasu=" + sirkapasu +
                "} " + super.toString();
    }
}
