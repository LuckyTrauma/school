package sk.fei.stuba.oop.xdurinaa.zadanie2.Client;
import sk.fei.stuba.oop.xdurinaa.zadanie2.Client.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientService {

    private List<Client> clients = new ArrayList<>();

    public void addUser(Client client) {
        if (client == null) throw new IllegalArgumentException("Insurer must be included");
        if (clients.contains(client)) throw new IllegalStateException("User is identical");
        clients.add(client);
    }
    public void updateClient(Client client, int i) {
        if (i < 0) throw new IllegalArgumentException("Index cannot be less than zero");
        clients.set(i, client);
    }
    public Client getClient(int i) {
        return clients.get(i);
    }
    public List<Client> getAllClients(){
        return clients;
    }
    public Client getClient(UUID id) {
        for (Client client : clients) {
            if (client.getUserID() == id) return client;
        }
        return null;
    }
}
