package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Portal;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.InjuryInsurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.ValidityArea;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.InsuranceType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.LifeInsurance.InjuryInsuranceRes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class InjuryInsuranceController {

    @Autowired
    Portal portal;

    @GetMapping("/add/injury/{clientid}")
    public String addInjuryInsurance(@PathVariable long clientid, Model model)
    {
        InjuryInsuranceRes injuryInsuranceResource = new InjuryInsuranceRes();
        injuryInsuranceResource.setInsurerID(clientid);
        injuryInsuranceResource.setDateOfCreation(LocalDateTime.now());
        model.addAttribute("injuryInsuranceRes", injuryInsuranceResource);
        model.addAttribute("validityareaOptions", ValidityArea.values());
        return "/products/add/injury";
    }

    @PostMapping("/add/injury")
    public String submitInjuryInsurance(@ModelAttribute @Valid InjuryInsuranceRes injuryInsuranceResource, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("validityareaOptions", ValidityArea.values());
            return "/products/add/injury";
        }
        InjuryInsurance injuryInsurance = injuryInsuranceResource.newInsurance();
        portal.addInsuranceToClient(injuryInsurance, injuryInsurance.getInsurerID(), InsuranceType.INJURY);
        return "redirect:/products/detail/" + injuryInsurance.getInsurerID() + "/" + injuryInsurance.getInsuranceID();
    }


    @GetMapping("/edit/injury/{clientid}/{insuranceid}")
    public String editInjuryInsurance(@PathVariable long clientid, @PathVariable long insuranceid, Model model)
    {
        model.addAttribute("validityareaOptions", ValidityArea.values());
        model.addAttribute("injuryInsuranceRes", new InjuryInsuranceRes((InjuryInsurance) portal.getInsurance(clientid, insuranceid)));
        return "/products/edit/injury";
    }

    @PostMapping("/edit/injury")
    public String submitEditInjuryInsurance(@ModelAttribute @Valid InjuryInsuranceRes injuryInsuranceResource, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) {
            model.addAttribute("validityareaOptions", ValidityArea.values());
            return "/products/edit/injury";
        }

        long insuranceid = injuryInsuranceResource.getId();
        long clientid = injuryInsuranceResource.getInsurerID();

        InjuryInsurance injuryInsurance = (InjuryInsurance) portal.getInsurance(clientid, insuranceid);
        injuryInsurance = injuryInsuranceResource.editInsurance(injuryInsurance);
        portal.updateInsurance(injuryInsurance);
        return "redirect:/products/detail/" + clientid + "/" + insuranceid;
    }
}
