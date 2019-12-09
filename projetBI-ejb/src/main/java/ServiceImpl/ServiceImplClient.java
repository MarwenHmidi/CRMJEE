package ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Client;
import Service.ServiceClient;

@Stateless
@LocalBean
public class ServiceImplClient implements ServiceClient{
	public List<Client> listclient=new ArrayList<Client>();
	@PersistenceContext(unitName="primary")
	EntityManager em;

	@Override

	public void ajouterClient(Client client) {
    em.persist(client);
	}

	@Override
	
	public void supprimerClient(int id) {
		Client es=new Client();
		es=em.find(Client.class, id);
		em.remove(es);
	}

	@Override

	public void modifierClient(Client client) {
	
	em.merge(client);
		
		
		
	}

	@Override
	public List<Client> afficherClient() {
		List<Client> emp = em.createQuery("Select t from Client t", Client.class).getResultList();
		return emp;
	}
	
	@Override
	public List<Client> getAllClients() {
		List<Client> emp = em.createQuery("Select p from Client p", Client.class).getResultList();
		return emp;
	}

	@Override
	public Client getClientByEmailAndPassword(String email, String password) {
		TypedQuery<Client> query = 
				em.createQuery("select e from Client e WHERE e.email=:email and e.password=:password ", Client.class); 
		query.setParameter("email", email); 
		query.setParameter("password", password);
		Client client = null;
		try {
			client = query.getSingleResult(); 
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return client;
	}

	@Override
	public List<Client> SortByPointMerci() {
		TypedQuery<Client> query = em.createQuery("select e from Client e ORDER BY e.pointmerci DESC", Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

}
