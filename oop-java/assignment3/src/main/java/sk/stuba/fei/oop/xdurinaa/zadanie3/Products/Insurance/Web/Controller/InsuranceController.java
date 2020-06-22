package sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Portal;

@Controller
@RequestMapping("/products")
public class InsuranceController {

    @Autowired
    Portal portal;

    @GetMapping("/add/{clientid}")
    public String selectNewInsurance(@PathVariable long clientid, Model model)
    {
        model.addAttribute("clientid", clientid);
        return "/products/add/switch";
    }

    @GetMapping("/detail/{clientid}/{insuranceid}")
    public String showInsuranceDetail(@PathVariable long clientid, @PathVariable long insuranceid, Model model)
    {
        model.addAttribute("insurance", portal.getInsurance(clientid, insuranceid));
        return "/products/detail/" + portal.getInsuranceType(insuranceid).getView();
    }

    @GetMapping("/edit/{clientid}/{insuranceid}")
    public String editInsurance(@PathVariable long clientid, @PathVariable long insuranceid, Model model)
    {
        return "redirect:/products/edit/" + portal.getInsuranceType(insuranceid).getView() + "/" + clientid + "/" + insuranceid;
    }
}
