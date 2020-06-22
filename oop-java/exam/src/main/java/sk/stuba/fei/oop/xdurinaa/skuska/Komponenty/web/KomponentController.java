package sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.oop.xdurinaa.skuska.Komponenty.service.KomponentService;

@Controller
@RequestMapping("/komponent")
public class KomponentController {
@Autowired
    private KomponentService komponentService;

    @GetMapping("/list")
    public String showListKomponentov(Model model)
    {
        model.addAttribute("listKomponentov", komponentService.getAllKomponent());
        return "/komponent/list";

    }
    @GetMapping ("/detail/{idkomponentu}")
    public String showDetailKomponentu(@PathVariable long idkomponentu, Model model)
    {
        model.addAttribute("komponent", komponentService.getKomponentByID(idkomponentu));
        return "/komponent/detail";
    }

}
