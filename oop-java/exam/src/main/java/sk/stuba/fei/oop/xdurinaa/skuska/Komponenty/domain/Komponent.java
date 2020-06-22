package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public abstract class Komponent {
    private long idKomponentu;
    private String nazov;

    public Komponent(long idKomponentu, String nazov) {
        this.idKomponentu = idKomponentu;
        this.nazov = nazov;
    }

    @Override
    public String toString() {
        return "Komponent{" +
                "idKomponentu=" + idKomponentu +
                ", nazov='" + nazov + '\'' +
                '}';
    }
}
