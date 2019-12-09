package tn.esprit.CRMBI.presentation.mbeans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Client;
import ServiceImpl.ServiceImplClient;

@ManagedBean(name = "ClientBean")
public class ClientBean {

	@ManagedProperty(value = "#{LoginBean}")
	private  LoginBean loginBean;
	
	private int idClient;

	private Date birthDate;

	private int clientType;

	private String email;

	private String lastName;

	private String name;

	private String password;

	private String phoneNumber;

	private int pointmerci;


	private List<Client> Clients;
	private List<Client> clients2;
	private int ClientToBeUpdate;

	@EJB
	ServiceImplClient serviceImplClient;

	@PostConstruct
	public void init() {
		this.Clients = serviceImplClient.getAllClients();
	}

	public String AddClient() {
		String navigateTo = null;
		Client client = new Client();
		client.setName(name);
		client.setLastName(lastName);
		client.setBirthDate(birthDate);
		client.setEmail(email);
		client.setPhoneNumber(phoneNumber);
		client.setPassword(password);
		client.setPointmerci(pointmerci);
		serviceImplClient.ajouterClient(client);
		navigateTo = "/listClients?faces-redirect=true";
		return navigateTo;
	}
	
	public void updatepointMerci()
	{
		
		if(QuizBean.result==2)
		{
			Client x = loginBean.getClient();
			x.setPointmerci(x.getPointmerci() + 200);
			serviceImplClient.modifierClient(x);
			System.out.println("lenna");
		}else if(QuizBean.result==1) {
			Client x = loginBean.getClient();
			x.setPointmerci(x.getPointmerci() - 50);
			serviceImplClient.modifierClient(x);
			System.out.println("lenna");
		}else {
			Client x = loginBean.getClient();
			x.setPointmerci(x.getPointmerci() - 100);
			serviceImplClient.modifierClient(x);
			System.out.println("lenna");
		}
	}

	public String DisplayClient(Client client) {
		String navigateTo = null;
		this.setClientToBeUpdate(client.getIdClient());
		this.setName(client.getName());
		this.setLastName(client.getLastName());
		this.setBirthDate(client.getBirthDate());
		this.setEmail(client.getEmail());
		this.setPhoneNumber(client.getPhoneNumber());
		this.setPassword(client.getPassword());
		this.setPointmerci(client.getPointmerci());
		navigateTo = "/ModifierClient?faces-redirect=true";
		return navigateTo;
	}

	public String UpdateClient() {
		String navigateTo = null;
		Client x = new Client(ClientToBeUpdate, birthDate, clientType, email, name, lastName, password, phoneNumber,
				pointmerci);
		serviceImplClient.modifierClient(x);
		navigateTo = "/listClients?faces-redirect=true";
		return navigateTo;

	}
	public String ListSortByPoint()
	{
		String navigateTo = null;
		
		navigateTo = "/listClients2?faces-redirect=true";
		this.clients2 = serviceImplClient.SortByPointMerci();	
		return navigateTo;
	}

	public String removeClient(int id) {
		String navigateTo = null;
		serviceImplClient.supprimerClient(id);
		navigateTo = "/listClients?faces-redirect=true";
		return navigateTo;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getClientType() {
		return clientType;
	}

	public void setClientType(int clientType) {
		this.clientType = clientType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getPointmerci() {
		return pointmerci;
	}

	public void setPointmerci(int pointmerci) {
		this.pointmerci = pointmerci;
	}

	public List<Client> getClients() {
		Clients = serviceImplClient.getAllClients();
		return Clients;
	}

	public void setClients(List<Client> clients) {
		Clients = clients;
	}

	public ServiceImplClient getServiceImplClient() {
		return serviceImplClient;
	}

	public void setServiceImplClient(ServiceImplClient serviceImplClient) {
		this.serviceImplClient = serviceImplClient;
	}

	public int getClientToBeUpdate() {
		return ClientToBeUpdate;
	}

	public void setClientToBeUpdate(int clientToBeUpdate) {
		ClientToBeUpdate = clientToBeUpdate;
	}
	

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<Client> getClients2() {
	
		return clients2;
	}

	public void setClients2(List<Client> clients2) {
		this.clients2 = clients2;
	}
	

	
	
	

}
