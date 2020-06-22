package sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo.DeloVelkyKaliber;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok.Pasovy;

@NoArgsConstructor
@Data

public class Delostrelectvo extends Vozidlo <Pasovy,DeloVelkyKaliber> {

    public Delostrelectvo(long idVozidla, String nazov, Narodnost narodnost, double cena, Pasovy podvozok, DeloVelkyKaliber vyzbroj) {
        super(idVozidla, nazov, narodnost, cena, podvozok, vyzbroj);
    }
}
