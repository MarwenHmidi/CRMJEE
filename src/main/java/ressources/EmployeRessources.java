package ressources;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entites.Employe;

import services.EmployeService;

@Path("Employe")
@SessionScoped
public class EmployeRessources {
	@EJB
	EmployeService cs;
	@Path("/get")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employe> getAll() {
		List<Employe> l;
		l = cs.getAll();
		return l;
	}
	@DELETE
	@Path("/delete/{id}")
	public Response delete(@PathParam(value="id") int id )
	{
		if(cs.getAll().stream().anyMatch(obj -> obj.getEmp_id() == id)) {
	cs.deleteEmployeById(id);
	return Response.status(Status.GONE).entity("true").build();
	}
		return Response.status(Status.NOT_FOUND).entity("false").build();
	}
	@POST
	@Path("/ajout")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmp(Employe e){
		cs.ajouterEmp(e);
			return Response.status(Status.CREATED).build();
			}
}
