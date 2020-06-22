package sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.oop.xdurinaa.skuska.Vozidla.service.VozidloService;

@Controller
@RequestMapping("/vozidlo")
public class VozidloController {

    @Autowired
    private VozidloService vozidloService;

    @GetMapping("/list")
    public String showListVozidiel(Model model)
    {
        model.addAttribute("listVozidiel", vozidloService.getAllVozidla());
        return "/vozidlo/list";

    }
    @GetMapping ("/detail/{idvozidla}")
    public String showDetailVozidla(@PathVariable long idvozidla, Model model)
    {
        model.addAttribute("detailVozidla",vozidloService.getVozidlobyId(idvozidla));
                return "/vozidlo/detail";
    }

}
