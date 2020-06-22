package sk.stuba.fei.oop.xdurinaa.zadanie3;

import org.springframework.stereotype.Service;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Client.Domain.Client;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Domain.Insurance;
import sk.stuba.fei.oop.xdurinaa.zadanie3.Products.Insurance.Web.InsuranceType;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Portal{

    private Map<Long, Client> clients;
    private Map<Long, InsuranceType> insuranceType;

    public Portal()
    {
        this.clients = new HashMap<>();
        this.insuranceType = new HashMap<>();
    }

    public void addClient(Client client) {
        if(client == null) throw new IllegalArgumentException("Cannot add client, client cannot be null");
        long id = client.getClientID();
        if(clients.containsKey(id)) throw new IllegalArgumentException("User ID already taken");
        clients.put(id, client);
    }

    public void updateClient(Client client) {
        if(client == null) throw new IllegalArgumentException("Cannot edit client, client cannot be null");
        long ID = client.getClientID();
        if(!clients.containsKey(ID)) throw new IllegalArgumentException("User with entered ID was not found ");
        clients.put(ID, client);
    }


    public Client getUserById(long userID) {
        if(!clients.containsKey(userID)) throw new IllegalArgumentException("User was not found");
        return clients.get(userID);
    }

    public void addInsuranceToClient(Insurance insurance, long userID, @NotNull InsuranceType insuranceType) {
        if(insurance == null) throw new IllegalArgumentException("Cannot add insurance, insurance cannot be null");
        if(insurance.getInsurerID() != userID) throw new IllegalArgumentException("Provided user ID does not match Insurer ID in the insurance");
        Client user = getUserById(userID);
        if(user.getInsurances().containsKey(insurance.getInsuranceID())) throw new IllegalArgumentException("Cannot add insurance , user already has a insurance with this ID");
        user.getInsurances().put(insurance.getInsuranceID(), insurance);
        this.insuranceType.put(insurance.getInsuranceID(), insuranceType);
    }

    public Insurance getInsurance(long insurerID, long contractId)
    {
        return getUserById(insurerID).getInsurances().get(contractId);
    }

    public InsuranceType getInsuranceType(long insuranceID)
    {
        return this.insuranceType.get(insuranceID);
    }

    public void updateInsurance(Insurance insurance) {
        if(insurance == null) throw new IllegalArgumentException("Cannot edit insurance, insurance cannot be null");
        Client user = getUserById(insurance.getInsurerID());
        if(!user.getInsurances().containsKey(insurance.getInsuranceID())) throw new IllegalArgumentException("Provided insurance does not exist and cannot be edited");
        user.getInsurances().put(insurance.getInsuranceID(), insurance);
    }

    public List<Insurance> getAllInsurances() {
        List<Insurance> allContracts = new ArrayList<>();
        for (Client user: clients.values()) {
            allContracts.addAll(user.getInsurances().values());
        }
        return allContracts;
    }

    public List<Client> getAllClients() {
        return new ArrayList<>(clients.values());
    }

    public List<Insurance> getAllInsurancesFromClient(long userID) {
        return new ArrayList<>(this.getUserById(userID).getInsurances().values());
    }

}
