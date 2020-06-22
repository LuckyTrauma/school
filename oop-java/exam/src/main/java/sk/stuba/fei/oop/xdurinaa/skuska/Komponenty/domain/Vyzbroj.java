package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Komponent;

@NoArgsConstructor
@Data
public abstract class Vyzbroj extends Komponent {

    public Vyzbroj(long idKomponentu, String nazov) {
        super(idKomponentu, nazov);
    }
}
