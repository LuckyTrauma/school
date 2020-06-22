package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Portal;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.FlatHouseInsurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.HouseType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.InsuranceType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.NonLifeInsurance.FlatHouseInsuranceRes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class FlatHouseInsuranceController {

    @Autowired
    Portal portal;

    @GetMapping("/add/flat-house/{clientid}")
    public String addHouseFlatInsurance(@PathVariable long clientid, Model model)
    {
        FlatHouseInsuranceRes flatHouseInsuranceRes = new FlatHouseInsuranceRes();
        flatHouseInsuranceRes.setInsurerID(clientid);
        flatHouseInsuranceRes.setDateOfCreation(LocalDateTime.now());
        model.addAttribute("flatHouseInsuranceRes", flatHouseInsuranceRes);
        model.addAttribute("housetypeOptions", HouseType.values());
        return "/products/add/flat-house";
    }

    @PostMapping("/add/flat-house")
    public String submitFlatHouseInsurance(@ModelAttribute @Valid FlatHouseInsuranceRes flatHouseInsuranceRes, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("housetypeOptions", HouseType.values());
            return "/products/add/flat-house";
        }
       FlatHouseInsurance flatHouseInsurance = flatHouseInsuranceRes.newInsurance();
        portal.addInsuranceToClient(flatHouseInsurance,flatHouseInsurance.getInsurerID(),InsuranceType.FLAT_HOUSE);
        return "redirect:/products/detail/" + flatHouseInsurance.getInsurerID() + "/" + flatHouseInsurance.getInsuranceID();
    }

    @GetMapping("/edit/flat-house/{clientid}/{insuranceid}")
    public String editHouseFlatInsurance(@PathVariable long clientid, @PathVariable long insuranceid, Model model)
    {
        model.addAttribute("housetypeOptions", HouseType.values());
        model.addAttribute("flatHouseInsuranceRes", new FlatHouseInsuranceRes((FlatHouseInsurance) portal.getInsurance(clientid, insuranceid)));
         return "/products/edit/flat-house";
    }

    @PostMapping("/edit/flat-house")
    public String submitEditHouseFlatInsurance(@ModelAttribute @Valid FlatHouseInsuranceRes flatHouseInsuranceRes, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) {
            model.addAttribute("housetypeOptions", HouseType.values());
            return "/products/edit/flat-house";
        }
        long insuranceid = flatHouseInsuranceRes.getId();
        long clientid = flatHouseInsuranceRes.getInsurerID();

        FlatHouseInsurance flatHouseInsurance = (FlatHouseInsurance) portal.getInsurance(clientid, insuranceid);
        flatHouseInsurance = flatHouseInsuranceRes.editInsurance(flatHouseInsurance);
        portal.updateInsurance(flatHouseInsurance);
        return "redirect:/products/detail/" + clientid + "/" + insuranceid;
    }
}
