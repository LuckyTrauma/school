package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Portal;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.HomeInsurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.NonLife.HouseType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.InsuranceType;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Resources.NonLifeInsurance.HomeInsuranceRes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/products")
public class HomeInsuranceController {

    @Autowired
    Portal portal;

    @GetMapping("/add/home/{clientid}")
    public String addHomeInsurance(@PathVariable long clientid, Model model)
    {
        HomeInsuranceRes homeInsuranceRes = new HomeInsuranceRes();
        homeInsuranceRes.setInsurerID(clientid);
        homeInsuranceRes.setDateOfCreation(LocalDateTime.now());
        model.addAttribute("homeInsuranceRes", homeInsuranceRes);
        model.addAttribute("housetypeOptions", HouseType.values());
        return "/products/add/home";
    }

    @PostMapping("/add/home")
    public String submitHomeInsurance(@ModelAttribute @Valid HomeInsuranceRes homeInsuranceResource, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("housetypeOptions", HouseType.values());
            return "/products/add/home";
        }
        HomeInsurance homeInsurance = homeInsuranceResource.newInsurance();
        portal.addInsuranceToClient(homeInsurance, homeInsurance.getInsurerID(), InsuranceType.HOME);
        return "redirect:/products/detail/" + homeInsurance.getInsurerID() + "/" + homeInsurance.getInsuranceID();
    }

    @GetMapping("/edit/home/{clientid}/{insuranceid}")
    public String editHomeInsurance(@PathVariable long clientid, @PathVariable long insuranceid, Model model)
    {
        model.addAttribute("housetypeOptions", HouseType.values());
        model.addAttribute("homeInsuranceRes", new HomeInsuranceRes((HomeInsurance) portal.getInsurance(clientid, insuranceid)));
        return "/products/edit/home";
    }

    @PostMapping("/edit/home")
    public String submitEditHomeInsurance(@ModelAttribute @Valid HomeInsuranceRes homeInsuranceResource, BindingResult bindingResult, Model model)
    {
        if(bindingResult.hasErrors()) {
            model.addAttribute("housetypeOptions", HouseType.values());
            return "/products/edit/home";
        }
        long insuranceid = homeInsuranceResource.getId();
        long clientid = homeInsuranceResource.getInsurerID();

        HomeInsurance homeInsurance = (HomeInsurance) portal.getInsurance(clientid, insuranceid);
        homeInsurance = homeInsuranceResource.editInsurance(homeInsurance);
        portal.updateInsurance(homeInsurance);
        return "redirect:/products/detail/" + clientid + "/" + insuranceid;
    }

}
