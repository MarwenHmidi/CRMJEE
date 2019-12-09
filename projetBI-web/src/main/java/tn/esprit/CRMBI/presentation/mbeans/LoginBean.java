package tn.esprit.CRMBI.presentation.mbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ServiceImpl.ServiceImplClient;
import ServiceImpl.ServiceImplUser;
import model.Client;
import model.User;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private Client client;
	private User user;
	private Boolean loggedIn;

	@EJB
	ServiceImplClient implClient;
	@EJB
	ServiceImplUser implUser;
	

	public String doLogin() {
		String navigateTo = "null";
		client = implClient.getClientByEmailAndPassword(login, password);
		user = implUser.getUserByEmailAndPassword(login, password);
		if (client != null) {
			navigateTo = "/quiz?faces-redirect=true";
			loggedIn = true;
		}else if(user != null && user.getRole() == 0)
		{
			navigateTo = "/listClients?faces-redirect=true";
			loggedIn = true;
		}
		else { FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials"));
		}

		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
