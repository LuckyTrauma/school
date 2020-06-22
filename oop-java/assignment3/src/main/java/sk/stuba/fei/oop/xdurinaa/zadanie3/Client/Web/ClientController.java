package sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Client;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Portal;

import javax.validation.Valid;

@Controller
@RequestMapping("/client")
public class ClientController {

        @Autowired
        private Portal portal;

        @GetMapping("/list")
        public String findAllClients(Model model)
        {
            model.addAttribute("clients", portal.getAllClients());
            return "client/list";
        }

        @GetMapping("/detail/{id}")
        public String showClientDetail(@PathVariable long id, Model model)
        {
            model.addAttribute("client", portal.getUserById(id));
            model.addAttribute("insurances", portal.getAllInsurancesFromClient(id));
            return "/client/detail";
        }

        @GetMapping("/edit/{id}")
        public String editClient(@PathVariable long id, Model model)
        {
            model.addAttribute("clientResource", new ClientResource(portal.getUserById(id)));
            return "/client/edit";
        }

        @PostMapping("/edit")
        public String submitEditClient(@ModelAttribute @Valid ClientResource clientResource, BindingResult bindingResult, Model model)
        {
            try {
                clientResource.getCorrespondenceAddress();
            }
            catch(IllegalArgumentException e) {
                model.addAttribute("crpAddressError", e.getMessage());
                return "/client/add";
            }

            if(bindingResult.hasErrors()) {
                return "/client/edit";
            }
            long id = clientResource.getClientID();
            Client client = portal.getUserById(id);
            client = clientResource.modifyClient(client);
            portal.updateClient(client);
            return "redirect:/client/detail/" + id;
        }

        @GetMapping("/add")
        public String addClient(Model model)
        {
            model.addAttribute("clientResource", new ClientResource());
            return "/client/add";
        }

        @PostMapping("/add")
        public String submitAddClient(@ModelAttribute @Valid ClientResource clientResource, BindingResult bindingResult, Model model)
        {
            try {
                clientResource.getCorrespondenceAddress();
            }
            catch(IllegalArgumentException e) {
                model.addAttribute("crpAddressError", e.getMessage());
                return "/client/add";
            }

            if(bindingResult.hasErrors())
                return "/client/add";
            Client newClient = clientResource.createNewClient();
            portal.addClient(newClient);
            return "redirect:/client/detail/" + newClient.getClientID();
        }
    }

