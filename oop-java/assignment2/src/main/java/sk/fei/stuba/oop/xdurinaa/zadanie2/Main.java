package sk.fei.stuba.oop.xdurinaa.zadanie2;

import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Address;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.ClientService;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life.TravelInsurance;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Products.Insurance.Life.TravelTarget;


import java.time.LocalDate;

public class Main {

        public static void main(String[] args) {
            ClientService service = new ClientService();
            Address adresa = new Address(94911, "Nitra", "Tokajska", 8);
            Address adresa2 = new Address(94911,"Nitra","Tokajska",9);
            Client poistenec = new Client("Name","Surname","birth",adresa,"email@.");
            Client poistovatel =new Client("Name2","Surname2","birth2",adresa2,"email2@.");
            service.addUser(poistenec);
            poistenec.addInsurance(new TravelInsurance(poistovatel, LocalDate.of(2020, 5, 10), LocalDate.of(2022, 5, 10), 10000, 200, poistenec,true, TravelTarget.RECREATIONAL));
            System.out.println(poistenec.toString());
            System.out.println();

            Client poistenec2 = new Client("Name2","Surname2","birth",adresa2,"email@.");
            Client poistenec3 = new Client("Name3","Surname3","birth",adresa2,"email@.");
            service.addUser(poistenec2);
            service.addUser(poistenec3);
            System.out.println(service.getAllClients());
        }
    }

