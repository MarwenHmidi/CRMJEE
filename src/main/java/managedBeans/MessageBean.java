package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entites.Employe;
import entites.Message;
import services.MessageService;

@ManagedBean(name = "MessageBean")
@SessionScoped
public class MessageBean implements Serializable {
	private ArrayList<Message> m;
	private String login;
	private String text;
	LoginBean lb = new LoginBean();
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


	private static final long serialVersionUID = 1L;
	@EJB
	MessageService ms;
	public ArrayList<Message> getM() {
		return m;
	}
	public MessageBean() {
		// TODO Auto-generated constructor stub
	}


	public void setM(ArrayList<Message> m) {
		this.m = m;
	}


	public void getall() {
		m=ms.getall(lb.getEmploye().getEmp_id());
	}
	

	public MessageBean(ArrayList<Message> m, MessageService ms) {
		super();
		this.m = m;
		this.ms = ms;
	}
	public String add()
	{Message m = new Message();
	Employe e = new Employe();
	LoginBean lb= new LoginBean();
	m.setContenu(text);
	e=ms.getEmp(login);
	m.setEmploye_dest_id(e.getEmp_id());
	m.setEmploye_sender(lb.getEmploye());
	ms.envoyerMessage(m);
	return "/pages/forum.jsf?face-redirect=true";
	}


	@PostConstruct
	public void init() {m=ms.getall(lb.getEmploye().getEmp_id());}
}
