package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo.Delo;

@NoArgsConstructor
@Data
public class Veza <T extends Delo> extends Vyzbroj {
    private double rychlostotacania;
    private double dohlad;

    public Veza(long idKomponentu, String nazov, double rychlostotacania, double dohlad) {
        super(idKomponentu, nazov);
        this.rychlostotacania = rychlostotacania;
        this.dohlad = dohlad;
    }

    @Override
    public String toString() {
        return "Veza{" +
                "rychlostotacania=" + rychlostotacania +
                ", dohlad=" + dohlad +
                "} " + super.toString();
    }
}
