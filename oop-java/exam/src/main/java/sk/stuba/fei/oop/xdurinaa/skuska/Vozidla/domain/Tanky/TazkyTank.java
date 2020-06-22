package sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Tanky;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo.DeloVelkyKaliber;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok.Pasovy;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Veza;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Narodnost;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Vozidlo;

@NoArgsConstructor
@Data

public class TazkyTank extends Vozidlo <Pasovy,Veza<DeloVelkyKaliber>>{


    public TazkyTank(long idVozidla, String nazov, Narodnost narodnost, double cena, Pasovy podvozok, Veza<DeloVelkyKaliber> vyzbroj) {
        super(idVozidla, nazov, narodnost, cena, podvozok, vyzbroj);
    }
}
