package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class Kolesovy extends Podvozok {
    private int pocetkolies;

    public Kolesovy(long idKomponentu, String nazov, double nosnost, double rychlostotacania, double maximalnarychlost, int pocetkolies) {
        super(idKomponentu, nazov, nosnost, rychlostotacania, maximalnarychlost);
        this.pocetkolies = pocetkolies;
    }

    @Override
    public String toString() {
        return "Kolesovy{" +
                "pocetkolies=" + pocetkolies +
                "} " + super.toString();
    }
}
