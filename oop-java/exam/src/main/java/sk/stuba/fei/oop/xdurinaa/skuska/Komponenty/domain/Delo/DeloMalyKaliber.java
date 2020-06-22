package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class DeloMalyKaliber extends Delo {
    private int pocetnabojov;

    public DeloMalyKaliber(long idKomponentu, String nazov, double kaliber, int kadencia, double rozptyl100m, int pocetnabojov) {
        super(idKomponentu, nazov, kaliber, kadencia, rozptyl100m);
        this.pocetnabojov = pocetnabojov;
    }

    @Override
    public String toString() {
        return "DeloMalyKaliber{" +
                "pocetnabojov=" + pocetnabojov +
                "} " + super.toString();
    }
}
