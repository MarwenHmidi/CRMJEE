package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entites.Commentaire;
import entites.Employe;
import entites.Post;
import services.CommentaireService;
import services.PostService;

@ManagedBean(name = "CommentaireBean")
@SessionScoped
public class CommentaireBean implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int id ;
private String text;
private Date date = Calendar.getInstance().getTime();
private Date pdate;
private String ptext;
private int pid;
private String login;
private String name;
private Long nb;
private Post z = new Post();
private ArrayList<Commentaire> x;

public Date getPdate() {
	return pdate;
}
public void setPdate(Date pdate) {
	this.pdate = pdate;
}
public ArrayList<Commentaire> getX() {
	return x;
}
public void setX(ArrayList<Commentaire> x) {
	this.x = x;
}
public String getPtext() {
	return ptext;
}
public void setPtext(String ptext) {
	this.ptext = ptext;
}
@EJB
CommentaireService cs;

Commentaire c = new Commentaire();
public ArrayList<Commentaire> getC(int id)
{
	return cs.getCommentsById(id);
	}
public String next(int a)
{
	this.id=a;
	return "/pages/post.jsf?face-redirect=true";
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String next2(Post aa)
{
	this.ptext=aa.getText();
	this.pdate=aa.getDate();
	this.name=cs.getEmp(aa.getEmploye().getEmp_id()).getName();
	this.pid=aa.getPost_id();
	return "/pages/post.jsf?face-redirect=true";
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public CommentaireBean() {
	super();
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String next1() {
	
	return "/pages/post.jsf?face-redirect=true";
}
@EJB
PostService postservice;
public void ajouter() {
	
	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
c.setText(text);
System.out.println("hedhi 1    "+text);
c.setDate(date);
System.out.println("hedhi 2    "+date);
Post aa = new Post();

aa.setPost_id(pid);
System.out.println("hedhi 3    "+pid);
LoginBean lb = new LoginBean();
Employe e=lb.getEmploye();


c.setEmploye(e);
System.out.println("hedhi 4    "+e.getEmp_id());
c.setPost(aa);
System.out.println("hedhi 5    "+aa.getPost_id());
cs.ajouter(c);
System.out.println("hedhi 6    "+c.getCom_id());
String mail=e.getEmail();
postservice.sendmail();
}

public void getPp()
{
	 //Post pp= new Post();
	//pp=cs.getPostById(id);
	//this.pdate=z.getDate();

  // this.ptext=z.getText();
	
	
}
public ArrayList<Commentaire> getAll()
{      x=cs.getCommentsById(pid);

	return x;}
public Long count(int zzz) { return cs.count(zzz); }
@PostConstruct
public void init() {x=cs.getCommentsById(pid);}

public ArrayList<Commentaire> getkol()
{
	x=cs.getall();
	return x;
}
}

