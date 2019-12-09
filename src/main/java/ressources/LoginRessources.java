package ressources;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entites.Employe;
import services.EmployeService;

@Path("login/{login}/{password}")
@SessionScoped
public class LoginRessources {

	@EJB
	EmployeService es;
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Employe login(@PathParam("login") String login,@PathParam("password") String password) {
		return es.getEmployeByEmailAndPassword(login, password);
	}
}
