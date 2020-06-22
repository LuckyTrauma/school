package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class DeloVelkyKaliber extends Delo {
    private int polomervybuchu;

    public DeloVelkyKaliber(long idKomponentu, String nazov, double kaliber, int kadencia, double rozptyl100m, int polomervybuchu) {
        super(idKomponentu, nazov, kaliber, kadencia, rozptyl100m);
        this.polomervybuchu = polomervybuchu;
    }

    @Override
    public String toString() {
        return "DeloVelkyKaliber{" +
                "polomervybuchu=" + polomervybuchu +
                "} " + super.toString();
    }
}
