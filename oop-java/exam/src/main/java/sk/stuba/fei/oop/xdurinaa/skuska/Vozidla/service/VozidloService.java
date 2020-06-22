package sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.service;

import org.springframework.stereotype.Service;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Vozidlo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VozidloService {

    private Map<Long , Vozidlo> vozidla;

    VozidloService()
    {
        this.vozidla= new HashMap<>();
    }

    public void addVozidlo(Vozidlo vozidlo)
    {
        this.vozidla.put(vozidlo.getIdVozidla(),vozidlo);
    }

    public Vozidlo getVozidlobyId(long idvozidla)
    {
        return this.vozidla.get(idvozidla);
    }
    public List<Vozidlo> getAllVozidla()
    {
        return new ArrayList<Vozidlo>(this.vozidla.values());
    }
}
