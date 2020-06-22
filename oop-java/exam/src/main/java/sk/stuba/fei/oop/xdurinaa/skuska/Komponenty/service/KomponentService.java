package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Komponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KomponentService {

    private Map<Long, Komponent> komponenty;

    KomponentService()
    {
        this.komponenty= new HashMap<>();
    }

    public void addKomponent(Komponent komponent)
    {
        this.komponenty.put(komponent.getIdKomponentu(),komponent);
    }

    public Komponent getKomponentByID(long idkomponentu)
    {
        return this.komponenty.get(idkomponentu);
    }
    public List<Komponent> getAllKomponent()
    {
        return new ArrayList<>(this.komponenty.values());
    }
}
