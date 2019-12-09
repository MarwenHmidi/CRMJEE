package Service;

import java.util.List;

import javax.ejb.Remote;

import model.Client;

@Remote

public interface ServiceClient {
public void ajouterClient(Client client);
public void supprimerClient(int id);
public void modifierClient(Client client);
public List<Client> afficherClient();
public List<Client> getAllClients();
public Client getClientByEmailAndPassword(String email, String password);
public List<Client> SortByPointMerci();
}
