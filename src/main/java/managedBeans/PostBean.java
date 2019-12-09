package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entites.Commentaire;
import entites.Post;
import services.PostService;

@ManagedBean(name = "PostBean")
@ApplicationScoped
public class PostBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date = Calendar.getInstance().getTime();
	private Post post=new Post();

	private 
	@EJB
	PostService postservice;
	public  String ajouter()
	
	{
		
		
		post.setDate(date);
	post.setText(text);
	LoginBean lb = new LoginBean();
	post.setEmploye(lb.getEmploye());
		postservice.ajouterpost(post);
		
		return "/pages/forum.jsf?face-redirect=true";
		
	}
	public PostBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	

}
