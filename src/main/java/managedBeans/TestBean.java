package managedBeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import services.EmployeService;

@ManagedBean(name = "TestBean")
@ApplicationScoped
public class TestBean implements Serializable {
	@EJB
	EmployeService es = new EmployeService();
	public void delete(int id)
	{es.deleteEmployeById(id); System.out.println("aaaaaaa");}
	public void delete1(int id)
	{es.deleteEmployeById1(id);}
}
