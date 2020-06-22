package sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Tanky;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo.DeloMalyKaliber;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok.Kolesovy;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Veza;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Narodnost;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Vozidlo;

@NoArgsConstructor
@Data

public class LahkyTank extends Vozidlo <Kolesovy,Veza<DeloMalyKaliber>> {

    public LahkyTank(long idVozidla, String nazov, Narodnost narodnost, double cena, Kolesovy podvozok, Veza<DeloMalyKaliber> vyzbroj) {
        super(idVozidla, nazov, narodnost, cena, podvozok, vyzbroj);
    }
}
