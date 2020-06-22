package sk.stuba.fei.oop.xdurinaa.skuska;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Delo.DeloVelkyKaliber;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Podvozok.Pasovy;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.domain.Veza;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.service.KomponentService;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Narodnost;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.domain.Tanky.TazkyTank;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.service.VozidloService;
@Controller
@SpringBootApplication
public class SkuskaApplication implements CommandLineRunner {

    @Autowired
    private VozidloService vozidloService;
    @Autowired
    private KomponentService komponentService;

    public static void main(String[] args) {
        SpringApplication.run(SkuskaApplication.class, args);
    }
    @RequestMapping("/")
    public String showDefaultPage()
    {
        return "redirect:/vozidlo/list";
    }
    @Override
    public void run(String... args) throws Exception
    {
        Pasovy pasovy = new Pasovy(0,"IS-3M",40,25,30,550);
        DeloVelkyKaliber deloVelkyKaliber = new DeloVelkyKaliber(1,"122mm BL-9",25,45,50,120 );
        Veza<DeloVelkyKaliber> veza = new Veza<DeloVelkyKaliber>(2,"IS-3",50.0,3500.0);
        TazkyTank tazkyTank = new TazkyTank(0,"IS-3", Narodnost.ZSSR,2000000,pasovy,veza);
        komponentService.addKomponent(pasovy);
        komponentService.addKomponent(deloVelkyKaliber);
        komponentService.addKomponent(veza);
        vozidloService.addVozidlo(tazkyTank);
    }
}
