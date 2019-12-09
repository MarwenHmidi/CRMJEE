package managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.LikeComService;

@ManagedBean(name = "LikeComBean")
@SessionScoped
public class LikeComBean implements Serializable{
	@EJB
	LikeComService ls = new LikeComService();
	//private int com_id;
	public void like(int com_id)
	{
		boolean a;
		LoginBean lb = new LoginBean();
		int emp_id;
		emp_id=lb.getEmploye().getEmp_id();
		
		a=ls.addLike(emp_id, com_id);
		if(!a) {FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("Vous avez deja aimé ce commentaire! "));}
		
		
	}
	
	public LikeComBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
