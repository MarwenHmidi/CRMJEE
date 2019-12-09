package managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entites.Employe;
import services.EmployeService;


@ManagedBean(name = "loginBean")
@SessionScoped
public   class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  String login;
	private String password;
	private static Employe employe;
	private Boolean loggedIn;
	@EJB
	EmployeService employeService;
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
	public Employe getEmploye() {
		return employe;
	}
	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	public Boolean getLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public EmployeService getEmployeService() {
		return employeService;
	}
	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	public String doLogin() {
		String navigateTo = "null";
		employe = employeService.getEmployeByEmailAndPassword(login, password);
		if (employe != null) {
			navigateTo = "/pages/forum.jsf?face-redirect=true";
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("aaslema"));
			loggedIn = true;
		} else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Bad Credentials "+login+"+"+password));
			
			
		}
		return navigateTo;
	}

}
