package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Portal;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.TravelInsurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.TravelTarget;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.InsuranceType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.LifeInsurance.TravelInsuranceRes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class TravelInsuranceController {

    @Autowired
    Portal portal;

    @GetMapping("/add/travel/{clientid}")
    public String addTravelInsurance(@PathVariable long clientid, Model model)
    {
        TravelInsuranceRes travelInsuranceResource = new TravelInsuranceRes();
        travelInsuranceResource.setInsurerID(clientid);
        travelInsuranceResource.setDateOfCreation(LocalDateTime.now());
        model.addAttribute("travelInsuranceRes", travelInsuranceResource);
        model.addAttribute("traveltargetOptions", TravelTarget.values());
        return "/products/add/travel";
    }

    @PostMapping("/add/travel")
    public String submitTravelInsurance(@ModelAttribute @Valid TravelInsuranceRes travelInsuranceResource, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("traveltargetOptions", TravelTarget.values());
            return "/products/add/travel";
        }
        TravelInsurance travelInsurance = travelInsuranceResource.newInsurance();
        portal.addInsuranceToClient(travelInsurance, travelInsurance.getInsurerID(), InsuranceType.TRAVEL);
        return "redirect:/products/detail/" + travelInsurance.getInsurerID() + "/" + travelInsurance.getInsuranceID();
    }

    @GetMapping("/edit/travel/{clientid}/{insuranceid}")
    public String editTravelInsurance(@PathVariable long clientid, @PathVariable long insuranceid, Model model)
    {
        model.addAttribute("travelInsuranceRes", new TravelInsuranceRes((TravelInsurance) portal.getInsurance(clientid, insuranceid)));
        model.addAttribute("traveltargetOptions", TravelTarget.values());
        return "/products/edit/travel";
    }

    @PostMapping("/edit/travel")
    public String submitEditTravelInsurance(@ModelAttribute @Valid TravelInsuranceRes travelInsuranceRes, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) {
                        model.addAttribute("traveltargetOptions", TravelTarget.values());
            return "/products/edit/travel";
        }
        long clientid = travelInsuranceRes.getInsurerID();
        long insuranceid = travelInsuranceRes.getId();

        TravelInsurance travelInsurance = (TravelInsurance) portal.getInsurance(clientid, insuranceid);
        travelInsurance = travelInsuranceRes.editInsurance(travelInsurance);
        portal.updateInsurance(travelInsurance);
        return "redirect:/products/detail/" + clientid + "/" + insuranceid;
    }
}
