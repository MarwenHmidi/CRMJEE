package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entites.Employe;
import services.EmployeService;

@ManagedBean(name = "EmployeBean")
@SessionScoped
public class EmployeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private String login;
	private String password;
	private String bio;
	private String email;
	private String name;
	private  Employe employe= new Employe();
	private ArrayList<Employe> x;
	@EJB
	EmployeService employeService;
	
	public String addEmploye() { 
		employe.setLogin(login);
	employe.setEmail(email);
	employe.setPassword(password);
	employe.setBio(bio);
	employe.setName(name);
		employeService.ajouterEmp(employe);
		
			
			return "/pages/forum.jsf?face-redirect=true";
	
		
		}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public EmployeBean(String login, String password, String bio, String email, Employe employe) {
		super();
		this.login = login;
		this.password = password;
		this.bio = bio;
		this.email = email;
		this.employe = employe;
	}
	public void update()
	{Employe e= new Employe();
	e.setEmail(email);
	e.setLogin(login);
	e.setPassword(password);
	e.setName(name);
		employeService.updateEmploye(e);}
	public void delete (int id )
	{ 
		employeService.deleteEmployeById(id);}
	public void modifier(Employe e)
	{this.name=e.getName();
	this.email=e.getEmail();
	this.login=e.getLogin();
	this.password=e.getPassword();
		employeService.updateEmploye(e);}
	public ArrayList<Employe> getX() {
		return x;
	}

	public void setX(ArrayList<Employe> x) {
		this.x = x;
	}

	@PostConstruct
public void  init() {x=employeService.getAll(); }
	public EmployeBean() {
	
	}
}
