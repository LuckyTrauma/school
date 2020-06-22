package sk.stuba.fei.oop.xdurinaa.zadanie3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Address;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Client;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.TravelInsurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Life.TravelTarget;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.InsuranceType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@SpringBootApplication
public class Zadanie3Application implements CommandLineRunner {
	@Autowired
	private Portal portal;

	@GetMapping
	public String index()
	{
		return "redirect:/client/list";
	}

	@Override
	public void run(String... args) throws Exception {
		Address address = new Address(94901, "Nitra", "Tokajska", 18);
		Address address2 = new Address(95502, "Bratislava", "Staré Grunty", 53);
		Client client = new Client("Andrew", "Nuts", "09856/0844",address,"Andrew.Nuts@xmail.com");
		Client client2 = new Client( "Diego", "Maradona", "95585/8574",  address2, address,"diego.maradona@xmail.com");

		portal.addClient(client);
		portal.addClient(client2);

		TravelInsurance travelInsurance = new TravelInsurance(client.getClientID(), LocalDateTime.now(),LocalDate.now(),LocalDate.now(), 2000, 20,client2.getClientID(),false,TravelTarget.RECREATIONAL);
		portal.addInsuranceToClient(travelInsurance, 0, InsuranceType.TRAVEL);
	}

	public static void main(String[] args) {
		SpringApplication.run(Zadanie3Application.class, args);
		System.out.println("Go to http://localhost:8080/");
	}

}