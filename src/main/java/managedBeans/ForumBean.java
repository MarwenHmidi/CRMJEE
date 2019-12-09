package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entites.Post;
import services.ForumService;

@ManagedBean(name = "ForumBean")
@SessionScoped
public class ForumBean implements Serializable {
	private ArrayList<Post>  p;
	@EJB
	ForumService fs;
	public ArrayList<Post>  getall()
	{ 
		
		p=fs.getallPosts();
		return p;
	
	}
	
	

	public ArrayList<Post>  getP() {
		return p;
	}
	public void setP(ArrayList<Post>  p) {
		this.p = p;
	}
	@PostConstruct
	public void init() {p=getall();}
	public String next1() {
		
		return "/pages/post.jsf?face-redirect=true";
	}

	
	
	

}
