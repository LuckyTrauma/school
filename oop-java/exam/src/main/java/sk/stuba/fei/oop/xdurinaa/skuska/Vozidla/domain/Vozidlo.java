package sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok.Podvozok;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Vyzbroj;

@NoArgsConstructor
@Data

public abstract class Vozidlo <T1 extends Podvozok, T2 extends Vyzbroj> {
    private long idVozidla;
    private String nazov;
    private Narodnost narodnost;
    private double cena;
    private T1 podvozok;
    private T2 vyzbroj;

    public Vozidlo(long idVozidla, String nazov, Narodnost narodnost, double cena, T1 podvozok, T2 vyzbroj) {
        this.idVozidla = idVozidla;
        this.nazov = nazov;
        this.narodnost = narodnost;
        this.cena = cena;
        this.podvozok = podvozok;
        this.vyzbroj = vyzbroj;
    }
}
